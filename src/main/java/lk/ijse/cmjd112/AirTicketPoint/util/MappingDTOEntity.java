package lk.ijse.cmjd112.AirTicketPoint.util;

import lk.ijse.cmjd112.AirTicketPoint.dto.AirportDTO;
import lk.ijse.cmjd112.AirTicketPoint.dto.UserDTO;
import lk.ijse.cmjd112.AirTicketPoint.entities.AirportEntity;
import lk.ijse.cmjd112.AirTicketPoint.entities.UserEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

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
    public List<AirportDTO> getAirportDTOList(List<AirportEntity> airportEntities){
        return modelMapper.map(airportEntities, new TypeToken<List<AirportDTO>>(){}.getType());
    }
    //User
    public UserDTO toUserDTO(UserEntity userEntity){
        return modelMapper.map(userEntity, UserDTO.class);
    }
    public UserEntity toUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, UserEntity.class);
    }
    public List<UserDTO> getuserDTOList(List<UserEntity> userEntities){
        return modelMapper.map(userEntities, new TypeToken<List<UserDTO>>(){}.getType());
    }
}
