package lk.ijse.cmjd112.AirTicketPoint.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd112.AirTicketPoint.dao.UserDao;
import lk.ijse.cmjd112.AirTicketPoint.dto.secure.UserDTO;
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
    public void deleteUser(String userId) {
        userDao.findById(userId).orElseThrow(() -> new DataNotFoundException("User Not Found"));
        userDao.deleteById(userId);
    }

    @Override
    public void updateUser(String userId, UserDTO updateUser) {
        var foundUser =
                userDao.findById(userId).orElseThrow(() -> new DataNotFoundException("User Not Found"));

        foundUser.setEmail(updateUser.getEmail());
        foundUser.setEmail(updateUser.getEmail());
        foundUser.setRole(updateUser.getRole());
        foundUser.setFirstName(updateUser.getFirstName());
        foundUser.setLastName(updateUser.getLastName());
    }
}
