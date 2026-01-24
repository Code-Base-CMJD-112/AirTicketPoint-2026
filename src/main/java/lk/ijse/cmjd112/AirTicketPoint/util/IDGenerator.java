package lk.ijse.cmjd112.AirTicketPoint.util;

import java.util.UUID;

public class IDGenerator {
    //Airport
    public static String airportIDGen(){
        return "APT-"+ UUID.randomUUID();
    }
    //user
    public static String userIDGen(){
        return "USR-"+ UUID.randomUUID();
    }
    //booking
    public static String bookingIDGen(){
        return "BKN-"+ UUID.randomUUID();
    }
    //flight
    public static String flightIDGen(){
        return "FGT-"+ UUID.randomUUID();
    }

    //passenger
    public static String passengerIDGen(){
        return "PSG-"+ UUID.randomUUID();
    }




}
