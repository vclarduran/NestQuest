package server.accesoBD;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.List;
import java.util.ArrayList;

import objetos.Alojamiento;
import objetos.Habitacion;

public class DBManagerHotelProvider {

    public static List<Alojamiento> getAlojamientos(){
        List<Alojamiento> alojamientos = new ArrayList<>();
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
				String jsonResponse = response.body();

				// Convertir la respuesta en un objeto JSON
				JsonParser parser = new JsonParser();
				JsonElement jsonElement = parser.parse(jsonResponse);
				JsonArray alojamientosArray = jsonElement.getAsJsonObject().getAsJsonArray("data");

				for (JsonElement element : alojamientosArray) {
					// System.out.println(element);	//devuelve un elemento pero en formato json
					JsonObject alojamientoObj = element.getAsJsonObject();

					int id = alojamientoObj.get("id").getAsInt();

					JsonObject attributes = alojamientoObj.getAsJsonObject("attributes");
					String nombre = attributes.get("nombre").getAsString();
					String descripcion = attributes.get("descripcion").getAsString();
					String direccion = attributes.get("direccion").getAsString();

					Alojamiento al = new Alojamiento();
					al.setId(id);
					al.setNombre(nombre);
					al.setDescripcion(descripcion);
					al.setDireccion(direccion);

					System.out.println(al.getNombre());

					alojamientos.add(al);
				}

			} else {
				System.out.println("error --> Codigo de estado :" + response.statusCode());
			}
		} catch (IOException | InterruptedException | URISyntaxException e) {
			System.out.println("Error al hacer la solicitud -->" + e.getMessage());
		}
		return alojamientos;
    }


	  public static List<Alojamiento> getHabitaciones(List<Alojamiento> alojamientos){
		List<Habitacion> habitaciones = new ArrayList<>();
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
				String jsonResponse = response.body();

				// Convertir la respuesta en un objeto JSON
				JsonParser parser = new JsonParser();
				JsonElement jsonElement = parser.parse(jsonResponse);
				JsonArray habitacionesArray = jsonElement.getAsJsonObject().getAsJsonArray("data");

				for (JsonElement element : habitacionesArray) {
					// System.out.println(element);	//devuelve un elemento pero en formato json
					JsonObject habitacionesObj = element.getAsJsonObject();

					int id = habitacionesObj.get("id").getAsInt();

					JsonObject attributes = habitacionesObj.getAsJsonObject("attributes");
					String nombre = attributes.get("nombre").getAsString();
					String descripcion = attributes.get("descripcion").getAsString();
					String aforo = attributes.get("aforo").getAsString();

					Habitacion hab = new Habitacion();
					hab.setId(id);
					hab.setNombre(nombre);
					hab.setDescripcion(descripcion);
					hab.setAforo(aforo);

					System.out.println(hab.getNombre());

					habitaciones.add(hab);
				}

				for(Alojamiento alojamiento : alojamientos ){
					
						alojamiento.setHabitacion(habitaciones);
					
				}

			} else {
				System.out.println("error --> Codigo de estado :" + response.statusCode());
			}
		} catch (IOException | InterruptedException | URISyntaxException e) {
			System.out.println("Error al hacer la solicitud -->" + e.getMessage());
		}
		return alojamientos;
    }
}
