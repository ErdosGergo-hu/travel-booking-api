package hu.erdosgergo.travel_booking_api.service;

import hu.erdosgergo.travel_booking_api.dto.response.UserResponse;
import hu.erdosgergo.travel_booking_api.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    public User getCurrentUser() {
        return (User) Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getPrincipal();
    }

    public UserResponse me(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        if (user == null) {
            throw new UsernameNotFoundException("Cannot find the logged in User!");
        }
        return UserResponse.builder().id(user.getId())
                .email(user.getEmail())
                .avatarUrl(user.getAvatarUrl())
                .createdAt(user.getCreatedAt())
                .username(user.getUsername())
                .build();
    }
}
