package hu.erdosgergo.travel_booking_api.controller;

import hu.erdosgergo.travel_booking_api.dto.response.BidResponse;
import hu.erdosgergo.travel_booking_api.service.BidService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bid")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class BidResource {

    private final BidService bidService;

    @GetMapping("/auction/{auctionId}")
    public List<BidResponse> getBidsByAuction(@PathVariable Long auctionId){
        return bidService.getBidByAuction(auctionId);
    }
}
