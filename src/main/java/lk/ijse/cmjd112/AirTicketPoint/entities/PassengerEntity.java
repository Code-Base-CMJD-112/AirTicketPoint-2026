package lk.ijse.cmjd112.AirTicketPoint.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "passenger")
public class PassengerEntity implements Serializable {
    @Id
    private String passengerId;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String contactNumber;
    private String seatNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "booking_id")
    private BookingEntity bookingId;
}
