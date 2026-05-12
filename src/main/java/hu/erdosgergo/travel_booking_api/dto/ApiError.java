package hu.erdosgergo.travel_booking_api.dto;

import java.time.LocalDateTime;

public record ApiError(
        LocalDateTime timestamp,
        int status,
        String message) {
}
