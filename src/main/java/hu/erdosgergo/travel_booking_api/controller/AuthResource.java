package hu.erdosgergo.travel_booking_api.controller;

import hu.erdosgergo.travel_booking_api.dto.request.LoginRequest;
import hu.erdosgergo.travel_booking_api.dto.request.RefreshRequest;
import hu.erdosgergo.travel_booking_api.dto.request.RegisterRequest;
import hu.erdosgergo.travel_booking_api.dto.response.AuthResponse;
import hu.erdosgergo.travel_booking_api.dto.response.UserResponse;
import hu.erdosgergo.travel_booking_api.service.AuthService;
import hu.erdosgergo.travel_booking_api.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class AuthResource {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/register")
    public AuthResponse register(@Valid @RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @PostMapping("/refresh")
    public AuthResponse refresh(@Valid @RequestBody RefreshRequest request) {
        return authService.refresh(request);
    }

    @PostMapping("/logout")
    public void logout(@NotBlank String email) {
        authService.logout(email);
    }

    @GetMapping("/me")
    public UserResponse me(Authentication authentication) {
        return userService.me(authentication);
    }
}
