package lk.ijse.cmjd112.AirTicketPoint.dto.secure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginDTO implements Serializable {
    private String email;
    private String password;
}
