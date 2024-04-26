package server.remote;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.List;
import java.util.ArrayList;

import objetos.Alojamiento;

import objetos.Alojamiento;
import objetos.PeticionReserva;
import objetos.Reserva;
import objetos.Usuario;
import server.appService.NestQuestService_Book;


public class ServerBook extends UnicastRemoteObject implements IServerBook {

	private static final long serialVersionUID = 1L;
	private NestQuestService_Book appService = null;

	public ServerBook(NestQuestService_Book as) throws RemoteException {
		super();
		this.appService = as; 
	}

	@Override
	public List<Alojamiento> getAlojamientos() throws RemoteException {
		return appService.conseguirAlojamientos();
	}

	@Override
	public Usuario comprobarUsuario(String usuario, String contrasenya) throws RemoteException {
		return appService.comprobarUsuario(usuario, contrasenya);
		// throw new UnsupportedOperationException("Unimplemented method 'comprobarUsuario'");
	}

	@Override
	public boolean crearUsuario(Usuario usuario) throws RemoteException {
		return appService.crearUsuario(usuario);
		// throw new UnsupportedOperationException("Unimplemented method 'crearUsuario'");
	}

	@Override
	public Reserva reservar(Usuario personaQueReserva, PeticionReserva peticionReserva) throws RemoteException {
		throw new UnsupportedOperationException("Unimplemented method 'reservar'");
	}


	@Override
	public byte[] rutaOptima(Alojamiento alojamiento, String localizacionActual) throws RemoteException {
		throw new UnsupportedOperationException("Unimplemented method 'rutaOptima'");
	}

	@Override
	public byte[] mapaUbicacion(Alojamiento alojamiento, String localizacionActual) throws RemoteException {
		throw new UnsupportedOperationException("Unimplemented method 'mapaUbicacion'");
	}

	@Override
	public ArrayList<Alojamiento> busquedaOpciones(int horas, int transporte, float presupuesto, Date fechaSalida,
			Date fechaEntrada, String localizacionActual, int numPersonas) throws RemoteException {
		throw new UnsupportedOperationException("Unimplemented method 'busquedaOpciones'");
	}

}