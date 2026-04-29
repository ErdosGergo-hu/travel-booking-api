package hu.erdosgergo.travel_booking_api.service;

import hu.erdosgergo.travel_booking_api.dto.request.CreateBidRequest;
import hu.erdosgergo.travel_booking_api.dto.response.AuctionResponse;
import hu.erdosgergo.travel_booking_api.mapper.AuctionMapper;
import hu.erdosgergo.travel_booking_api.search.criteria.ItemSearchCriteria;
import hu.erdosgergo.travel_booking_api.model.Auction;
import hu.erdosgergo.travel_booking_api.repository.AuctionRepository;
import hu.erdosgergo.travel_booking_api.search.specification.AuctionSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Slf4j
@Service
public class AuctionService {

    private final AuctionRepository repository;

    private final AuctionSpecification auctionSpecification;

    private final BidService bidService;

    private final AuctionMapper mapper;

    public AuctionService(AuctionRepository repository, AuctionSpecification auctionSpecification, BidService bidService, AuctionMapper mapper) {
        this.repository = repository;
        this.auctionSpecification = auctionSpecification;
        this.bidService = bidService;
        this.mapper = mapper;
    }

    public AuctionResponse getResponseById(Long id) {
        Auction auction = getAuctionById(id);
        return getResponseByAuction(auction);
    }

    private AuctionResponse getResponseByAuction(Auction auction) {
        AuctionResponse response = mapper.toResponse(auction);
        int bidCountForAuction = bidService.getBidCountForAuction(auction.getId());
        response.setBidCount(bidCountForAuction);
        return response;
    }

    @Transactional
    private Auction getAuctionById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Transactional
    public Auction updateAuctionByPrice(Long id, BigDecimal newPrice) {
        Auction auction = repository.findById(id).orElseThrow();
        if(auction.getCurrentPriceHuf().compareTo(newPrice) > 0) {
            throw new RuntimeException("The new Bid value is lower than the previous value!");
        }
        auction.setCurrentPriceHuf(newPrice);

        bidService.createBidByAuction(auction);
        return repository.save(auction);
    }

    public AuctionResponse updateAuctionByRequest(Long id, CreateBidRequest request) {
        Auction auction = updateAuctionByPrice(id, request.newPrice());
        return getResponseByAuction(auction);
    }

    public Page<Auction> search(ItemSearchCriteria criteria, Object value, Pageable pageable) {
        if(criteria == null) {
            return repository.findAll(pageable);
        }

        Specification<Auction> spec = auctionSpecification.build(criteria, Auction.class);

        return repository.findAll(spec, pageable);
    }

}
