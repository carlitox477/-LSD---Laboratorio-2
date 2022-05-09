package utils.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface IHoroscopeAPI extends Remote{
    public String getHorosocope(Date date, String zodiacalSign) throws RemoteException;
}
