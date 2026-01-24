package lk.ijse.cmjd112.AirTicketPoint.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PassengerDTO implements Serializable {
    private String passengerId;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String contactNumber;
    private String seatNumber;
    private String bookingId;
}
