package hu.erdosgergo.online_auction_api.dto.response;

import hu.erdosgergo.online_auction_api.enums.Category;
import hu.erdosgergo.online_auction_api.enums.ItemStatus;

public record ItemResponse (
    Long id,

    String name,

    String description,

    String imageUrl,

    Integer quantity,

    Category category,

    ItemStatus itemStatus
){ }
