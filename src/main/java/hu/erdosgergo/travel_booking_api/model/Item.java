package hu.erdosgergo.travel_booking_api.model;

import hu.erdosgergo.travel_booking_api.enums.Category;
import hu.erdosgergo.travel_booking_api.enums.ItemStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "ITEMS")
@FieldNameConstants
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    private Long id;

    private String name;

    private String description;

    private String imageUrl;

    private Integer quantity;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    @Enumerated
    private ItemStatus itemStatus;
}
