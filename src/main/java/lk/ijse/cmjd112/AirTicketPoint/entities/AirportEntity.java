package lk.ijse.cmjd112.AirTicketPoint.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AirportEntity {
    private String airportId;
    private String airportCode;
    private String airportName;
    private String city;
    private String country;
}
