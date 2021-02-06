package service;

import java.util.List;

import org.json.JSONObject;

import com.google.gson.Gson;

import model.BusquedaVehiculo;
import model.Vehiculo;

public class VehiculoService {

	
	
	public static List<Vehiculo> getAllVehiculos(BusquedaVehiculo o) throws Exception {
		

		String urlWebService = "https://joseant1.000webhostapp.com/public/api/vehiculos/getVehiculosBBDD";
		
		Gson g = new Gson();
		String jsonInString = g.toJson(o);
	
		JSONObject Object  = new JSONObject(jsonInString);
	
		String response =  logic.PeticionHTTP.peticionHttpPOST(urlWebService, Object);
		

		return logic.VehiculoLogic.JsonToDetallesUsuariosObject(response);
		
	}
	
	
}
