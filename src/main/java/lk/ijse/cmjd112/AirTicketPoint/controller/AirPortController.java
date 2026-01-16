package lk.ijse.cmjd112.AirTicketPoint.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/airports")
public class AirPortController {
    @GetMapping
    public String healthTest(){
        return "Air Port Controller";
    }
}
