package hu.erdosgergo.online_auction_api.search.criteria;

import lombok.Data;

@Data
public abstract class SearchCriteria {
    private String query;
}
