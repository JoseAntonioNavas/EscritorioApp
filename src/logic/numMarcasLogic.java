package logic;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import model.numMarcas;



public class numMarcasLogic {
	
	public static List<numMarcas> JsonToNumMarcas(String response) {
		
		List<numMarcas> listObject = new ArrayList<>();
		
	
		JSONArray jsonA = new JSONArray(response);
		
		for (int i = 0; i < jsonA.length(); i++) {
			
			JSONObject jsonO = jsonA.getJSONObject(i);
			numMarcas dU = JsonToNumsMarcas(jsonO);
			listObject.add(dU);
				
		}
	
		return listObject;
	}

	public static numMarcas JsonToNumsMarcas(JSONObject jsonO) {
				
			
		   	String nombre_marca = jsonO.getString("nombre_marca");
		    Integer numMarca = jsonO.getInt("numMarca");

		    
		   return new numMarcas(nombre_marca,numMarca);
		    
	}
	

}
