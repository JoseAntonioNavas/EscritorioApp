package logic;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Color;
import model.DetallesUsuario;
import model.GenericUsuario;
import model.Marca;
import model.Modelo;
import model.Roles;
import model.Usuario;
import model.Vehiculo;

public class VehiculoLogic {

	public static List<Vehiculo> JsonToDetallesUsuariosObject(String response) {
		
		List<Vehiculo> listObject = new ArrayList<>();
		
	
		JSONArray jsonA = new JSONArray(response);
		for (int i = 0; i < jsonA.length(); i++) {
			
			JSONObject jsonO = jsonA.getJSONObject(i);
			Vehiculo dU = JsonToVehiculo(jsonO);
			listObject.add(dU);
				
		}
	
		return listObject;
	}

	public static Vehiculo JsonToVehiculo(JSONObject jsonO) {
		
			Integer id_vehiculo = jsonO.getInt("id_vehiculo");
			
			Integer id_marca = jsonO.getJSONObject("marca").getInt("id_marca");
			String nombre_marca = jsonO.getJSONObject("marca").getString("nombre_marca");
			
			Integer id_modelo = jsonO.getJSONObject("modelo").getInt("id_modelo");
			String nombre_modelo = jsonO.getJSONObject("modelo").getString("nombre_modelo");
			Integer potencia = jsonO.getJSONObject("modelo").getInt("potencia");
			float precio = jsonO.getJSONObject("modelo").getFloat("precio");
			
			String matricula = jsonO.getString("matricula");
			
			Integer id_color = jsonO.getJSONObject("color").getInt("id_color");
			String nombre_color = jsonO.getJSONObject("color").getString("nombre_color");
			String rgbcolor = jsonO.getJSONObject("color").getString("nombre_color");

		   
			Marca m = new Marca(id_marca, nombre_marca);
			Modelo mo = new Modelo(id_modelo, nombre_modelo, id_marca, potencia, precio);
			Color co = new Color(id_color,nombre_color,rgbcolor);
			
			
			return  new Vehiculo(id_vehiculo, m, mo, matricula, co);
		
	     
	}
	
	
}
