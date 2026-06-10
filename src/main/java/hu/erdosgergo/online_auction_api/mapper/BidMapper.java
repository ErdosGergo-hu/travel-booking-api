package hu.erdosgergo.online_auction_api.mapper;

import hu.erdosgergo.online_auction_api.dto.response.BidResponse;
import hu.erdosgergo.online_auction_api.model.Bid;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BidMapper {

    BidResponse toResponse(Bid bid);

    List<BidResponse> toResponseList(List<Bid> bids);
}
