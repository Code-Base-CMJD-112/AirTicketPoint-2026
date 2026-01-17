package lk.ijse.cmjd112.AirTicketPoint.controller;

import lk.ijse.cmjd112.AirTicketPoint.dto.Role;
import lk.ijse.cmjd112.AirTicketPoint.dto.UserDTO;
import lk.ijse.cmjd112.AirTicketPoint.util.IDGenerator;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO user){
        user.setUserId(IDGenerator.userIDGen());
        System.out.println("User is: "+user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getSelectedUser(@PathVariable ("id") String userId){
        System.out.println("User Id is "+userId);
        var userDTO = new UserDTO(userId,"Kamal","Silva","kamal@mail.com","kamal555", Role.ADMIN);
        return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> allUsers = List.of(
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
        return new ResponseEntity<>(allUsers,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable ("id") String userId){
        System.out.println("Deleted User Id is :"+userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PatchMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateUser(@PathVariable ("id") String userId,@RequestBody UserDTO updateUser){
        updateUser.setUserId(userId);
        System.out.println("User Id is: "+userId);
        System.out.println("Updated user is: "+updateUser);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
