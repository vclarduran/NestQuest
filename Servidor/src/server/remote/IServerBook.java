package server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import objetos.Usuario;
import objetos.Reserva;
import objetos.Alojamiento;
import objetos.PeticionReserva;

public interface IServerBook extends Remote 
{
	
	/*API APARTMENTOS*/
	List<Alojamiento> getAlojamientos() throws RemoteException;
	List<Alojamiento> getHabitaciones(List<Alojamiento> alojamientos) throws RemoteException;

	/* GESTION USUARIO */
	Usuario comprobarUsuario (String usuario, String contrasenya) throws RemoteException;

	boolean crearUsuario (Usuario usuario) throws RemoteException;

	/* NUEVAS RESERVAS */
	Reserva reservar(Usuario personaQueReserva, PeticionReserva peticionReserva) throws RemoteException;

	/* OPCIONES */
	ArrayList<Alojamiento> busquedaOpciones(int horas, int transporte, float presupuesto, Date fechaSalida, Date fechaEntrada, String localizacionActual, int numPersonas) throws RemoteException;

	byte[] rutaOptima(Alojamiento alojamiento, String localizacionActual) throws RemoteException;

	byte[] mapaUbicacion(Alojamiento alojamiento, String localizacionActual) throws RemoteException;




}