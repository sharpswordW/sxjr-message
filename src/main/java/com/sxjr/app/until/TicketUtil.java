package com.sxjr.app.until;
import java.util.UUID;

/**
 * Created by outh on 2016/6/1.
 */
public class TicketUtil {
    public static String UUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
