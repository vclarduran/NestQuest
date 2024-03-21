package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import objetos.Reserva;

public class ServerDoor extends UnicastRemoteObject implements IServerDoor {

	private static final long serialVersionUID = 1L;

	protected ServerDoor() throws RemoteException 
	{
		super();
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
		throw new UnsupportedOperationException("Unimplemented method 'comprobarReserva'");
	}

	
	
}