package lk.ijse.cmjd112.AirTicketPoint.service.secure;

import lk.ijse.cmjd112.AirTicketPoint.dto.secure.JWTResponseDTO;
import lk.ijse.cmjd112.AirTicketPoint.dto.secure.LoginDTO;
import lk.ijse.cmjd112.AirTicketPoint.dto.secure.UserDTO;
import lk.ijse.cmjd112.AirTicketPoint.securityConfig.JWTUtils;

public interface AuthService {
    JWTResponseDTO login(LoginDTO  loginDTO);
    JWTResponseDTO register (UserDTO userDTO);
}
