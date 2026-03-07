package lk.ijse.cmjd112.AirTicketPoint.util;

import lk.ijse.cmjd112.AirTicketPoint.dto.*;
import lk.ijse.cmjd112.AirTicketPoint.entities.*;
import lk.ijse.cmjd112.AirTicketPoint.entities.secure.UserEntity;
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
    //Booking
    public BookingDTO toBookingDTO(BookingEntity bookingEntity){
        return modelMapper.map(bookingEntity, BookingDTO.class);
    }
    public BookingEntity toBookingEntity(BookingDTO bookingDTO){
        return modelMapper.map(bookingDTO, BookingEntity.class);
    }
    public List<BookingDTO> getBookingDTOList(List<BookingEntity> bookingEntities){
        return modelMapper.map(bookingEntities, new TypeToken<List<BookingDTO>>(){}.getType());
    }
    //Flight
    public FlightDTO toFlightDTO(FlightEntity flightEntity){
        return modelMapper.map(flightEntity, FlightDTO.class);
    }
    public FlightEntity toFlightEntity(FlightDTO flightDTO){
        return modelMapper.map(flightDTO, FlightEntity.class);
    }
    public List<FlightDTO> getFlightDTOList(List<FlightEntity> flightEntityList){
        return modelMapper.map(flightEntityList, new TypeToken<List<FlightDTO>>(){}.getType());
    }

    //Passenger
    public PassengerDTO toPassengerDTO(PassengerEntity passengerEntity){
        return modelMapper.map(passengerEntity, PassengerDTO.class);
    }
    public PassengerEntity toPassengerEntity(PassengerDTO passengerDTO){
        return modelMapper.map(passengerDTO, PassengerEntity.class);
    }
    public List<PassengerDTO> getPassengerDTOList(List<PassengerEntity> passengerEntityList){
        return modelMapper.map(passengerEntityList, new TypeToken<List<PassengerDTO>>(){}.getType());
    }

}
