package hu.erdosgergo.travel_booking_api.dto.response;

import hu.erdosgergo.travel_booking_api.enums.Category;
import hu.erdosgergo.travel_booking_api.enums.ItemStatus;

public record ItemResponse (
    Long id,

    String name,

    String description,

    String imageUrl,

    Integer quantity,

    Category category,

    ItemStatus itemStatus
){ }
