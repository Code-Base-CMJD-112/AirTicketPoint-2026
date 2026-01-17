package lk.ijse.cmjd112.AirTicketPoint.controller;


import lk.ijse.cmjd112.AirTicketPoint.dto.AirportDTO;
import lk.ijse.cmjd112.AirTicketPoint.service.AirportService;
import lk.ijse.cmjd112.AirTicketPoint.service.impl.AirportServiceIMPL;
import lk.ijse.cmjd112.AirTicketPoint.util.IDGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
@RequestMapping("/api/v1/airports")
@RequiredArgsConstructor
public class AirPortController {
    // Constructor injection - Support with Lombok - @RequiredArgsConstructor
    private final AirportService airportService;

     //Field Injection
//    private AirportService airportService;

    // Constructor injection
//    public AirPortController(AirportService airportService) {
//        this.airportService = airportService;
//    }
    //Create an Airport
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirportDTO> saveAirport(@RequestBody AirportDTO airportDTO){
        return new ResponseEntity<>(airportService.saveAirport(airportDTO), HttpStatus.CREATED);
    }
    @GetMapping(value = "/{airportId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirportDTO> getAirport(@PathVariable ("airportId") String airportIdentifier){
        return new ResponseEntity<>(airportService.getSelectedAirport(airportIdentifier),HttpStatus.OK);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AirportDTO>> getAllAirports(){
        return new ResponseEntity<>(airportService.getAllAirports(),HttpStatus.OK);
    }
    @DeleteMapping("/{airportId}")
    public ResponseEntity<Void> deleteAirportData(@PathVariable ("airportId") String airportIdentifier){
        airportService.deleteAirport(airportIdentifier);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PatchMapping(value = "/{airportId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateAirportData(@PathVariable ("airportId") String airportIdentifier, @RequestBody AirportDTO updatedAirport){
        airportService.updateAirport(airportIdentifier,updatedAirport);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
