package lk.ijse.cmjd112.AirTicketPoint.controller;


import lk.ijse.cmjd112.AirTicketPoint.dto.AirportDTO;
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
        airportDTO.setAirportId(IDGenerator.airportIDGen());
        System.out.println("Airport is: "+airportDTO);
        return new ResponseEntity<>(airportDTO, HttpStatus.CREATED);
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
        List<AirportDTO> airportList = List.of(
                new AirportDTO("APT-f5deaf73-1c27-4be3-98dd-73483ef8cb4e",
                        "CMB", "Bandaranayake International Airport", "Katunayaka", "SL"),
                new AirportDTO("APT-2b3c4d5e-2222-4bbb-9ccc-2345678901bc",
                        "HRI", "Mattala Rajapaksa International Airport", "Hambantota", "SL"),

                new AirportDTO("APT-3c4d5e6f-3333-4ccc-7ddd-3456789012cd",
                        "JAF", "Jaffna International Airport", "Jaffna", "SL"),

                new AirportDTO("APT-4d5e6f70-4444-4ddd-6eee-4567890123de",
                        "TRR", "China Bay Airport", "Trincomalee", "SL"),

                new AirportDTO("APT-5e6f7081-5555-4eee-5fff-5678901234ef",
                        "BTC", "Batticaloa Airport", "Batticaloa", "SL"),

                new AirportDTO("APT-6f708192-6666-4fff-4aaa-6789012345fa",
                        "GIU", "Sigiriya Airport", "Sigiriya", "SL"),

                new AirportDTO("APT-708192a3-7777-4aaa-3bbb-7890123456ab",
                        "ACJ", "Anuradhapura Airport", "Anuradhapura", "SL"),

                new AirportDTO("APT-8192a3b4-8888-4bbb-2ccc-8901234567bc",
                        "RML", "Ratmalana Airport", "Colombo", "SL"),

                new AirportDTO("APT-92a3b4c5-9999-4ccc-1ddd-9012345678cd",
                        "KCT", "Koggala Airport", "Galle", "SL"),

                new AirportDTO("APT-a3b4c5d6-aaaa-4ddd-0eee-0123456789de",
                        "DWO", "Diyawanna Airport", "Sri Jayawardenepura Kotte", "SL")
        );
        return new ResponseEntity<>(airportList,HttpStatus.OK);
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
