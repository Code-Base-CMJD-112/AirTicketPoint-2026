package lk.ijse.cmjd112.AirTicketPoint.util;

import java.util.UUID;

public class IDGenerator {
    //Airport
    public static String airportIDGen(){
        return "APT-"+ UUID.randomUUID();
    }


}
