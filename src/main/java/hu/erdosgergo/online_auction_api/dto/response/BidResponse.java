package hu.erdosgergo.online_auction_api.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BidResponse {

    private Long id;

    private AuctionResponse auction;

    private UserResponse bidder;

    private BigDecimal amountHuf;

    private LocalDateTime createdAt;
}
