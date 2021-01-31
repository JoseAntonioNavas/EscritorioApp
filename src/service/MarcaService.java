package service;

import java.util.ArrayList;
import java.util.List;

import controller.GestionMarcasController.MarcasAPI;
import model.Marca;


public class MarcaService {

	
	public static List<MarcasAPI> getAllMarcas() {
		
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
	
	
	
}
