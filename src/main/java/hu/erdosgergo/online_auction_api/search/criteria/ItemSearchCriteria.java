package hu.erdosgergo.online_auction_api.search.criteria;

import hu.erdosgergo.online_auction_api.enums.Category;
import hu.erdosgergo.online_auction_api.enums.ItemStatus;
import lombok.Data;

@Data
public class ItemSearchCriteria {
    private String query;
    private Category category;
    private ItemStatus status;
    private String search;
    private String name;
}
