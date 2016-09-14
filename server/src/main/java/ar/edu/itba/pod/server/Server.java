package ar.edu.itba.pod.server;

import ar.edu.itba.pod.Analyzer;
import ar.edu.itba.pod.Service;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry; 
import java.rmi.registry.Registry;



public class Server 
{
    public static void main(String[] args) throws RemoteException
    {
        if ( System.getSecurityManager() == null)
        {
            System.setSecurityManager(new SecurityManager() );
        }
		Analyzer auxi= new Analyzer(args);
		int port = Integer.valueOf( auxi.get("PORT").toString() );
		String hostname = auxi.get("HOSTNAME").toString();
		String service = auxi.get("SERVICE").toString();
		auxi.dump();

        Registry registry = LocateRegistry.getRegistry(hostname, port);
        Service stub = new ServiceImpl();

        registry.rebind(service, stub);
        System.out.println("Service bound");
      }
}