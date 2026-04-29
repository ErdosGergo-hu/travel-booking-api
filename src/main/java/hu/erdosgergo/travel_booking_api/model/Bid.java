package hu.erdosgergo.travel_booking_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "BIDS")
@FieldNameConstants
@AllArgsConstructor
@NoArgsConstructor
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "auction_id")
    private Auction auction;

    private String bidderName; // TODO: User entitás

    @Column(nullable = false)
    private BigDecimal amountHuf;

    @Column(nullable = false)
    private LocalDateTime createdAt;
}