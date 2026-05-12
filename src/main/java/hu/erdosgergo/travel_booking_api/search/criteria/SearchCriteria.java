package hu.erdosgergo.travel_booking_api.search.criteria;

import lombok.Data;

@Data
public abstract class SearchCriteria {
    private String query;
}
