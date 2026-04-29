package hu.erdosgergo.travel_booking_api.dto.request;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateBidRequest(
        @NotNull BigDecimal newPrice
) {}