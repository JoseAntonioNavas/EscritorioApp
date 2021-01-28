package service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import logic.ErrorLogic;
import model.Usuario;

public class UsuarioService {

	
	public static List<Usuario> login(Usuario usuario) throws Exception{
		
		String urlWebService = "http://localhost/VehiculosAPI/WebService/public/api/usuario/login";
		
		Gson g = new Gson();
		String jsonInString = g.toJson(usuario);
	
		JSONObject usuarioObject  = new JSONObject(jsonInString);
	
		String response =  logic.PeticionHTTP.peticionHttpPOST(urlWebService, usuarioObject);
		
		// Convertimos la respuesta a una lista de USUARIOS
		return logic.UsuarioLogic.JsonToUsuarios(response);
		
		
	}
	
	public static void updatePassword(Usuario usuario) throws Exception {
		
	String urlWebService = "http://localhost/VehiculosAPI/WebService/public/api/usuario/updatePassword";
		
		Gson g = new Gson();
		String jsonInString = g.toJson(usuario);
	
		JSONObject usuarioObject  = new JSONObject(jsonInString);
	
		String response =  logic.PeticionHTTP.peticionHttpPOST(urlWebService, usuarioObject);
		
		// Convertimos la respuesta a una lista de USUARIOS
		//return logic.UsuarioLogic.JsonToUsuarios(response);
		
	}
	
	public static List<Usuario> getUsuarios(Object parametros){
		
		List<Usuario> listUsuario = new ArrayList<Usuario>();
		
		String urlWebService = "http://localhost/VehiculosAPI/WebService/public/api/usuario/getUsuarios";
		
		JSONObject o = logic.LogicApp.ObjetoToJson(parametros);
		
	
		try {
				String response = logic.PeticionHTTP.peticionHttpPOST(urlWebService,o);
				listUsuario = logic.UsuarioLogic.JsonToUsuarios(response);
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}


		return listUsuario;
		
	}
	
	public static String insertarUsuario(Usuario usuario){
		
	
		String urlWebService = "http://localhost/VehiculosAPI/WebService/public/api/usuario/new";
		
		JSONObject o = logic.LogicApp.ObjetoToJson(usuario);
		
	
		try {
				String response = logic.PeticionHTTP.peticionHttpPOST(urlWebService,o);
				
				List<ErrorLogic> p = logic.ErrorLogic.JsonToErrores(response);
				
				return p.get(0).getMsg();
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}

		
	}

	public static String deleteUsuario(String id) {
		
		String urlWebService = "http://localhost/VehiculosAPI/WebService/public//api/usuario/deleteById/"+id;
		
		String response;
		try {
			response = logic.PeticionHTTP.peticionHttpDELETE(urlWebService);
			List<ErrorLogic> Errorlog = logic.ErrorLogic.JsonToErrores(response);
			return Errorlog.get(0).getMsg();
			
		} catch (Exception e) {
			return null;
		}
		
		
		
	}
	
	
}
