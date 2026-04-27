package hu.erdosgergo.travel_booking_api.service;

import hu.erdosgergo.travel_booking_api.search.criteria.ItemSearchCriteria;
import hu.erdosgergo.travel_booking_api.model.Auction;
import hu.erdosgergo.travel_booking_api.repository.AuctionRepository;
import hu.erdosgergo.travel_booking_api.search.specification.AuctionSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuctionService {

    private final AuctionRepository repository;

    private final AuctionSpecification auctionSpecification;

    public AuctionService(AuctionRepository repository, AuctionSpecification auctionSpecification) {
        this.repository = repository;
        this.auctionSpecification = auctionSpecification;
    }

    public Auction getAuctionById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Page<Auction> search(ItemSearchCriteria criteria, Object value, Pageable pageable) {
        if(criteria == null) {
            return repository.findAll(pageable);
        }

        Specification<Auction> spec = auctionSpecification.build(criteria, Auction.class);

        return repository.findAll(spec, pageable);
    }

}
