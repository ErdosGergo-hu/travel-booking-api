package hu.erdosgergo.travel_booking_api.service;

import hu.erdosgergo.travel_booking_api.model.Auction;
import hu.erdosgergo.travel_booking_api.model.Bid;
import hu.erdosgergo.travel_booking_api.repository.BidRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class BidService {

    private final BidRepository repository;

    public BidService(BidRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void createBidByAuction(Auction auction) {
        Bid bid = new Bid();
        bid.setAuction(auction);
        bid.setCreatedAt(LocalDateTime.now());
        bid.setAmountHuf(auction.getCurrentPriceHuf());
        bid.setBidderName("Kecske");
        repository.save(bid);
    }

    public int getBidCountForAuction(Long auctionId) {
        return repository.countByAuctionId(auctionId);
    }
}
