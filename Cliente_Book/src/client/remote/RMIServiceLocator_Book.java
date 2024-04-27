package client.remote;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.remote.IServerBook;
import objetos.*;


public class RMIServiceLocator_Book
{
    private IServerBook service = null;

    public RMIServiceLocator_Book(){}

    public void setService(String ip, String port, String serviceName)
    {
        try
        {
            Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(port))));
			String name = "//" + ip + ":" +port + "/" + serviceName;
			this.service = (IServerBook) registry.lookup(name);
			System.out.println("* Message coming from the server");
        }
        catch(Exception e) 
        {
           	System.err.println("- Exception running the client: " + e.getMessage());
			e.printStackTrace(); 
        }
    }

    public IServerBook getService()
    {
        return service;
    }
}