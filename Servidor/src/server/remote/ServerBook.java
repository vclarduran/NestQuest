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

import objetos.Alojamiento;
import objetos.PeticionReserva;
import objetos.Reserva;
import objetos.Usuario;


public class ServerBook extends UnicastRemoteObject implements IServerBook {

	private static final long serialVersionUID = 1L;

	public ServerBook() throws RemoteException {
		super();
	}

	@Override
	public String getAlojamientos() throws RemoteException {
		String respuesta = null;
		String url = "https://ds2324.arambarri.eus/api/alojamientos";
		String token = "0518ee96193abf0dca7b3a46591653eb2b162f3fb2dd6fa681b65b97e3e00243187a1b6839aac73946715fb62719b12a1eb14afc36018935b935c2dbf293448fc98a5cde5a219fc208a3db97489b2c2c479825f212d87658ff3b369e4951b0b3f101ac8d52330262e60846ae80b45b6799c69371e4f47a548053137ada4ec6e5";

		try {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(new URI(url))
					.header("Authorization", "Bearer " + token)
					.GET()
					.build();

			HttpResponse<String> response = HttpClient.newHttpClient().send(request,
					HttpResponse.BodyHandlers.ofString());

			if (response.statusCode() == 200) {
				respuesta = response.body();
				return respuesta;
			} else {
				System.out.println("error --> Codigo de estado :" + response.statusCode());
			}
		} catch (IOException | InterruptedException | URISyntaxException e) {
			System.out.println("Error al hacer la solicitud -->" + e.getMessage());
		}
		return respuesta;
	}

	@Override
	public Usuario comprobarUsusuario(String nombre, String contrasenya) throws RemoteException {
		throw new UnsupportedOperationException("Unimplemented method 'comprobarUsusuario'");
	}

	@Override
	public Usuario crearUsuario(String nombre, String contrasenya, String email) throws RemoteException {
		throw new UnsupportedOperationException("Unimplemented method 'crearUsuario'");
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