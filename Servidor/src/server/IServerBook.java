package server;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import objetos.Usuario;
import objetos.Reserva;
import objetos.Alojamiento;
import objetos.PeticionReserva;

public interface IServerBook extends Remote 
{
	
	/*API APARTMENTOS*/
	String getAlojamientos() throws RemoteException, InvalidUser;

	/* GESTION USUARIO */
	Usuario comprobarUsusuario (String nombre, String contrasenya) throws RemoteException, InvalidUser;

	Usuario crearUsuario (String nombre, String contrasenya, String email) throws RemoteException, InvalidUser;

	/* NUEVAS RESERVAS */
	Reserva reservar(Usuario personaQueReserva, PeticionReserva peticionReserva) throws RemoteException;

	/* OPCIONES */
	ArrayList<Alojamiento> busquedaOpciones(int horas, int transporte, float presupuesto, int numPersonas, String localizacionActual) throws RemoteException;

	byte[] rutaOptima(Alojamiento alojamiento, String localizacionActual) throws RemoteException;

	byte[] mapaUbicacion(Alojamiento alojamiento, String localizacionActual) throws RemoteException;




}