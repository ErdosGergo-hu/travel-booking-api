package hu.erdosgergo.travel_booking_api.controller;

import hu.erdosgergo.travel_booking_api.search.criteria.ItemSearchCriteria;
import hu.erdosgergo.travel_booking_api.model.Auction;
import hu.erdosgergo.travel_booking_api.service.AuctionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auction")
@CrossOrigin(origins = "http://localhost:5173")
public class AuctionResource {

    private final AuctionService auctionService;

    public AuctionResource(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @GetMapping("/{id}")
    public Auction getAuction(@PathVariable Long id) {
        return auctionService.getAuctionById(id);
    }

    @GetMapping("/search")
    public Page<Auction> getPageableAuctions(
            @RequestParam(required = false, defaultValue = "") Object value,
            ItemSearchCriteria itemSearchCriteria,
            Pageable pageable) {
        return auctionService.search(itemSearchCriteria, value, pageable);
    }
}
