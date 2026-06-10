package hu.erdosgergo.online_auction_api.exception;

public class OwnAuctionException extends RuntimeException {
    public OwnAuctionException() {
        super("You cannot Bid on your own Auction!");
    }
}
