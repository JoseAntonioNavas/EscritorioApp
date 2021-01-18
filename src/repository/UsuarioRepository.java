package repository;

import java.util.List;

import org.json.JSONObject;

import model.Usuario;

public class UsuarioRepository {

	
	public static List<Usuario> login(JSONObject usuario) throws Exception{
		
		String urlWebService = "http://localhost/VehiculosAPI/WebService/public/api/usuario/login";
		String response =  logic.PeticionHTTP.peticionHttpPOST(urlWebService, usuario);
		
		
		// Convertimos la respuesta a una lista de USUARIOS
		return logic.UsuarioLogic.JsonToUsuarios(response);
		
		
	}
	
}
