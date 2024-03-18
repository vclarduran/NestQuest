package server;


import java.rmi.Remote;
import java.rmi.RemoteException;
import objetos.Reserva;

public interface IServerDoor extends Remote 
{
	/**
	 * Test message to say hello to client
	 * @param
	 * @return Message
	 * @throws RemoteException
	 */
	String sayHello() throws RemoteException;
	
	/**
	 * Print message to client
	 * @param login
	 * @param password
	 * @param message
	 * @return Message
	 * @throws RemoteException
	 */
	String sayMessage(String login, String password, String message) throws RemoteException, InvalidUser;
	
	/* CONSULTA RESERVAS */
	Reserva comprobarReserva(int idAlojamiento, int idReserva) throws RemoteException;

}