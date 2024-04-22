package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.remote.IServerBook;

public class ClientBook {

	public static void main(String[] args) {
		if (args.length != 3) 
		{
			System.out.println("uso: java [policy] [codebase] cliente.Cliente [host] [port] [server]");
			System.exit(0);
		}

		IServerBook stubServer = null;
		/**
		 * Try test message
		 */
		try 
		{
			Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(args[1]))));
			String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
			stubServer = (IServerBook) registry.lookup(name);
			System.out.println("* Message coming from the server");
			
		} 
		catch (Exception e) 
		{
			System.err.println("- Exception running the client: " + e.getMessage());
			e.printStackTrace();
		}
		
		//Extraemos los alojamientos disponibles
		try
		{
			System.out.println("Alojamientos disponibles" + stubServer.getAlojamientos());
			}
		catch (Exception e)
		{
			System.err.println("- Exception running the client: " + e.getMessage());
		}
		
	}
}