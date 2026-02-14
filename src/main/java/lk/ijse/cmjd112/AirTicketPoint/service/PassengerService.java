package lk.ijse.cmjd112.AirTicketPoint.service;

import lk.ijse.cmjd112.AirTicketPoint.dto.AirportDTO;
import lk.ijse.cmjd112.AirTicketPoint.dto.PassengerDTO;

import java.util.List;

public interface PassengerService {
    void savePassenger(PassengerDTO passengerDTO);
    PassengerDTO getSelectedPassenger(String passengerId);
    List<PassengerDTO> getAllPassengers();
    void deletePassenger (String passengerId);
    void updatePassenger (String passengerId,PassengerDTO passengerDTO);
}
