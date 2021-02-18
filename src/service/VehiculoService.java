package service;

import java.util.List;

import org.json.JSONObject;

import com.google.gson.Gson;

import logic.ErrorLogic;
import model.BusquedaVehiculo;
import model.Vehiculo;

public class VehiculoService {

	
	
	public static List<Vehiculo> getAllVehiculos(BusquedaVehiculo o) throws Exception {
		

		String urlWebService = "https://joseant1.000webhostapp.com/public/api/vehiculos/getVehiculosBBDD";
		
		Gson g = new Gson();
		String jsonInString = g.toJson(o);
	
		JSONObject Object  = new JSONObject(jsonInString);
	
		String response =  logic.PeticionHTTP.peticionHttpPOST(urlWebService, Object);
		

		return logic.VehiculoLogic.JsonToVehiculos(response);
		
	}
	
	
	public static String getUltimoIDVehiculo() throws Exception {
		
		String urlWebService = "https://joseant1.000webhostapp.com/public//api/vehiculos/getMaxID";
		
		String response;
		return  response = logic.PeticionHTTP.peticionHttpGET(urlWebService);	
	}
	
	public static List<ErrorLogic> newVehiculo(Vehiculo v) throws Exception{
		
	
		String urlWebService = "https://joseant1.000webhostapp.com/public/api/vehiculos/new";
		
		Gson g = new Gson();
		String jsonInString = g.toJson(v);
		
		System.out.println(v);
	
		JSONObject Object  = new JSONObject(jsonInString);
	
		String response =  logic.PeticionHTTP.peticionHttpPOST(urlWebService, Object);
		
		
		return logic.ErrorLogic.JsonToErrores(response);
		
		
	}
	
	public static String deleteVehiculo(String id_vehiculo) throws Exception {
	
		String urlWebService =  "https://joseant1.000webhostapp.com/public//api/vehiculos/deleteById/"+id_vehiculo;
		
		String response = logic.PeticionHTTP.peticionHttpGET(urlWebService);	
		return logic.ErrorLogic.JsonToErrores(response).get(0).getMsg();
		
		
	}
	
	
}
