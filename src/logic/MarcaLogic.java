package logic;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import controller.GestionMarcasController.MarcasAPI;
import model.Marca;;

public class MarcaLogic {

	public static List<Marca> JsonToMarcas(String response) {
		List<Marca> lstResultado = new ArrayList<>();
		
		JSONArray jsonA = new JSONArray(response);
		for (int i = 0; i < jsonA.length(); i++) {
			
			JSONObject jsonO = jsonA.getJSONObject(i);
			Marca u = JsonToUsMarca(jsonO);
					
					lstResultado.add(u);
				
		}
	
		return lstResultado;
	}
	
	private static Marca JsonToUsMarca(JSONObject jsonO) {
		
		   	Integer id_marca = jsonO.getInt("id_marca");
		    String nombre_marca = jsonO.getString("nombre_marca");
		    Integer visible = jsonO.getInt("visible");
		    
		     Marca u = new Marca(id_marca, nombre_marca, visible);
		     return u;
		     
	}
	
	
	
	public static List<MarcasAPI> JsonToMarcasAPI(String response) {
		List<MarcasAPI> lstResultado = new ArrayList<>();
		
		JSONArray jsonA = new JSONArray(response);
		for (int i = 0; i < jsonA.length(); i++) {
			
			JSONObject jsonO = jsonA.getJSONObject(i);
			MarcasAPI u = JsonToUsMarcaAPI(jsonO);
					
					lstResultado.add(u);
				
		}
	
		return lstResultado;
	}
	
	private static MarcasAPI JsonToUsMarcaAPI(JSONObject jsonO) {
		
		   	Integer Make_ID = jsonO.getInt("Make_ID");
		    String Make_Name = jsonO.getString("Make_Name");
		
		    
		     controller.GestionMarcasController.MarcasAPI u = new MarcasAPI(Make_ID, Make_Name);
		   
		     return u;
		     
	}
	
	
	
	
}
