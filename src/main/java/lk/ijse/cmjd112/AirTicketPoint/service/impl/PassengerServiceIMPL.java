package lk.ijse.cmjd112.AirTicketPoint.service.impl;

import lk.ijse.cmjd112.AirTicketPoint.dto.PassengerDTO;
import lk.ijse.cmjd112.AirTicketPoint.service.PassengerService;
import lk.ijse.cmjd112.AirTicketPoint.util.IDGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceIMPL implements PassengerService {
    @Override
    public PassengerDTO savePassenger(PassengerDTO passengerDTO) {
        passengerDTO.setPassengerId(IDGenerator.passengerIDGen());
        return passengerDTO;
    }

    @Override
    public PassengerDTO getSelectedPassenger(String passengerId) {
        return null;
    }

    @Override
    public List<PassengerDTO> getAllPassengers() {
        return List.of();
    }

    @Override
    public void deletePassenger(String passengerId) {

    }

    @Override
    public void updatePassenger(String passengerId, PassengerDTO passengerDTO) {

    }
}
