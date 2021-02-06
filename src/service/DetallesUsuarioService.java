package service;

import java.util.List;

import org.json.JSONObject;

import com.google.gson.Gson;

import logic.DetallesUsuarioLogic;
import logic.ErrorLogic;
import model.DetallesUsuario;
import model.GenericUsuario;

public class DetallesUsuarioService {
	

	
	// Listar todos los elementos de la tabla detalle_usuario
	public static List<GenericUsuario> getListDetalleUsuario(Object parametros) throws Exception {
		
		
		String urlWebService = "https://joseant1.000webhostapp.com/public/api/detalles-usuario";
		
		JSONObject o = logic.LogicApp.ObjetoToJson(parametros);
		String response =  logic.PeticionHTTP.peticionHttpPOST(urlWebService,o);
		
		return DetallesUsuarioLogic.JsonToDetallesUsuariosObject(response);
		

	}
	
	
	// Listar el elmento  de la tabla detalle_usuario por ID
	public static List<GenericUsuario> getListDetalleUsuarioByID(String id) throws Exception {
			
			
		String urlWebService = "https://joseant1.000webhostapp.com/public/api/detalles-usuarioById/"+ id;
		String response =  logic.PeticionHTTP.peticionHttpGET(urlWebService);
			
		return DetallesUsuarioLogic.JsonToDetallesUsuariosObject(response);
			
	}
	
	public static String newDetallesUsuario(DetallesUsuario detallesUsuario) throws Exception {
		
	
		
		String urlWebService = "https://joseant1.000webhostapp.com/public/api/detalles-usuario/new";
		Gson g = new Gson();
		String jsonInString = g.toJson(detallesUsuario);
	
		JSONObject dUsuarioObject  = new JSONObject(jsonInString);
		
		String response =  logic.PeticionHTTP.peticionHttpPOST(urlWebService, dUsuarioObject);
			
		List<ErrorLogic> p = logic.ErrorLogic.JsonToErrores(response);
		return p.get(0).getMsg();
		
			
	}	
	
	
	public static String updateDetallesUsuario(DetallesUsuario detallesUsuario) throws Exception{
		
		
		String urlWebService = "https://joseant1.000webhostapp.com/public/api/detalles-usuario/update";
		Gson g = new Gson();
		String jsonInString = g.toJson(detallesUsuario);
		JSONObject dUsuarioObject  = new JSONObject(jsonInString);
		
		String response =  logic.PeticionHTTP.peticionHttpPOST(urlWebService, dUsuarioObject);
			
		List<ErrorLogic> p = logic.ErrorLogic.JsonToErrores(response);
		return p.get(0).getMsg();
	}
	
		

}
