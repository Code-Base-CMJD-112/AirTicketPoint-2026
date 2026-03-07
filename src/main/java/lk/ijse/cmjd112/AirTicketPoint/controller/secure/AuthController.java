package lk.ijse.cmjd112.AirTicketPoint.controller.secure;

import lk.ijse.cmjd112.AirTicketPoint.dto.secure.JWTResponseDTO;
import lk.ijse.cmjd112.AirTicketPoint.dto.secure.LoginDTO;
import lk.ijse.cmjd112.AirTicketPoint.dto.secure.UserDTO;
import lk.ijse.cmjd112.AirTicketPoint.service.secure.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<JWTResponseDTO> login( @RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(authService.login(loginDTO));
    }
    @PostMapping("/signup")
    public ResponseEntity<JWTResponseDTO> signUp(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(authService.register(userDTO));
    }

}
