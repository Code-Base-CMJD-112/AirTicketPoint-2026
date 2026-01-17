package lk.ijse.cmjd112.AirTicketPoint.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDTO implements Serializable {
    private String bookingId;
    private String bookingRef;
    private LocalDateTime bookingDate;
    private int seatCount;
    private double totalAmount;
    private BookingStatus status;
    private String userId;
    private String flightId;
}
