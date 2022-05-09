package utils;

import java.util.Calendar;
import java.util.Date;

public class Utils {
    public static ServerInfo clientServerInfo= new ServerInfo("localhost", 4000,"");
    public static ServerInfo mainServerInfo= new ServerInfo("localhost", 4001,"mainAPI");
    public static ServerInfo weatherServiceServerInfo= new ServerInfo("localhost", 4002,"broadcastAPI");
    public static ServerInfo horoscopeServiceServerInfo= new ServerInfo("localhost", 4003,"horoscopeAPI");

    private static String[] ZODIACAL_SIGNS ={
        "ARIES",
        "TAURUS",
        "GEMINI",
        "CANCER",
        "LEO",
        "VIRGO",
        "LIBRA",
        "SCORPIUS",
        "SAGITTARIUS",
        "CAPRICORNUS",
        "AQUARIUS",
        "PISCES"
    };

    public static String[] getZodiacalSigns(){
        return ZODIACAL_SIGNS.clone();
    }

    public static Date removeDateTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
    
    public static int dateToInt(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        int month=calendar.get(Calendar.MONTH);
        int year=calendar.get(Calendar.YEAR);
        System.out.println("DATE: "+day+"/"+month+"/"+year);
        return calendar.get(Calendar.YEAR)+calendar.get(Calendar.MONTH)+calendar.get(Calendar.DAY_OF_MONTH);
    }
    
}
