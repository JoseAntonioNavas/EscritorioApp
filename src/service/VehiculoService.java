package service;

import java.util.List;

import org.json.JSONObject;

import com.google.gson.Gson;

import logic.ErrorLogic;
import model.BusquedaVehiculo;
import model.Vehiculo;
import model.editVehiculo;

public class VehiculoService {

	
	
	public static List<Vehiculo> getAllVehiculos(BusquedaVehiculo o) throws Exception {
		

		String urlWebService = logic.globalVariables.HOST + "api/vehiculos/getVehiculosBBDD";
		
		Gson g = new Gson();
		String jsonInString = g.toJson(o);
	
		JSONObject Object  = new JSONObject(jsonInString);
	
		String response =  logic.PeticionHTTP.peticionHttpPOST(urlWebService, Object);
		

		return logic.VehiculoLogic.JsonToVehiculos(response);
		
	}
	
	
	public static String getUltimoIDVehiculo() throws Exception {
		
		String urlWebService = logic.globalVariables.HOST + "api/vehiculos/getMaxID";
		
		
		return  logic.PeticionHTTP.peticionHttpGET(urlWebService);	
	}
	
	public static List<ErrorLogic> newVehiculo(Vehiculo v) throws Exception{
		
	
		String urlWebService = logic.globalVariables.HOST + "api/vehiculos/new";
		
		Gson g = new Gson();
		String jsonInString = g.toJson(v);
		
	
		JSONObject Object  = new JSONObject(jsonInString);
	
		String response =  logic.PeticionHTTP.peticionHttpPOST(urlWebService, Object);
		
		
		return logic.ErrorLogic.JsonToErrores(response);
		
		
	}
	
	public static String deleteVehiculo(String id_vehiculo) throws Exception {
	
		String urlWebService =  logic.globalVariables.HOST + "api/vehiculos/deleteById/"+id_vehiculo;
		
		String response = logic.PeticionHTTP.peticionHttpGET(urlWebService);	
		return logic.ErrorLogic.JsonToErrores(response).get(0).getMsg();
		
		
	}
	
	public static String updateVehiculo(editVehiculo ev) throws Exception {
		
		Gson g = new Gson();
		String jsonInString = g.toJson(ev);
		JSONObject Object  = new JSONObject(jsonInString);
		
		
		String urlWebService =  logic.globalVariables.HOST + "api/vehiculos/update";
		String response = logic.PeticionHTTP.peticionHttpPOST(urlWebService, Object);
		
		System.out.println(logic.ErrorLogic.JsonToErrores(response).get(0).getMsg());
		return "";
		
		
	}


	
	
	
}
