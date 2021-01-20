package logic;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Usuario;

public class UsuarioLogic {
	


	public static List<Usuario> JsonToUsuarios(String response) {
		List<Usuario> lstResultado = new ArrayList<>();
		
		JSONArray jsonA = new JSONArray(response);
		for (int i = 0; i < jsonA.length(); i++) {
			
			JSONObject jsonO = jsonA.getJSONObject(i);
			Usuario u = JsonToUsuario(jsonO);
					
					lstResultado.add(u);
				
		}
	
		return lstResultado;
	}
	
	public static Usuario JsonToUsuario(JSONObject jsonO) {
		
		   	Integer id_user = jsonO.getInt("id_user");
		    String email = jsonO.getString("email");
		    String password = jsonO.getString("passwd");
		     
		     
		     Usuario u = new Usuario(id_user, email, password);
		     return u;
		     
	}
	
	

}
