package service;

import java.util.List;

import org.json.JSONObject;

import com.google.gson.Gson;

import logic.DetallesUsuarioLogic;
import model.DetallesUsuario;

public class DetallesUsuarioService {
	

	Gson g = new Gson();
	
	// Listar todos los elementos de la tabla detalle_usuario
	public static List<Object> getListDetalleUsuario() throws Exception {
		
		
		String urlWebService = "http://localhost/VehiculosAPI/WebService/public/api/detalles-usuario";
		String response =  logic.PeticionHTTP.peticionHttpGET(urlWebService);
		
		return DetallesUsuarioLogic.JsonToDetallesUsuariosObject(response);
		

	}
	
	
	// Listar el elmento  de la tabla detalle_usuario por ID
	public static List<Object> getListDetalleUsuarioByID(String id) throws Exception {
			
			
		String urlWebService = "http://localhost/VehiculosAPI/WebService/public/api/detalles-usuarioById/"+ id;
		String response =  logic.PeticionHTTP.peticionHttpGET(urlWebService);
			
		return DetallesUsuarioLogic.JsonToDetallesUsuariosObject(response);
			
	}
	
	public static void newDetallesUsuario(DetallesUsuario detallesUsuario) throws Exception {
		
	
		
		String urlWebService = "http://localhost/VehiculosAPI/WebService/public/api/detalles-usuario/new/";
		Gson g = new Gson();
		String jsonInString = g.toJson(detallesUsuario);
	
		JSONObject dUsuarioObject  = new JSONObject(jsonInString);
		
		String response =  logic.PeticionHTTP.peticionHttpPOST(urlWebService, dUsuarioObject);
			
		
			
	}	
	
		

}
