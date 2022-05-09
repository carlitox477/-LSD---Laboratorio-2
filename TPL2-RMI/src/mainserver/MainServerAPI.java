package mainserver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import utils.interfaces.IBroadcastAPI;
import utils.interfaces.IHoroscopeAPI;
import utils.interfaces.IMainServerAPI;



public class MainServerAPI extends UnicastRemoteObject implements IMainServerAPI{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public IHoroscopeAPI horoscopeAPI;
    public IBroadcastAPI broadcastAPI;

    protected MainServerAPI(int port,IHoroscopeAPI horoscopeAPI,IBroadcastAPI broadcastAPI) throws RemoteException {
        super(port);
        this.horoscopeAPI=horoscopeAPI;
        this.broadcastAPI=broadcastAPI;
    }

    @Override
    public String getHorosocope(Date date, String zodiacalSign) throws RemoteException {
        return horoscopeAPI.getHorosocope(date, zodiacalSign);
    }

    @Override
    public String getBroadcast(Date date) throws RemoteException {
        return broadcastAPI.getBroadcast(date);
    }
    
}
