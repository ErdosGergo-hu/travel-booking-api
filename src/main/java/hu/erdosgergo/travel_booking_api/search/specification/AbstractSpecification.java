package hu.erdosgergo.travel_booking_api.search.specification;

import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

//TODO: A több státusz (IN) szűrés bevezetése, FieldName annotáció bevezetése a map helyére

@NoArgsConstructor
public abstract class AbstractSpecification<C, T> {

    public Specification<T> build(C criteria, Class<T> entityClass) {
        Specification<T> spec = Specification.unrestricted();

        if (criteria == null) {
            return spec;
        }

        Map<String, String> fieldMapping = getFieldMapping();

        for (Field field : criteria.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            Object value;
            try {
                value = field.get(criteria);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Failed to read criteria field: " + field.getName(), e);
            }

            if (value == null) {
                continue;
            }

            if (value instanceof String s && s.isBlank()) {
                continue;
            }

            String criteriaFieldName = field.getName();

            String entityPath = fieldMapping.getOrDefault(criteriaFieldName, criteriaFieldName);

            // skip helper/global fields if needed
            if ("query".equals(criteriaFieldName)) {
                spec = spec.and(buildPredicate("item.name", value));
            } else {
                spec = spec.and(buildPredicate(entityPath, value));
            }
        }

        return spec;
    }

    private Specification<T> buildPredicate(String entityPath, Object value) {
        return (root, query, cb) -> {
            Path<?> path = resolvePath(root, entityPath);

            // String -> like ignore case
            if (value instanceof String s) {
                return cb.like(cb.lower(path.as(String.class)), "%" + s.toLowerCase() + "%");
            }

            // Number / Boolean / ENUM / others -> equal
            return cb.equal(path, value);
        };
    }

    private Path<?> resolvePath(Root<?> root, String path) {
        Path<?> current = root;
        for (String part : path.split("\\.")) {
            current = current.get(part);
        }
        return current;
    }

    private Map<String, String> getFieldMapping() {
        Map<String, String> mapping = new HashMap<>();

        // criteria field -> entity field
        mapping.put("category", "item.category");
        mapping.put("status", "item.status");
        mapping.put("name", "item.name");

        // range fields map to same entity field
//        mapping.put("minCurrentBid", "currentBid");
//        mapping.put("maxCurrentBid", "currentBid");

        return mapping;
    }
}