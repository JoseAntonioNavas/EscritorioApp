package service;


import java.util.List;

import model.numMarcas;

public class GraficasService {
	
	
	
	
	public static List<numMarcas> getNumMarcasCatalogo() {
		
		List<numMarcas> nMarcas = null;
		String urlWebService = logic.globalVariables.HOST + "api/vehiculos/getCountByMarca";
		
		String response;
		
		try {
			response = logic.PeticionHTTP.peticionHttpGET(urlWebService);
			
		
			  nMarcas = logic.numMarcasLogic.JsonToNumMarcas(response);
			
			
		} catch (Exception e) {
			
			
		}
		
		return nMarcas;
		
	}
	
public static List<numMarcas> getNumMarcasCarrito() {
		
		List<numMarcas> nMarcas = null;
		String urlWebService = logic.globalVariables.HOST + "api/vehiculos/getCountCarritoByMarca";
		
		String response;
		
		try {
			response = logic.PeticionHTTP.peticionHttpGET(urlWebService);
			
		
			  nMarcas = logic.numMarcasLogic.JsonToNumMarcas(response);
			
			
		} catch (Exception e) {
			
			
		}
		
		return nMarcas;
		
	}

}
