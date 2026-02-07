package lk.ijse.cmjd112.AirTicketPoint.entities;

import jakarta.persistence.*;
import lk.ijse.cmjd112.AirTicketPoint.dto.FlightStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "flights")
public class FlightEntity implements Serializable {
    @Id
    private String flightId;
    private String flightNo;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int totalSeats;
    private int availableSeats;
    private double baseFare;
    @Enumerated(EnumType.STRING)
    private FlightStatus status;
    @JoinColumn(name = "dep_airport")
    @ManyToOne(fetch = FetchType.LAZY)
    private AirportEntity departureAirport;
    @JoinColumn (name = "arr_airprt")
    @ManyToOne(fetch = FetchType.LAZY)
    private AirportEntity arrivalAirport;
}
