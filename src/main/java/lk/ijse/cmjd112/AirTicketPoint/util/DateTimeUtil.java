package lk.ijse.cmjd112.AirTicketPoint.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd 'T' HH:mm:ss");

    //current Time
    public static LocalDateTime currentDateTime(){
        return LocalDateTime.now();
    }
    // format
    public static String currentDateTimeString(){
        return currentDateTime().format(FORMAT);
    }
}
