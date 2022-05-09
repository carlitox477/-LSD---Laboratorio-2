package services.broadcast;


import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import utils.ServerInfo;
import utils.Utils;
import utils.interfaces.IBroadcastAPI;

public class BroadcastServer {
    private static ServerInfo broadcastServerInfo=Utils.weatherServiceServerInfo;
    public static void main(String[] args){        
    	
    	System.out.println(BroadcastServer.class.getName()+": Initializing server");
        try{
        	LocateRegistry.createRegistry(broadcastServerInfo.getPort());
            IBroadcastAPI broadcastAPI= new BroadcastAPIImplementation(broadcastServerInfo.getPort());
            Naming.rebind(broadcastServerInfo.getRMIName(), broadcastAPI);
            System.out.println(String.format("[%s]: RMI API object created", BroadcastServer.class.getName()));
        }catch(RemoteException e){
            System.out.println(String.format("[%s] (Remote Exception): %s", BroadcastServer.class.getName(),e.getMessage()));    
        }catch(Exception e){
            System.out.println(String.format("[%s] (Exception): %s", BroadcastServer.class.getName(),e.getMessage()));
        }
        
    }
}
