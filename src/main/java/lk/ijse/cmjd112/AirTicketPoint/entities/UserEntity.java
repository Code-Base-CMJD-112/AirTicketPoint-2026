package lk.ijse.cmjd112.AirTicketPoint.entities;

import jakarta.persistence.*;
import lk.ijse.cmjd112.AirTicketPoint.dto.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "user")
public class UserEntity implements Serializable {
    @Id
    private String userId;
    private String firstName;
    private String lastName;
    @Column(nullable = false,unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<BookingEntity> bookings;
}
