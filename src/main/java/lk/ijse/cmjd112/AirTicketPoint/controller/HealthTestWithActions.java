package lk.ijse.cmjd112.AirTicketPoint.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/healthtest")
public class HealthTestWithActions {
    @GetMapping
    public String healthTest(){
        return "AirTicketPoint is running - V 1.0.0";
    }
}
