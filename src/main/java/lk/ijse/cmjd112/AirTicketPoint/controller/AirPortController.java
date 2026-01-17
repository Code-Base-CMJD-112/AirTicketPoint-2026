package lk.ijse.cmjd112.AirTicketPoint.controller;


import lk.ijse.cmjd112.AirTicketPoint.dto.AirportDTO;
import lk.ijse.cmjd112.AirTicketPoint.service.impl.AirportServiceIMPL;
import lk.ijse.cmjd112.AirTicketPoint.util.IDGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
@RequestMapping("/api/v1/airports")
public class AirPortController {
     //Create an Airport
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirportDTO> saveAirport(@RequestBody AirportDTO airportDTO){
        var airportServiceIMPL = new AirportServiceIMPL();
        var savedAirport = airportServiceIMPL.saveAirport(airportDTO);
        return new ResponseEntity<>(savedAirport, HttpStatus.CREATED);
    }
    @GetMapping(value = "/{airportId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirportDTO> getAirport(@PathVariable ("airportId") String airportIdentifier){
        System.out.println("Airport ID is: "+airportIdentifier);
        var airport = new AirportDTO("APT-f5deaf73-1c27-4be3-98dd-73483ef8cb4e",
                "CMB", "Bandaranayake International Airport", "Katunayaka", "SL");
        return new ResponseEntity<>(airport,HttpStatus.OK);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AirportDTO>> getAllAirports(){
        var airportService= new AirportServiceIMPL();
        return new ResponseEntity<>(airportService.getAllAirports(),HttpStatus.OK);
    }
    @DeleteMapping("/{airportId}")
    public ResponseEntity<Void> deleteAirportData(@PathVariable ("airportId") String airportIdentifier){
        System.out.println("Deleted airport: "+airportIdentifier);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PatchMapping(value = "/{airportId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateAirportData(@PathVariable ("airportId") String airportIdentifier, @RequestBody AirportDTO updatedAirport){
        updatedAirport.setAirportId(airportIdentifier);
        System.out.println("Updated updatedAirport ID: "+airportIdentifier);
        System.out.println("Updated updatedAirport details: "+updatedAirport);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
