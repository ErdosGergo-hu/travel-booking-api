package hu.erdosgergo.online_auction_api.mapper;

import hu.erdosgergo.online_auction_api.dto.response.FavoriteResponse;
import hu.erdosgergo.online_auction_api.model.Favorite;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FavoriteMapper {

    FavoriteResponse toResponse(Favorite favorite);

    List<FavoriteResponse> toResponseList(List<Favorite> favoriteList);
}
