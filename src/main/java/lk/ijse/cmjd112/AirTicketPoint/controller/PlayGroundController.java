package lk.ijse.cmjd112.AirTicketPoint.controller;


import lk.ijse.cmjd112.AirTicketPoint.dto.PlayGroundObjDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/playground")
public class PlayGroundController {
    @PostMapping("/{path}")
    public void getPathVariable(@PathVariable ("path") String pathVariable){
        System.out.println("Path Variable is :"+pathVariable);
    }
    @PostMapping
    public void getQueryParams(@RequestParam ("name") String names, @RequestParam String city){
        System.out.println("ParamOne : "+names);
        System.out.println("ParamTwo : "+city);
    }
    @PostMapping("/headers")
    public void getCustomHeaderData(@RequestHeader ("X-province") String headerOne, @RequestHeader ("X-mainCity") String headerTwo){
        System.out.println("HeaderOne : "+headerOne);
        System.out.println("HeaderTwo : "+headerTwo);
    }
    @PostMapping("/reqestbody")
    public void getRequestBodyData(@RequestBody String level){
        System.out.println("Level is : "+level);
    }
    @PostMapping(value = "/play",consumes = "application/json",produces = MediaType.APPLICATION_JSON_VALUE)
    public PlayGroundObjDTO handlePlayGroundObj(@RequestBody PlayGroundObjDTO playGroundObj){
        System.out.println("Playground is: "+playGroundObj);
        return playGroundObj;
    }
    @PostMapping(value = "/formal",consumes = "application/json",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlayGroundObjDTO> handlePlayGroundObjFormal(@RequestBody PlayGroundObjDTO playGroundObj){
        System.out.println("Playground is: "+playGroundObj);
        return new ResponseEntity<>(playGroundObj, HttpStatus.CREATED);
    }





}
