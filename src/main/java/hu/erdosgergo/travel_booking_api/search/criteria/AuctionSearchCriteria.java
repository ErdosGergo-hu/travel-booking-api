package hu.erdosgergo.travel_booking_api.search.criteria;

import hu.erdosgergo.travel_booking_api.enums.AuctionStatus;
import hu.erdosgergo.travel_booking_api.enums.Category;
import hu.erdosgergo.travel_booking_api.search.FieldName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AuctionSearchCriteria extends SearchCriteria {

    @FieldName(name = "item.category")
    private Category category;

    @FieldName(name = "item.name")
    private String name;

    private AuctionStatus status;
}

