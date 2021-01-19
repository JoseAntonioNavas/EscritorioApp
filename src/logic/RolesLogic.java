package logic;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import model.Roles;

public class RolesLogic {
	
	
public static List<Roles> JsonToRoles(String response) {
		
		List<Roles> listRoles = new ArrayList<>();
		
		JSONArray jsonA = new JSONArray(response);
		for (int i = 0; i < jsonA.length(); i++) {
			
			JSONObject jsonO = jsonA.getJSONObject(i);
			Roles r = JsonToRol(jsonO);
					
			listRoles.add(r);
				
		}
	
		return listRoles;
	}
	
	private static Roles JsonToRol(JSONObject jsonO) {
		
		 
		    int id_rol = jsonO.getInt("id_rol");
		    String nombre_rol = jsonO.getString("nombre_rol");
		    
		    Roles r = new Roles(id_rol,nombre_rol);
		    return r;
		     
	}
	

}
