package hu.erdosgergo.travel_booking_api.search.criteria;

import hu.erdosgergo.travel_booking_api.enums.Category;
import hu.erdosgergo.travel_booking_api.enums.ItemStatus;
import lombok.Data;

@Data
public class ItemSearchCriteria {
    private String query;
    private Category category;
    private ItemStatus status;
    private String search;
    private String name;
}
