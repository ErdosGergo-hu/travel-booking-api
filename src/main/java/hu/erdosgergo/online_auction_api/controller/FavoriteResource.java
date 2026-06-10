package hu.erdosgergo.online_auction_api.controller;

import hu.erdosgergo.online_auction_api.dto.request.FavoriteToggleRequest;
import hu.erdosgergo.online_auction_api.dto.response.FavoriteResponse;
import hu.erdosgergo.online_auction_api.dto.response.FavoriteToggleResponse;
import hu.erdosgergo.online_auction_api.service.FavoriteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorite")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class FavoriteResource {

    private final FavoriteService favoriteService;

    @GetMapping("/user/{userId}")
    public List<FavoriteResponse> getUserFavorites(@PathVariable Long userId) {
        return favoriteService.getUserFavorites(userId);
    }

    @PostMapping
    public FavoriteToggleResponse toggleFavorite(@RequestBody @Valid FavoriteToggleRequest request) {
        return favoriteService.toggleFavorite(request);
    }
}
