package service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.google.gson.Gson;

import logic.ErrorLogic;
import model.Usuario;

public class UsuarioService {

	
	public static List<Usuario> login(Usuario usuario) throws Exception{
		
		String urlWebService = logic.globalVariables.HOST + "api/usuario/login";
		
		Gson g = new Gson();
		String jsonInString = g.toJson(usuario);
	
		JSONObject usuarioObject  = new JSONObject(jsonInString);
	
		String response =  logic.PeticionHTTP.peticionHttpPOST(urlWebService, usuarioObject);
		
		// Convertimos la respuesta a una lista de USUARIOS
		return logic.UsuarioLogic.JsonToUsuarios(response);
		
		
	}
	
	public static String updatePassword(Usuario usuario) throws Exception {
		
	String urlWebService = logic.globalVariables.HOST + "api/usuario/updatePassword";
		
		Gson g = new Gson();
		String jsonInString = g.toJson(usuario);
	
		JSONObject usuarioObject  = new JSONObject(jsonInString);
	
		String response =  logic.PeticionHTTP.peticionHttpPOST(urlWebService, usuarioObject);
		
		List<ErrorLogic> Errorlog = logic.ErrorLogic.JsonToErrores(response);
		return Errorlog.get(0).getMsg();
		
		
	}
	
	public static List<Usuario> getUsuarios(Object parametros) throws Exception{
		
		List<Usuario> listUsuario = new ArrayList<Usuario>();
		
		String urlWebService = logic.globalVariables.HOST + "api/usuario/getUsuarios";
		
		JSONObject o = logic.LogicApp.ObjetoToJson(parametros);
		
		String response = logic.PeticionHTTP.peticionHttpPOST(urlWebService,o);
		listUsuario = logic.UsuarioLogic.JsonToUsuarios(response);
		
		return listUsuario;
		
	}
	
	public static String insertarUsuario(Usuario usuario) throws Exception{
		
	
		String urlWebService = logic.globalVariables.HOST + "api/usuario/new";
		
		JSONObject o = logic.LogicApp.ObjetoToJson(usuario);
		
		String response = logic.PeticionHTTP.peticionHttpPOST(urlWebService,o);
		List<ErrorLogic> p = logic.ErrorLogic.JsonToErrores(response);
		
		return p.get(0).getMsg();
				
	}

	public static String deleteUsuario(String id) throws Exception {
		
		
		
		
		String urlWebService = logic.globalVariables.HOST + "api/usuario/deleteById/"+id;
		
		String response;
		
		response = logic.PeticionHTTP.peticionHttpGET(urlWebService);
		List<ErrorLogic> Errorlog = logic.ErrorLogic.JsonToErrores(response);
		return Errorlog.get(0).getMsg();
			
		

	}
	
	
}
