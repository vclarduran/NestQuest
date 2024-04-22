package server.remote;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import objetos.Reserva;

public class ServerDoor extends UnicastRemoteObject implements IServerDoor {

	private static final long serialVersionUID = 1L;

	public ServerDoor() throws RemoteException 
	{
		super();
	}

	@Override
	public Reserva comprobarReserva(int idAlojamiento, String idReserva) throws RemoteException {
		throw new UnsupportedOperationException("Unimplemented method 'comprobarReserva'");
	}

	
	
}