package lk.ijse.cmjd112.AirTicketPoint.service.secure.impl;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd112.AirTicketPoint.dao.UserDao;
import lk.ijse.cmjd112.AirTicketPoint.dto.secure.JWTResponseDTO;
import lk.ijse.cmjd112.AirTicketPoint.dto.secure.LoginDTO;
import lk.ijse.cmjd112.AirTicketPoint.dto.secure.UserDTO;
import lk.ijse.cmjd112.AirTicketPoint.entities.secure.UserEntity;
import lk.ijse.cmjd112.AirTicketPoint.securityConfig.JWTUtils;
import lk.ijse.cmjd112.AirTicketPoint.service.UserService;
import lk.ijse.cmjd112.AirTicketPoint.service.secure.AuthService;
import lk.ijse.cmjd112.AirTicketPoint.util.IDGenerator;
import lk.ijse.cmjd112.AirTicketPoint.util.MappingDTOEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceIMPL implements AuthService {
    private final JWTUtils jwtUtils;
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final MappingDTOEntity mappingDTOEntity;


    @Override
    public JWTResponseDTO login(LoginDTO loginDTO) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        loginDTO.getEmail(),
                        loginDTO.getPassword()
                ));

        //Fetch user
        var authUser = userDao.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        //Token generate
        var token = jwtUtils.generateToken(
                authUser.getUsername(),
                authUser.getAuthorities()

        );
        return JWTResponseDTO
                .builder()
                .token(token)
                .build();
    }

    @Override
    public JWTResponseDTO register(UserDTO userDTO) {
        if(userDao.existsByEmail(userDTO.getEmail())){
            throw new IllegalArgumentException("User Already exist");
        }
        // Generate ID
        userDTO.setUserId(IDGenerator.userIDGen());
        //PW encode
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        //save user
        var savedUser = userDao.save(mappingDTOEntity.toUserEntity(userDTO));

        //Generate ID
        var token = jwtUtils.generateToken(
                savedUser.getEmail(),
                savedUser.getAuthorities()

        );
        return JWTResponseDTO
                .builder()
                .token(token)
                .build();

    }
}
