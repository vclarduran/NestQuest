package appService; 

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.remote.ServerBook;
import server.remote.IServerBook;

public class NestQuestService_Book {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("usage: java [policy] [codebase] server.Server [host] [port] [server]");
            System.exit(0);
        }

        String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

        try {
            IServerBook objServer = new ServerBook(this.class);
            Registry registry = LocateRegistry.createRegistry(Integer.valueOf(args[1]));
            registry.rebind(name, objServer);
            System.out.println("* Server '" + name + "' active and waiting...");

        } catch (Exception e) {
            System.err.println("- Exception running the server: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String conseguirAlojamientos(){
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
}