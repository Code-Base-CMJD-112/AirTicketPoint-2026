package lk.ijse.cmjd112.AirTicketPoint.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd112.AirTicketPoint.dao.UserDao;
import lk.ijse.cmjd112.AirTicketPoint.dto.AirportDTO;
import lk.ijse.cmjd112.AirTicketPoint.dto.Role;
import lk.ijse.cmjd112.AirTicketPoint.dto.UserDTO;
import lk.ijse.cmjd112.AirTicketPoint.entities.UserEntity;
import lk.ijse.cmjd112.AirTicketPoint.exception.DataNotFoundException;
import lk.ijse.cmjd112.AirTicketPoint.service.UserService;
import lk.ijse.cmjd112.AirTicketPoint.util.IDGenerator;
import lk.ijse.cmjd112.AirTicketPoint.util.MappingDTOEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceIMPL implements UserService{

    private final UserDao userDao;
    private final MappingDTOEntity mappingDTOEntity;

    @Override
    public void saveUser(UserDTO userDTO) {
        userDTO.setUserId(IDGenerator.userIDGen());
        userDao.save(mappingDTOEntity.toUserEntity(userDTO));
    }

    @Override
    public UserDTO getSelectedUser(String userId) {
        var foundUser =
                userDao.findById(userId).orElseThrow(() -> new DataNotFoundException("User Not Found"));
       return mappingDTOEntity.toUserDTO(foundUser);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return List.of(
                new UserDTO("USR-e50fe34c-e8fd-4817-85f7-41697fe1af71","Kamal","Silva","kamal@mail.com","kamal555", Role.ADMIN),

                new UserDTO("USR-a12bdc45-12ab-4cde-9f11-1234567890aa",
                        "Nimal", "Perera", "nimal@mail.com", "nimal123", Role.USER),

                new UserDTO("USR-b23cde56-23bc-4def-8a22-2345678901bb",
                        "Sunil", "Fernando", "sunil@mail.com", "sunil456", Role.USER),

                new UserDTO("USR-c34def67-34cd-4ef0-7b33-3456789012cc",
                        "Saman", "Jayasinghe", "saman@mail.com", "saman789", Role.ADMIN),

                new UserDTO("USR-d45efg78-45de-4f01-6c44-4567890123dd",
                        "Dilini", "Wijesinghe", "dilini@mail.com", "dilini321", Role.ADMIN)
        );
    }

    @Override
    public void deleteUser(String usrId) {
        System.out.println("Deleted User Id is :"+usrId);
    }

    @Override
    public void updateUser(String userId, UserDTO updateUser) {
        updateUser.setUserId(userId);
        System.out.println("User Id is: "+userId);
        System.out.println("Updated user is: "+updateUser);
    }
}
