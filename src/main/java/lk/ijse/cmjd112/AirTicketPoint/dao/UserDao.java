package lk.ijse.cmjd112.AirTicketPoint.dao;

import lk.ijse.cmjd112.AirTicketPoint.entities.secure.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserEntity,String> {
}
