package lk.ijse.cmjd112.AirTicketPoint.entities;

import jakarta.persistence.*;
import lk.ijse.cmjd112.AirTicketPoint.dto.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "booking")
public class BookingEntity implements Serializable {
    @Id
    private String bookingId;
    private LocalDateTime bookingDate;
    private int seatCount;
    private double totalAmount;
    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id")
    private FlightEntity flight;


}
