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
				Gson gson = new Gson();

				// Convertir la respuesta en un objeto JSON
				JsonParser parser = new JsonParser();
				JsonElement jsonElement = parser.parse(jsonResponse);
				JsonArray jsonArray = jsonElement.getAsJsonArray();

				for (JsonElement element : jsonArray) {
                    JsonObject item = element.getAsJsonObject();
					int id = item.get("id").getAsInt();
                    JsonObject attributes = item.getAsJsonObject("attributes");
                    String nombre = attributes.get("nombre").getAsString();
                    String descripcion = attributes.get("descripcion").getAsString();
                    String direccion = attributes.get("direccion").getAsString();

					Alojamiento al = new Alojamiento();
					al.setId(id);
					al.setNombre(nombre);
					al.setDescripcion(descripcion);
					al.setDireccion(direccion);

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
}
