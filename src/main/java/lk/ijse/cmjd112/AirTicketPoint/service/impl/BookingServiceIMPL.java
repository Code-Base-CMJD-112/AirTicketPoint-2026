package lk.ijse.cmjd112.AirTicketPoint.service.impl;

import lk.ijse.cmjd112.AirTicketPoint.dto.BookingDTO;
import lk.ijse.cmjd112.AirTicketPoint.service.BookingService;
import lk.ijse.cmjd112.AirTicketPoint.util.DateTimeUtil;
import lk.ijse.cmjd112.AirTicketPoint.util.IDGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookingServiceIMPL implements BookingService {

    @Override
    public void saveBooking(BookingDTO booking) {
        booking.setBookingId(IDGenerator.bookingIDGen());
        booking.setBookingDate(booking.getBookingDate() == null ? DateTimeUtil.currentDateTime(): booking.getBookingDate());
        System.out.println(booking);
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
