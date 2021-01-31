package logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class PeticionHTTP {

	public static String peticionHttpGET(String urlWebService)throws Exception{
		StringBuilder resultado = new StringBuilder();
			
		
		// Realizar la peticón http
		URL url = new URL(urlWebService);
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("GET");
		
		//Recogemos los datos
		BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		
		String linea;
		while ((linea = rd.readLine()) != null) {
			
			resultado.append(linea);
			
		}
		
		rd.close();
		
		return resultado.toString();
		
		
	}
	
	
	public static String peticionHttpPOST(String urlWebService,JSONObject objecto) throws Exception {
	
	
		// Realizar la peticón http
		URL url = new URL(urlWebService);
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("POST");
		
		conexion.setRequestProperty("Content-Type", "application/json; utf-8");
		conexion.setRequestProperty("Accept", "application/json");
		conexion.setDoOutput(true);

		
		String jsonInputString = objecto.toString();
		
		try(OutputStream os = conexion.getOutputStream()) {
		    byte[] input = jsonInputString.getBytes("utf-8");
		    os.write(input, 0, input.length);			
		}
		
	
		
		try(BufferedReader br = new BufferedReader(
				  new InputStreamReader(conexion.getInputStream(), "utf-8"))) {
					StringBuilder response = new StringBuilder();
				    String responseLine = null;
				    
				    while ((responseLine = br.readLine()) != null) {
				        response.append(responseLine.trim());
				    }
				   
			return response.toString();
		}
		
	
		
	}
	
	
	public static String peticionHttpDELETE(String urlWebService)throws Exception{
		StringBuilder resultado = new StringBuilder();
			
		// Realizar la peticón http
		URL url = new URL(urlWebService);
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("DELETE");
		
		//Recogemos los datos
		BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		
		String linea;
		while ((linea = rd.readLine()) != null) {
			
			resultado.append(linea);
			
		}
		
		rd.close();
		
		return resultado.toString();
		
		
	}
	
	
	public static String peticionHttpPUT(String urlWebService,JSONObject objecto) throws Exception {
		
		
		// Realizar la peticón http
		URL url = new URL(urlWebService);
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("PUT");
		
		conexion.setRequestProperty("Content-Type", "application/json; utf-8");
		conexion.setRequestProperty("Accept", "application/json");
		conexion.setDoOutput(true);

		
		String jsonInputString = objecto.toString();
		
		try(OutputStream os = conexion.getOutputStream()) {
		    byte[] input = jsonInputString.getBytes("utf-8");
		    os.write(input, 0, input.length);			
		}
		
	
		
		try(BufferedReader br = new BufferedReader(
				  new InputStreamReader(conexion.getInputStream(), "utf-8"))) {
					StringBuilder response = new StringBuilder();
				    String responseLine = null;
				    
				    while ((responseLine = br.readLine()) != null) {
				        response.append(responseLine.trim());
				    }
				   
			return response.toString();
		}
		
	
		
	}
	
	
	
	
	
}
