package hu.erdosgergo.travel_booking_api.controller;

import hu.erdosgergo.travel_booking_api.dto.request.LoginRequest;
import hu.erdosgergo.travel_booking_api.dto.request.RefreshRequest;
import hu.erdosgergo.travel_booking_api.dto.request.RegisterRequest;
import hu.erdosgergo.travel_booking_api.dto.response.AuthResponse;
import hu.erdosgergo.travel_booking_api.service.AuthService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class AuthResource {

    private final AuthService authService;

    /**
     * POST /api/auth/register
     * Body: { fullName, email, password }
     */
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    /**
     * POST /api/auth/login
     * Body: { email, password }
     */
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    /**
     * POST /api/auth/refresh
     * Body: { refreshToken }
     */
    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refresh(@Valid @RequestBody RefreshRequest request) {
        return ResponseEntity.ok(authService.refresh(request));
    }

    /**
     * POST /api/auth/logout
     * Requires Authorization: Bearer <token>
     */
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@NotBlank String email) {
        authService.logout(email);
        return ResponseEntity.noContent().build();
    }
}
