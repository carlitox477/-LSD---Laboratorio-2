package client;

import java.text.SimpleDateFormat;
import java.util.Date;

import utils.TecladoIn;

public class Utils {
    private static String[] HOROSCOPE_OPTIONS ={
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

    private static String[] MAIN_OPTIONS ={
        "Query today's weather",
        "Query today's horoscope for a particular zodiacal sign",
        "Query weather of a particular date",
        "Query horoscope for a particular zodiacal sign of a particular date",
        "Exit"
    };

    private static void printMainOptions(){
        String options="";
        for(int i=0; i< MAIN_OPTIONS.length; i++){
            options+= (i+1) +" - "+ MAIN_OPTIONS[i]+"\n";
        }
        System.out.println(options);
    }

    public static int askMainOption(){
        int selectedOption=0;
        printMainOptions();
        while(selectedOption<1 || selectedOption>MAIN_OPTIONS.length){
            System.out.print("Introduce a valid option: ");
            selectedOption= TecladoIn.readInt();
        }
        return selectedOption;
    }


    public static Date askDate(){
        String dateStr=null;
        Date date=null;
        
        while(date==null){
            try{
                System.out.print("Introduce the date you want to querry(DD/MM/YYYY): ");
                dateStr=TecladoIn.readLine();
                date=new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
            }catch(Exception e){}
        }
        return date;
    }

    private static void printZodiacalSignOptions(){
        String options="";
        for(int i=0; i< HOROSCOPE_OPTIONS.length; i++){
            options+= "\t" + (i+1) +" - "+ HOROSCOPE_OPTIONS[i]+"\n";
        }
        System.out.println(options);
    }

    public static String askZodiacalSign(){
        int selectedOption=0;
        System.out.println("Select a zodiacal sign: ");
        printZodiacalSignOptions();
        while(selectedOption<1 || selectedOption> HOROSCOPE_OPTIONS.length){
            System.out.print("Select a valid option: ");
            selectedOption= TecladoIn.readInt();
        }
        //myInput.close();
        return HOROSCOPE_OPTIONS[selectedOption];
    }

}
