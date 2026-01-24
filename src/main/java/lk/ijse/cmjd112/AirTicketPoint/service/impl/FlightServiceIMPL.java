package lk.ijse.cmjd112.AirTicketPoint.service.impl;

import lk.ijse.cmjd112.AirTicketPoint.dto.FlightDTO;
import lk.ijse.cmjd112.AirTicketPoint.service.FlightService;
import lk.ijse.cmjd112.AirTicketPoint.util.IDGenerator;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FlightServiceIMPL implements FlightService {
    @Override
    public FlightDTO saveFlight(FlightDTO flightDTO) {
        flightDTO.setFlightId(IDGenerator.flightIDGen());
        return flightDTO;
    }

    @Override
    public FlightDTO getSelectedFlight(String flightId) {
        return null;
    }

    @Override
    public List<FlightDTO> getAllFlights() {
        return List.of();
    }

    @Override
    public void deleteFlight(String flightId) {

    }

    @Override
    public void updateFlight(String flightId, FlightDTO flightDTO) {

    }
}
