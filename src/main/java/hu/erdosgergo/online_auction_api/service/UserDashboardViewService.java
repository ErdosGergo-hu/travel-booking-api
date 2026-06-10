package hu.erdosgergo.online_auction_api.service;

import hu.erdosgergo.online_auction_api.repository.UserDashboardViewRepository;
import hu.erdosgergo.online_auction_api.view.UserDashboardView;
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

    public UserDashboardView findById(Long userId) {
        return repository.findById(userId).orElse(null);
    }
}
