package services.horoscope;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import utils.ServerInfo;
import utils.Utils;
import utils.interfaces.IHoroscopeAPI;

public class HoroscopeServer{
    private static ServerInfo horoscopeServerInfo=Utils.horoscopeServiceServerInfo;
    public static void main(String[] args){
    	/*
    	Registry registry;
        System.out.println(HoroscopeServer.class.getName()+": Initializing server");
        try{
        	registry=LocateRegistry.createRegistry(horoscopeServerInfo.getPort());
        	IHoroscopeAPI horoscopeAPI=new HoroscopeAPIImplementation(horoscopeServerInfo.getPort());
        	registry.rebind(horoscopeServerInfo.getRMIName(), horoscopeAPI);
            System.out.println(String.format("[%s]: RMI API object created", HoroscopeServer.class.getName()));
        }catch(RemoteException e){
            System.out.println(String.format("[%s] (Remote Exception): %s", HoroscopeServer.class.getName(),e.getMessage()));    
        }catch(Exception e){
            System.out.println(String.format("[%s] (Exception): %s", HoroscopeServer.class.getName(),e.getMessage()));
        }
        */
        System.out.println(HoroscopeServer.class.getName()+": Initializing server");
        try{
        	LocateRegistry.createRegistry(horoscopeServerInfo.getPort());
        	IHoroscopeAPI horoscopeAPI=new HoroscopeAPIImplementation(horoscopeServerInfo.getPort());
        	Naming.rebind(horoscopeServerInfo.getRMIName(), horoscopeAPI);
            System.out.println(String.format("[%s]: RMI API object created", HoroscopeServer.class.getName()));
        }catch(RemoteException e){
            System.out.println(String.format("[%s] (Remote Exception): %s", HoroscopeServer.class.getName(),e.getMessage()));    
        }catch(Exception e){
            System.out.println(String.format("[%s] (Exception): %s", HoroscopeServer.class.getName(),e.getMessage()));
        }

    }
}