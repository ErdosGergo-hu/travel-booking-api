package hu.erdosgergo.online_auction_api.dto;

import java.time.LocalDateTime;

public record ApiError(
        LocalDateTime timestamp,
        int status,
        String message) {
}
