package lk.ijse.cmjd112.AirTicketPoint.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd112.AirTicketPoint.dao.BookingDao;
import lk.ijse.cmjd112.AirTicketPoint.dao.FlightDao;
import lk.ijse.cmjd112.AirTicketPoint.dao.UserDao;
import lk.ijse.cmjd112.AirTicketPoint.dto.BookingDTO;
import lk.ijse.cmjd112.AirTicketPoint.entities.BookingEntity;
import lk.ijse.cmjd112.AirTicketPoint.entities.FlightEntity;
import lk.ijse.cmjd112.AirTicketPoint.entities.UserEntity;
import lk.ijse.cmjd112.AirTicketPoint.exception.DataNotFoundException;
import lk.ijse.cmjd112.AirTicketPoint.exception.DataSaveException;
import lk.ijse.cmjd112.AirTicketPoint.service.BookingService;
import lk.ijse.cmjd112.AirTicketPoint.util.DateTimeUtil;
import lk.ijse.cmjd112.AirTicketPoint.util.IDGenerator;
import lk.ijse.cmjd112.AirTicketPoint.util.MappingDTOEntity;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class BookingServiceIMPL implements BookingService {
    private final BookingDao bookingDao;
    private final MappingDTOEntity mappingDTOEntity;
    private final UserDao userDao;
    private final FlightDao flightDao;

    @Override
    public void saveBooking(BookingDTO booking) {
        var extractFlight = flightDao.findById(booking.getFlightId())
                .orElseThrow(() -> new DataNotFoundException("Flight Not Found"));

        var extractUser = userDao.findById(booking.getUserId())
                .orElseThrow(() -> new DataNotFoundException("User Not Found"));

        var bookingEntity = mappingDTOEntity.toBookingEntity(booking);
        bookingEntity.setBookingId(IDGenerator.bookingIDGen());
        bookingEntity.setBookingDate(booking.getBookingDate() == null ? DateTimeUtil.currentDateTime()
                : booking.getBookingDate());
        bookingEntity.setFlight(extractFlight);
        bookingEntity.setUser(extractUser);

        //seat avilability
        if(flightDao.getAvlSeats(booking.getFlightId()) < booking.getSeatCount()){
            throw new DataSaveException("No avilable seats");
        }
        bookingDao.save(bookingEntity);
        //deduct avl seats
        flightDao.deductAvlSeatCount(booking.getSeatCount(),booking.getFlightId());
    }

    @Override
    public void updateBooking(String bookingId, BookingDTO booking) {
        var extractFlight = flightDao.findById(booking.getFlightId())
                .orElseThrow(() -> new DataNotFoundException("Flight Not Found"));

        var extractUser = userDao.findById(booking.getUserId())
                .orElseThrow(() -> new DataNotFoundException("User Not Found"));

        var extractBooking = bookingDao.findById(bookingId)
                .orElseThrow(() -> new DataNotFoundException("Booking Not Found"));

        extractBooking.setFlight(extractFlight);
        extractBooking.setUser(extractUser);
        extractBooking.setBookingDate(booking.getBookingDate());
        extractBooking.setStatus(booking.getStatus());
        extractBooking.setTotalAmount(booking.getTotalAmount());
        extractBooking.setSeatCount(booking.getSeatCount());

    }

    @Override
    public void deleteBooking(String bookingId) {
        bookingDao.findById(bookingId)
                .orElseThrow(() -> new DataNotFoundException("Booking Not Found"));
        bookingDao.deleteById(bookingId);
    }

    @Override
    public BookingDTO getBooking(String bookingId) {
        var extractBooking = bookingDao.findById(bookingId)
                .orElseThrow(() -> new DataNotFoundException("Booking Not Found"));
        return mappingDTOEntity.toBookingDTO(extractBooking);
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        return mappingDTOEntity.getBookingDTOList(bookingDao.findAll());
    }
}
