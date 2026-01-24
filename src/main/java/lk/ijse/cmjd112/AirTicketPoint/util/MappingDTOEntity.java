package lk.ijse.cmjd112.AirTicketPoint.util;

import lk.ijse.cmjd112.AirTicketPoint.dto.AirportDTO;
import lk.ijse.cmjd112.AirTicketPoint.entities.AirportEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MappingDTOEntity {
    private final ModelMapper modelMapper;

    //Airport
    public AirportDTO toAirportDTO(AirportEntity airportEntity){
        return modelMapper.map(airportEntity, AirportDTO.class);
    }
    public AirportEntity toAirportEntity(AirportDTO airportDTO){
        return modelMapper.map(airportDTO, AirportEntity.class);
    }
}
