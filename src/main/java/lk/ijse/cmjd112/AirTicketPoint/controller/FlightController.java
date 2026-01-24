package lk.ijse.cmjd112.AirTicketPoint.controller;


import lk.ijse.cmjd112.AirTicketPoint.dto.FlightDTO;
import lk.ijse.cmjd112.AirTicketPoint.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FlightDTO> saveFlight(@RequestBody FlightDTO flightDTO){
        return new ResponseEntity<>(flightService.saveFlight(flightDTO), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{flightId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FlightDTO> getFlight(@PathVariable ("flightId") String flightIdentifier){
        return new ResponseEntity<>(flightService.getSelectedFlight(flightIdentifier),HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FlightDTO>> getAllFlights(){
        return new ResponseEntity<>(flightService.getAllFlights(),HttpStatus.OK);
    }
    @DeleteMapping("/{flightId}")
    public ResponseEntity<Void> deleteFlightData(@PathVariable ("flightId") String flightIdentifier){
        flightService.deleteFlight(flightIdentifier);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PatchMapping(value = "/{flightId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateFlightData(@PathVariable ("flightId") String flightIdentifier, @RequestBody FlightDTO updatedFlight){
        flightService.updateFlight(flightIdentifier,updatedFlight);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
