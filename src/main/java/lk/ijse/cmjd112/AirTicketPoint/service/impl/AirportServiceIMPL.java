package lk.ijse.cmjd112.AirTicketPoint.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd112.AirTicketPoint.dao.AirportDao;
import lk.ijse.cmjd112.AirTicketPoint.dto.AirportDTO;
import lk.ijse.cmjd112.AirTicketPoint.entities.AirportEntity;
import lk.ijse.cmjd112.AirTicketPoint.service.AirportService;
import lk.ijse.cmjd112.AirTicketPoint.util.IDGenerator;
import lk.ijse.cmjd112.AirTicketPoint.util.MappingDTOEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AirportServiceIMPL implements AirportService {
    private final AirportDao airportDao;
    private final MappingDTOEntity mappingDTOEntity;

    @Override
    public void saveAirport(AirportDTO airportDTO) {
        airportDTO.setAirportId(IDGenerator.airportIDGen());
        var airportEntity = mappingDTOEntity.toAirportEntity(airportDTO);
        airportDao.save(airportEntity);
    }

    @Override
    public AirportDTO getSelectedAirport(String airportId) {
        //Find the record exist
        var foundAirport = airportDao.findById(airportId).orElseThrow(()
                -> new RuntimeException("Data Not Found"));
        return mappingDTOEntity.toAirportDTO(foundAirport);
    }

    @Override
    public List<AirportDTO> getAllAirports() {
         return mappingDTOEntity.getAirportDTOList(airportDao.findAll());
    }

    @Override
    public void deleteAirport(String airportId) {
        System.out.println("Deleted airport: "+airportId);
    }

    @Override
    public void updateAirport(String airportId, AirportDTO airportDTO) {
        airportDTO.setAirportId(airportId);
        System.out.println("Updated updatedAirport ID: "+airportId);
        System.out.println("Updated updatedAirport details: "+airportDTO);

    }
}
