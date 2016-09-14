package ar.edu.itba.pod.client;

import ar.edu.itba.pod.Analyzer;
import ar.edu.itba.pod.Graph;
import ar.edu.itba.pod.Service;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


 
public class Client 
{
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException 
	{
		Analyzer auxi= new Analyzer(args);
		Object port = auxi.get("PORT");
		Object hostname = auxi.get("HOSTNAME");
		Object service = auxi.get("SERVICE");
		auxi.dump();
        
	    Service handle= (Service) Naming.lookup(String.format("//%s:%s/%s", hostname, port, service ) );

        Graph rta = handle.populate("AR");
        System.
                out.println(rta);
        // agreguemos nodos colorados!
        rta.addNode(new ColoredNode("W", "Rojo"));
        rta= handle.populate(rta);
        System.out.println(rta);
		
	}






}	