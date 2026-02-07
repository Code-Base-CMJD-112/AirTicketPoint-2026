package lk.ijse.cmjd112.AirTicketPoint.dao;

import lk.ijse.cmjd112.AirTicketPoint.entities.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDao extends JpaRepository<BookingEntity, String> {
}
