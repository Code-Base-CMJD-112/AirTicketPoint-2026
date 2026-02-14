package lk.ijse.cmjd112.AirTicketPoint.controller;


import lk.ijse.cmjd112.AirTicketPoint.dto.PassengerDTO;
import lk.ijse.cmjd112.AirTicketPoint.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/passengers")
@RequiredArgsConstructor
public class PassengerController {

    private final PassengerService passengerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> savePassenger(@RequestBody PassengerDTO passenger){
        passengerService.savePassenger(passenger);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/{passengerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PassengerDTO> getSelectedPassenger(@PathVariable ("passengerId") String passengerIdentifier){
        return new ResponseEntity<>(passengerService.getSelectedPassenger(passengerIdentifier),HttpStatus.OK);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PassengerDTO>> getAllPassengers(){
        return new ResponseEntity<>(passengerService.getAllPassengers(),HttpStatus.OK);
    }
    @DeleteMapping("/{passengerId}")
    public ResponseEntity<Void> deletePassengerData(@PathVariable ("passengerId") String passengerIdentifier){
        passengerService.deletePassenger(passengerIdentifier);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PatchMapping(value = "/{passengerId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updatePassengerData(@PathVariable ("passengerId") String airportIdentifier, @RequestBody PassengerDTO updatedPassenger){
        passengerService.updatePassenger(airportIdentifier,updatedPassenger);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
