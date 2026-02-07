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
        return mappingDTOEntity.getuserDTOList(userDao.findAll());
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
