package lk.ijse.cmjd112.AirTicketPoint.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd112.AirTicketPoint.dao.BookingDao;
import lk.ijse.cmjd112.AirTicketPoint.dao.PassengerDao;
import lk.ijse.cmjd112.AirTicketPoint.dto.PassengerDTO;
import lk.ijse.cmjd112.AirTicketPoint.entities.BookingEntity;
import lk.ijse.cmjd112.AirTicketPoint.entities.PassengerEntity;
import lk.ijse.cmjd112.AirTicketPoint.exception.DataNotFoundException;
import lk.ijse.cmjd112.AirTicketPoint.service.PassengerService;
import lk.ijse.cmjd112.AirTicketPoint.util.IDGenerator;
import lk.ijse.cmjd112.AirTicketPoint.util.MappingDTOEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PassengerServiceIMPL implements PassengerService {

    private final MappingDTOEntity mappingDTOEntity;
    private final PassengerDao passengerDao;
    private final BookingDao  bookingDao;

    @Override
    public void savePassenger(PassengerDTO passengerDTO) {
        var foundBooking = bookingDao.findById(passengerDTO.getBookingId())
                .orElseThrow(() -> new DataNotFoundException("Booking not found"));

        var passengerEntity = mappingDTOEntity.toPassengerEntity(passengerDTO);
        passengerEntity.setPassengerId(IDGenerator.passengerIDGen());
        passengerEntity.setBookingId(foundBooking);
        passengerDao.save(passengerEntity);
    }

    @Override
    public PassengerDTO getSelectedPassenger(String passengerId) {
        var foundPassenger = passengerDao.findById(passengerId)
                .orElseThrow(() -> new DataNotFoundException("Passenger not found"));
        return mappingDTOEntity.toPassengerDTO(foundPassenger);

    }

    @Override
    public List<PassengerDTO> getAllPassengers() {
        return mappingDTOEntity.getPassengerDTOList(passengerDao.findAll());
    }

    @Override
    public void deletePassenger(String passengerId) {
    passengerDao.findById(passengerId)
                .orElseThrow(() -> new DataNotFoundException("Passenger not found"));
    passengerDao.deleteById(passengerId);

    }

    @Override
    public void updatePassenger(String passengerId, PassengerDTO passengerDTO) {
        var foundPassenger = passengerDao.findById(passengerId)
                .orElseThrow(() -> new DataNotFoundException("Passenger not found"));

        var foundBooking = bookingDao.findById(passengerDTO.getBookingId())
                .orElseThrow(() -> new DataNotFoundException("Booking not found"));

        foundPassenger.setFirstName(passengerDTO.getFirstName());
        foundPassenger.setLastName(passengerDTO.getLastName());
        foundPassenger.setAge(passengerDTO.getAge());
        foundPassenger.setSeatNumber(passengerDTO.getSeatNumber());
        foundPassenger.setBookingId(foundBooking);
    }
}
