package lk.ijse.cmjd112.AirTicketPoint.service;

import lk.ijse.cmjd112.AirTicketPoint.dto.AirportDTO;
import lk.ijse.cmjd112.AirTicketPoint.dto.FlightDTO;

import java.util.List;

public interface FlightService {
    void saveFlight(FlightDTO flightDTO);
    FlightDTO getSelectedFlight(String flightId);
    List<FlightDTO> getAllFlights ();
    void deleteFlight(String flightId);
    void updateFlight(String flightId,FlightDTO flightDTO);
}
