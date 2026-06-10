package hu.erdosgergo.online_auction_api.dto.request;

import jakarta.validation.constraints.NotNull;

public record FavoriteToggleRequest(
        @NotNull Long auctionId,
        @NotNull Long userId
) {}
