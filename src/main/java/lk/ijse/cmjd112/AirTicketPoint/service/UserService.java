package lk.ijse.cmjd112.AirTicketPoint.service;

import lk.ijse.cmjd112.AirTicketPoint.dto.AirportDTO;
import lk.ijse.cmjd112.AirTicketPoint.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);
    UserDTO getSelectedUser(String userId);
    List<UserDTO> getAllUsers ();
    void deleteUser(String usrId);
    void updateUser(String userId,UserDTO userDTO);
}
