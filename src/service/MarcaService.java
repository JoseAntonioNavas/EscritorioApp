package service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import controller.GestionMarcasController.MarcasAPI;
import model.Marca;


public class MarcaService {

	
	public static List<MarcasAPI> getAllMarcasAPI() {
		
		List<MarcasAPI> listMarcas = new ArrayList<MarcasAPI>();
		
		String urlWebService = "http://localhost/VehiculosAPI/WebService/public/api/vehiculos/getAllMarcas";
		
		String response;
		
		try {
			response = logic.PeticionHTTP.peticionHttpGET(urlWebService);
			
			return listMarcas = logic.MarcaLogic.JsonToMarcasAPI(response);
			
		} catch (Exception e) {
			return listMarcas;
		}
		
		
		
	}
	
	public static List<Marca> getAllMarcas(Object o){
		
		List<Marca> listMarcas = new ArrayList<Marca>();
		
		String urlWebService = "http://localhost/VehiculosAPI/WebService/public/api/marca/getMarcas";
		
		String response;
		
		//JSONObject o = logic.LogicApp.ObjetoToJson(parametros);
		
		try {
			response = logic.PeticionHTTP.peticionHttpPOST(urlWebService, null);
			
			return listMarcas = null;
			
		} catch (Exception e) {
			return listMarcas;
		}
	}
	
	
	
	
	
}
