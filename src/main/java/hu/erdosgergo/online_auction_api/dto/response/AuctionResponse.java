package hu.erdosgergo.online_auction_api.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AuctionResponse {
    Long id;
    ItemResponse item;
    BigDecimal startingPriceHuf;
    BigDecimal currentPriceHuf;
    LocalDateTime startDateTime;
    LocalDateTime endDateTime;
    int bidCount;
    UserResponse seller;
    UserResponse bidder;
    boolean isFavorite;
}


