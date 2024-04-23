package server.remote;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import objetos.Reserva;
import server.NestQuestService_Door;

public class ServerDoor extends UnicastRemoteObject implements IServerDoor {

	private static final long serialVersionUID = 1L;
	private NestQuestService_Door appService = null;

	public ServerDoor(NestQuestService_Door as) throws RemoteException 
	{
		this.appService = as;
		super();
	}

	@Override
	public Reserva comprobarReserva(int idAlojamiento, String idReserva) throws RemoteException {
		throw new UnsupportedOperationException("Unimplemented method 'comprobarReserva'");
	}

	
	
}