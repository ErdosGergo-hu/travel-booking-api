package hu.erdosgergo.online_auction_api.dto.response;

import lombok.Data;

import java.time.Instant;

@Data
public class FavoriteResponse {
    private Long id;

    private UserResponse user;

    private AuctionResponse auction;

    private Instant createdAt;

    private boolean favorite;
}
