package lk.ijse.cmjd112.AirTicketPoint.service;

import lk.ijse.cmjd112.AirTicketPoint.dto.BookingDTO;

import java.util.List;

public interface BookingService {
    void saveBooking(BookingDTO booking);
    void updateBooking(String bookingId,BookingDTO booking);
    void deleteBooking(String bookingId);
    BookingDTO getBooking(String bookingId);
    List<BookingDTO> getAllBookings();
}
