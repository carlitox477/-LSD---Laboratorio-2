package utils.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface IBroadcastAPI extends Remote{
    public String getBroadcast(Date date) throws RemoteException;
}
