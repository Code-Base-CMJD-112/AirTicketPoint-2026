package lk.ijse.cmjd112.AirTicketPoint.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "airport")
public class AirportEntity {
    @Id
    private String airportId;
    private String airportCode;
    private String airportName;
    private String city;
    private String country;
}
