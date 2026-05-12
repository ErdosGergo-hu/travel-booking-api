package hu.erdosgergo.travel_booking_api.exception;

import java.math.BigDecimal;

public class BidTooLowException extends RuntimeException {

    public BidTooLowException(BigDecimal currentHighestBid, BigDecimal attemptedBid) {
        super("Bid must be higher than current highest bid. Current: "
                + currentHighestBid + ", attempted: " + attemptedBid);
    }
}