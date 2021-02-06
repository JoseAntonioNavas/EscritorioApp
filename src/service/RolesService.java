package service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import model.Roles;
import model.Usuario;

public class RolesService {

	
	
	public static List<Roles> getRoles() {
		
			List<Roles> listRoles = new ArrayList<Roles>();
			
			String urlWebService = "https://joseant1.000webhostapp.com/public/api/rol/getRol";
			
			try {
				String response = logic.PeticionHTTP.peticionHttpGET(urlWebService);
				
				listRoles = logic.RolesLogic.JsonToRoles(response);
				
				
				return listRoles;
				
			} catch (Exception e) {
				
				return listRoles;
			}
			
		}
		
	

}
