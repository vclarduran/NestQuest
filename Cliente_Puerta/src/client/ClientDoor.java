package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.remote.IServerDoor;

public class ClientDoor {

	public static void main(String[] args) {
		if (args.length != 3) 
		{
			System.out.println("uso: java [policy] [codebase] cliente.Cliente [host] [port] [server]");
			System.exit(0);
		}

		IServerDoor stubServer = null;
		try 
		{
			Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(args[1]))));
			String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
			stubServer = (IServerDoor) registry.lookup(name);
			System.out.println("* Message coming from the server");
			
		} 
		catch (Exception e) 
		{
			System.err.println("- Exception running the client: " + e.getMessage());
			e.printStackTrace();
		}
			
		try
		{
			System.out.println("Metodos no implementados");
		}
		catch (Exception e)
		{
			System.err.println("- Exception running the client: " + e.getMessage());
		}
		
	}
}