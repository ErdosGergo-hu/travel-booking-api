package hu.erdosgergo.travel_booking_api.service;

import hu.erdosgergo.travel_booking_api.repository.UserDashboardViewRepository;
import hu.erdosgergo.travel_booking_api.view.UserDashboardView;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDashboardViewService {

    private final UserDashboardViewRepository repository;

    public List<UserDashboardView> findAll() {
        return repository.findAll();
    }
}
