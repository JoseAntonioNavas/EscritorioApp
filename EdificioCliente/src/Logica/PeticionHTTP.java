package Logica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import Modelo.*;

public class PeticionHTTP {

	public static String peticionHttpGET(String string) throws IOException {
		// Esto es lo que vamos a devolver
		StringBuilder resultado = new StringBuilder();
		// Crear un objeto de tipo URL
		URL url = new URL(string);

		// Abrir la conexión e indicar que será de tipo GET
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("GET");
		// Búferes para leer
		BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		String linea;
		// Mientras el BufferedReader se pueda leer, agregar contenido a resultado
		while ((linea = rd.readLine()) != null) {
			resultado.append(linea);
		}
		// Cerrar el BufferedReader
		rd.close();

		// Regresar resultado, pero como cadena, no como StringBuilder
		return resultado.toString();

	}

	public static List<Edificio> jsonToEdificios(String response) {

		List<Edificio> lstResultado = new ArrayList<>();

		JSONArray jsonA = new JSONArray(response);
		for (int i = 0; i < jsonA.length(); i++) {

			JSONObject jsonO = jsonA.getJSONObject(i);
			Edificio p = JsonToEdificio(jsonO);

			lstResultado.add(p);

		}
		return lstResultado;
	}

	public static Edificio JsonToEdificio(JSONObject jsonO) {

		int id_edificio = jsonO.getInt("ID_EDIFICIO");
		String nombre_edificio = jsonO.getString("NOMBRE_EDIFICIO");
		String direccion = jsonO.getString("DIRECCIÓN");
		String ciudad = jsonO.getString("CIUDAD");
		Edificio r = new Edificio(id_edificio, nombre_edificio, direccion, ciudad);
		return r;

	}

}
