package lk.ijse.cmjd112.AirTicketPoint.entities.secure;

import jakarta.persistence.*;
import lk.ijse.cmjd112.AirTicketPoint.dto.Role;
import lk.ijse.cmjd112.AirTicketPoint.entities.BookingEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "user")
public class UserEntity implements Serializable, UserDetails {
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_"+role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }
}
