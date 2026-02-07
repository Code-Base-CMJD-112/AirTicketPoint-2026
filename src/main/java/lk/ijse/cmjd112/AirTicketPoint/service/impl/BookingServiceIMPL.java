package lk.ijse.cmjd112.AirTicketPoint.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd112.AirTicketPoint.dao.BookingDao;
import lk.ijse.cmjd112.AirTicketPoint.dao.UserDao;
import lk.ijse.cmjd112.AirTicketPoint.dto.BookingDTO;
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



    @Override
    public void saveBooking(BookingDTO booking) {


        booking.setBookingId(IDGenerator.bookingIDGen());
        booking.setBookingDate(booking.getBookingDate() == null ? DateTimeUtil.currentDateTime()
                : booking.getBookingDate());
        bookingDao.save(mappingDTOEntity.toBookingEntity(booking));
    }

    @Override
    public void updateBooking(String bookingId, BookingDTO booking) {

        System.out.println(booking);
        System.out.println(bookingId);
    }

    @Override
    public void deleteBooking(String booking) {

    }

    @Override
    public BookingDTO getBooking(String booking) {
        return null;
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        return List.of();
    }
}
