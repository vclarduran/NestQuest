package server;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServerBook extends Remote 
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
	

	/* GESTION USUARIO */
	Usuario comprobarUsusuario (String nombre, String contrasenya) throws RemoteException, InvalidUser;

	Usuario crearUsuario (String nombre, String contrasenya, String email) throws RemoteException, InvalidUser;


	/* NUEVAS RESERVAS */
	Reserva reservar(Usuario personaQueReserva, PeticionReserva peticionReserva) throws RemoteException;

	/* OPCIONES */
	ArrayList<Alojamientos> busquedaOpciones(int horas, int transporte, float presupuesto, int numPersonas, String localizacionActual) throws RemoteException;

	byte[] rutaOptima(Alojamiento alojamiento, String localizacionActual) throws RemoteException;



}