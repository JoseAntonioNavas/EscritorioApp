package service;

import java.util.List;

import org.json.JSONObject;

import com.google.gson.Gson;

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

	
	
	
}
