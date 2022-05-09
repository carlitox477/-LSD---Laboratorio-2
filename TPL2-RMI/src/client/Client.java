package client;

import java.net.Socket;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.time.Instant;
import java.util.Date;

import utils.Utils;
import utils.interfaces.IBroadcastAPI;
import utils.interfaces.IMainServerAPI;

public class Client {

    public static void requestBroadcast(String date, Socket connection){

    }
    public static void requestHoroscope(String date, String zodiacalSign,Socket connection){

    }
    public static void main(String[] args){
        IMainServerAPI mainServerAPI;
        IBroadcastAPI broadcastAPI;
        Date date;
        String zodiacalSign;
        int selectedOption=0;
        
        
        System.out.print("Initializing Client Server... ");
        try {
            mainServerAPI=(IMainServerAPI) Naming.lookup(Utils.mainServerInfo.getRMIName());
            broadcastAPI=(IBroadcastAPI) Naming.lookup(Utils.weatherServiceServerInfo.getRMIName());
            System.out.println("Connection with Main Server achieved");
            System.out.println("Welcome to the UI");

            while(selectedOption!=5){
                selectedOption=client.Utils.askMainOption();
                switch(selectedOption){
                    case 1:
                        //Query today's weather
                    	//String weather=mainServerAPI.getBroadcast(Date.from(Instant.now()));
                    	String weather=broadcastAPI.getBroadcast(Date.from(Instant.now()));
                        System.out.println(weather);
                        break;
                    case 2:
                        //Query today's horoscope for a particular zodiacal sign
                        zodiacalSign=client.Utils.askZodiacalSign();
                       
                        System.out.println(mainServerAPI.getHorosocope(Date.from(Instant.now()), zodiacalSign));
                        break;
                    case 3:
                        //Query weather of a particular date
                        date = client.Utils.askDate();
                        System.out.println(broadcastAPI.getBroadcast(date));
                        break;
                    case 4:
                        //Query horoscope for a particular zodiacal sign of a particular date
                        date = client.Utils.askDate();
                        zodiacalSign=client.Utils.askZodiacalSign();
                        System.out.println(mainServerAPI.getHorosocope(date, zodiacalSign));
                        break;
                    case 5:
                        System.out.println("Bye Bye!");
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
            }
        } catch (RemoteException e) {
            System.out.println(String.format("[%s] (Remote Exception): %s", Client.class.getName(),e.getMessage())); 
        }catch(Exception e){
            System.out.println(String.format("[%s] (Exception): %s", Client.class.getName(),e.getMessage()));
        }
    }
    
}
