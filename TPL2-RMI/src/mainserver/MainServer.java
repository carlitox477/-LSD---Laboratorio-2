package mainserver;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import utils.ServerInfo;
import utils.Utils;
import utils.interfaces.IBroadcastAPI;
import utils.interfaces.IHoroscopeAPI;

public class MainServer {
    
    public static void main(String[] args) throws IOException{
    	
    	ServerInfo serverInfo= Utils.mainServerInfo;
        System.out.println(MainServer.class.getName()+": Initializing main server");
        try{
        	LocateRegistry.createRegistry(serverInfo.getPort());
            IHoroscopeAPI horoscopeAPI=(IHoroscopeAPI) Naming.lookup(Utils.horoscopeServiceServerInfo.getRMIName());
            IBroadcastAPI broadcastAPI=(IBroadcastAPI) Naming.lookup(Utils.weatherServiceServerInfo.getRMIName());
            MainServerAPI mainServerAPI=new MainServerAPI(serverInfo.getPort(), horoscopeAPI, broadcastAPI);
            Naming.rebind(serverInfo.getRMIName(), mainServerAPI);
            System.out.println(String.format("[%s]: RMI API object created", MainServer.class.getName()));
        }catch(RemoteException e){
            System.out.println(String.format("[%s] (Remote Exception): %s", MainServer.class.getName(),e.getMessage())); 
        }catch(Exception e){
            System.out.println(String.format("[%s] (Exception): %s", MainServer.class.getName(),e.getMessage()));
        }
        
    }
}
