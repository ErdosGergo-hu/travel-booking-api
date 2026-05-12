package hu.erdosgergo.travel_booking_api.controller;

import hu.erdosgergo.travel_booking_api.service.UserDashboardViewService;
import hu.erdosgergo.travel_booking_api.service.UserService;
import hu.erdosgergo.travel_booking_api.view.UserDashboardView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;
    private final UserDashboardViewService userDashboardViewService;

    @GetMapping("/dashboard")
    public List<UserDashboardView> getDashboardUsers() {
        return userDashboardViewService.findAll();
    }
}
