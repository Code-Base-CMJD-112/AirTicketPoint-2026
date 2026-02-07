package lk.ijse.cmjd112.AirTicketPoint.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd112.AirTicketPoint.dao.AirportDao;
import lk.ijse.cmjd112.AirTicketPoint.dto.AirportDTO;
import lk.ijse.cmjd112.AirTicketPoint.entities.AirportEntity;
import lk.ijse.cmjd112.AirTicketPoint.exception.DataNotFoundException;
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
                -> new DataNotFoundException("Data Not Found"));
        return mappingDTOEntity.toAirportDTO(foundAirport);
    }

    @Override
    public List<AirportDTO> getAllAirports() {
         return mappingDTOEntity.getAirportDTOList(airportDao.findAll());
    }

    @Override
    public void deleteAirport(String airportId) {
        airportDao.findById(airportId).orElseThrow(()
                -> new DataNotFoundException("Data Not Found"));
        airportDao.deleteById(airportId);
    }

    @Override
    public void updateAirport(String airportId, AirportDTO airportDTO) {
        var foundAirport = airportDao.findById(airportId).orElseThrow(()
                -> new DataNotFoundException("Data Not Found"));

        foundAirport.setAirportCode(airportDTO.getAirportCode());
        foundAirport.setAirportName(airportDTO.getAirportName());
        foundAirport.setCity(airportDTO.getCity());
        foundAirport.setCountry(airportDTO.getCountry());

    }
}
