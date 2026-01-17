package lk.ijse.cmjd112.AirTicketPoint.controller;


import lk.ijse.cmjd112.AirTicketPoint.dto.AirportDTO;
import lk.ijse.cmjd112.AirTicketPoint.util.IDGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping("/api/v1/airports")
public class AirPortController {
     //Create an Airport
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirportDTO> saveAirport(@RequestBody AirportDTO airportDTO){
        airportDTO.setAirportId(IDGenerator.airportIDGen());
        System.out.println("Airport is: "+airportDTO);
        return new ResponseEntity<>(airportDTO, HttpStatus.CREATED);
    }

}
