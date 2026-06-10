package hu.erdosgergo.online_auction_api.view;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;

@Getter
@Immutable
@Entity
public class UserDashboardView {

    @Id
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "finished_auctions")
    private Long finishedAuctions;

    @Column(name = "active_listings")
    private Long activeListings;

    private BigDecimal earnings;

    private BigDecimal spent;
}
