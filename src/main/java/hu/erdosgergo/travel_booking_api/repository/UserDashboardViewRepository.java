package hu.erdosgergo.travel_booking_api.repository;

import hu.erdosgergo.travel_booking_api.view.UserDashboardView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDashboardViewRepository extends JpaRepository<UserDashboardView, Long> {
}
