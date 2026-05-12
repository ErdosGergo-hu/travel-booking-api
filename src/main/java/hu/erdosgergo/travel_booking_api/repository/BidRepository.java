package hu.erdosgergo.travel_booking_api.repository;

import hu.erdosgergo.travel_booking_api.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BidRepository extends JpaRepository<Bid, Long>, JpaSpecificationExecutor<Bid> {

    int countByAuctionId(Long id);

    List<Bid> findAllByAuctionIdOrderByIdDesc(Long auctionId);
}

