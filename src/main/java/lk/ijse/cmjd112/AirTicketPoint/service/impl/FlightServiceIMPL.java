package lk.ijse.cmjd112.AirTicketPoint.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd112.AirTicketPoint.dao.AirportDao;
import lk.ijse.cmjd112.AirTicketPoint.dao.FlightDao;
import lk.ijse.cmjd112.AirTicketPoint.dto.FlightDTO;
import lk.ijse.cmjd112.AirTicketPoint.entities.AirportEntity;
import lk.ijse.cmjd112.AirTicketPoint.entities.FlightEntity;
import lk.ijse.cmjd112.AirTicketPoint.exception.DataNotFoundException;
import lk.ijse.cmjd112.AirTicketPoint.service.FlightService;
import lk.ijse.cmjd112.AirTicketPoint.util.IDGenerator;
import lk.ijse.cmjd112.AirTicketPoint.util.MappingDTOEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class FlightServiceIMPL implements FlightService {
    private final FlightDao flightDao;
    private final MappingDTOEntity mappingDTOEntity;
    private final AirportDao airportDao;


    @Override
    public void saveFlight(FlightDTO flightDTO) {
        var arrAirport = airportDao.findAirportByAirportCode(flightDTO.getArrivalAirportId())
                .orElseThrow(() -> new DataNotFoundException("Arrival Airport Not Found"));

        var depAirport = airportDao.findAirportByAirportCode(flightDTO.getDepartureAirportId())
                .orElseThrow(() -> new DataNotFoundException("Departure Airport Not Found"));

        var flightEntity = mappingDTOEntity.toFlightEntity(flightDTO);
        flightEntity.setFlightId(IDGenerator.flightIDGen());
        flightEntity.setArrivalAirport(arrAirport);
        flightEntity.setDepartureAirport(depAirport);
        flightDao.save(flightEntity);
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
