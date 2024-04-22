package client.remote;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.remote.IServerDoor;

public class RMIServiceLocator_Puerta
{
    private IServerDoor service = null;

    public RMIServiceLocator_Puerta(){}

    public void setService(String ip, String port, String serviceName)
    {
        try
        {
            Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(port))));
			String name = "//" + ip + ":" +port + "/" + serviceName;
			this.service = (IServerDoor) registry.lookup(name);
			System.out.println("* Message coming from the server");
        }
        catch(Exception e) 
        {
           	System.err.println("- Exception running the client: " + e.getMessage());
			e.printStackTrace(); 
        }
    }

    public IServerDoor getService()
    {
        return service;
    }
}