package server;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.HashMap;

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

	protected ServerBook() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;
	private int cont = 0;
	private HashMap<String, String> registeredUsers = null;

	@Override
	public String sayHello() {
		cont++;
		System.out.println(" * Client number: " + cont);
		return "Hello World!";
	}

	@Override
	public String sayMessage(String login, String password, String message) throws RemoteException, InvalidUser {
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

		try {
			IServerBook objServer = new ServerBook();
			Registry registry = LocateRegistry.createRegistry((Integer.valueOf(args[1])));
			registry.rebind(name, objServer);
			System.out.println("* Server '" + name + "' active and waiting...");
			String s = objServer.getApartamentos();
			System.out.println(s);

		} catch (Exception e) {
			System.err.println("- Exception running the server: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public String getApartamentos() throws RemoteException, InvalidUser {
		String respuesta = null;
		String url = "https://ds2324.arambarri.eus/api/habitaciones";
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
	public Usuario comprobarUsusuario(String nombre, String contrasenya) throws RemoteException, InvalidUser {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'comprobarUsusuario'");
	}

	@Override
	public Usuario crearUsuario(String nombre, String contrasenya, String email) throws RemoteException, InvalidUser {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'crearUsuario'");
	}

	@Override
	public Reserva reservar(Usuario personaQueReserva, PeticionReserva peticionReserva) throws RemoteException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'reservar'");
	}

	@Override
	public ArrayList<Alojamiento> busquedaOpciones(int horas, int transporte, float presupuesto, int numPersonas,
			String localizacionActual) throws RemoteException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'busquedaOpciones'");
	}

	@Override
	public byte[] rutaOptima(Alojamiento alojamiento, String localizacionActual) throws RemoteException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'rutaOptima'");
	}

}