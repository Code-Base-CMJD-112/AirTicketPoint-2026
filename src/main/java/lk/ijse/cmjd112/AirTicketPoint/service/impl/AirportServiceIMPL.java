package lk.ijse.cmjd112.AirTicketPoint.service.impl;

import lk.ijse.cmjd112.AirTicketPoint.dto.AirportDTO;
import lk.ijse.cmjd112.AirTicketPoint.service.AirportService;

import java.util.List;

public class AirportServiceIMPL implements AirportService {
    @Override
    public AirportDTO saveAirport(AirportDTO airportDTO) {
        return null;
    }

    @Override
    public AirportDTO getSelectedAirport(String airportId) {
        return null;
    }

    @Override
    public List<AirportDTO> getAllAirports() {
        return List.of();
    }

    @Override
    public void deleteAirport(String airportId) {

    }

    @Override
    public void updateAirport(String airportId, AirportDTO airportDTO) {

    }
}
