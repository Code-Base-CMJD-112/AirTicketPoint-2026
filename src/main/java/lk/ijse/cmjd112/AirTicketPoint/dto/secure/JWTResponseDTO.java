package lk.ijse.cmjd112.AirTicketPoint.dto.secure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JWTResponseDTO implements Serializable {
    private String token;
}
