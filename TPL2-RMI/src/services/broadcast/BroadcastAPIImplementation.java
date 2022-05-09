package services.broadcast;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;


import utils.Utils;
import utils.interfaces.IBroadcastAPI;

public class BroadcastAPIImplementation extends UnicastRemoteObject implements IBroadcastAPI{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 7004031905724332023L;
	private String[] POSSIBLE_BROADCASTS={
        "SUNNY",
        "CLOUDY",
        "OVERCAST",
        "THUNDER STORM",
        "PARTLY SUNNY",
        "FOG",
        "SHOWERS",
        "HEAVY RAIN",
        "RAIN WITH SUN",
        "SNOWY",
        "PARTLY CLOUDY",
        "RAIN",
        "SLEET"
    };

    protected BroadcastAPIImplementation(int port) throws RemoteException {
        super(port);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String getBroadcast(Date date) throws RemoteException {
        // TODO Auto-generated method stub
        int normalizedDateTime=Utils.dateToInt(date);
        return POSSIBLE_BROADCASTS[(normalizedDateTime)%POSSIBLE_BROADCASTS.length];
    }
    
}