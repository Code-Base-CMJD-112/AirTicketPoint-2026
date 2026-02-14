package lk.ijse.cmjd112.AirTicketPoint.dao;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd112.AirTicketPoint.entities.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDao extends JpaRepository<FlightEntity,String> {
    //JPQL

    //Avl seat count
    @Query("SELECT f.availableSeats FROM FlightEntity f WHERE f.flightId = :flightId")
    int getAvlSeats(@Param("flightId") String flightId);

    //Update seat count when booking done
    @Modifying
    @Query("UPDATE FlightEntity f SET f.availableSeats = f.availableSeats - :seatCount WHERE f.flightId = :flightId")
    @Transactional
    int deductAvlSeatCount(@Param("seatCount") int seatCount, @Param("flightId") String flightId);

    //Update seat count when booking cancelled
    @Modifying
    @Query("UPDATE FlightEntity f SET f.availableSeats = f.availableSeats + :seatCount WHERE f.flightId = :flightId")
    @Transactional
    int addAvlSeatCount(@Param("seatCount") int seatCount, @Param("flightId") String flightId);
}
