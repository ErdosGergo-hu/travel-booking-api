package hu.erdosgergo.online_auction_api.mapper;

import hu.erdosgergo.online_auction_api.dto.response.AuctionResponse;
import hu.erdosgergo.online_auction_api.model.Auction;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuctionMapper {

    AuctionResponse toResponse(Auction auction);

    List<AuctionResponse> toResponseList(List<Auction> auctions);
}
