package hu.erdosgergo.travel_booking_api.service;

import hu.erdosgergo.travel_booking_api.dto.response.BidResponse;
import hu.erdosgergo.travel_booking_api.mapper.BidMapper;
import hu.erdosgergo.travel_booking_api.model.Auction;
import hu.erdosgergo.travel_booking_api.model.Bid;
import hu.erdosgergo.travel_booking_api.repository.BidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BidService {

    private final BidRepository repository;
    private final BidMapper mapper;
    private final UserService userService;

    @Transactional
    public void createBidByAuction(Auction auction) {
        Bid bid = new Bid();
        bid.setAuction(auction);
        bid.setCreatedAt(LocalDateTime.now());
        bid.setAmountHuf(auction.getCurrentPriceHuf());
        bid.setBidder(userService.getCurrentUser());
        repository.save(bid);
    }

    public int getBidCountForAuction(Long auctionId) {
        return repository.countByAuctionId(auctionId);
    }

    public List<BidResponse> getBidByAuction(Long auctionId) {
        List<Bid> bids = repository.findAllByAuctionIdOrderByIdDesc(auctionId);
        return mapper.toResponseList(bids);
    }
}
