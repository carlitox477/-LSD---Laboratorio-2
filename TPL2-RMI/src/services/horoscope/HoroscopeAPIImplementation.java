package services.horoscope;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;
import java.util.Date;

import utils.Utils;
import utils.interfaces.IHoroscopeAPI;

public class HoroscopeAPIImplementation extends UnicastRemoteObject implements IHoroscopeAPI{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String[] HOROSCOPE_OPTIONS={
        "Today you will be spaced out", // unable to concentrate
        "Today you will feel a bit off", //you won't feel yourself
        "Today will make your blood boil", //make you fell angry
        "Today you will be on cloud nine", //feel happy

        "Today will be a pain in the neck", //awful
        "Today you will feel in the top of the world", //Fell great
        "Today you will be over the moon", //feel happy
        "Today you will bored to death", //feel super boring

        "Today you will feel blue", //sad
        "Today you will be on pins and needles", //anxious/nervous
        "Today you will hang your head", //feel ashamed
        "Today you will be scared out of your wits", //feel scared
    };
    private static String[] ZODIACAL_SIGNS=Utils.getZodiacalSigns();

    protected HoroscopeAPIImplementation(int port) throws RemoteException {
        super(port);
    }

    @Override
    public String getHorosocope(Date date, String zodiacalSign) throws RemoteException {
        int normalizedDateTime=Utils.dateToInt(date);
        int zodiacalSignIndex=Arrays.asList(ZODIACAL_SIGNS).indexOf(zodiacalSign);
        System.out.println("normalized date: "+normalizedDateTime);
        System.out.println("zodiacalSignIndex:  "+zodiacalSignIndex);
        return HOROSCOPE_OPTIONS[(normalizedDateTime+zodiacalSignIndex) % HOROSCOPE_OPTIONS.length];
    }
}
