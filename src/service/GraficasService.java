package service;


import java.util.List;

import model.numMarcas;

public class GraficasService {
	
	
	
	
	public static List<numMarcas> getNumMarcasCatalogo() {
		
		List<numMarcas> nMarcas = null;
		String urlWebService = "https://joseant1.000webhostapp.com/public//api/vehiculos/getCountByMarca";
		
		String response;
		
		try {
			response = logic.PeticionHTTP.peticionHttpGET(urlWebService);
			
		
			  nMarcas = logic.numMarcasLogic.JsonToNumMarcas(response);
			
			
		} catch (Exception e) {
			
			
		}
		
		return nMarcas;
		
	}

}
