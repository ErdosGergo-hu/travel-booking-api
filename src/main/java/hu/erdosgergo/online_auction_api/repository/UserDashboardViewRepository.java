package hu.erdosgergo.online_auction_api.repository;

import hu.erdosgergo.online_auction_api.view.UserDashboardView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDashboardViewRepository extends JpaRepository<UserDashboardView, Long> {
}
