package server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.HashMap;

import objetos.Alojamiento;
import objetos.PeticionReserva;
import objetos.Reserva;
import objetos.Usuario;

public class ServerDoor extends UnicastRemoteObject implements IServerDoor {

	private static final long serialVersionUID = 1L;
	private int cont = 0;
	private HashMap <String, String> registeredUsers = null;

	protected ServerDoor() throws RemoteException 
	{
		super();
		registeredUsers = new HashMap<String, String> ();
	}

	@Override
	public String sayHello() 
	{
		cont++;
		System.out.println(" * Client number: " + cont);
		return "Hello World!";
	}
	
	@Override
	public String sayMessage(String login, String password, String message) throws RemoteException, InvalidUser
	{
		if (registeredUsers.containsValue(login)) {

			if (registeredUsers.get(login).contentEquals(password)) {
				return message;
			} else {
				throw new InvalidUser("Incorrect password for user " + login);
			}

		} else {
			throw new InvalidUser("User name " + login + "is not present among the registered users");
		}
	}


	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("usage: java [policy] [codebase] server.Server [host] [port] [server]");
			System.exit(0);
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try 
		{	
			IServerDoor objServer = new ServerDoor();
			Registry registry = LocateRegistry.createRegistry((Integer.valueOf(args[1])));
			//Naming.rebind(name, objServer);
			registry.rebind(name, objServer);
			System.out.println("* Server '" + name + "' active and waiting...");			
		} 
		catch (Exception e) 
		{
			System.err.println("- Exception running the server: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public Reserva comprobarReserva(int idAlojamiento, int idReserva) throws RemoteException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'comprobarReserva'");
	}

	
	
}