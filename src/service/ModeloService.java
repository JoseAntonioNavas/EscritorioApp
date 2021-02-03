package service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import model.GenericModelo;
import model.Marca;

public class ModeloService {

	
	public static List<GenericModelo> getAllModelos(Object parametros) {
		
		
		List<GenericModelo> lstModelo = new ArrayList<GenericModelo>();
		
		String urlWebService = "https://joseant1.000webhostapp.com/public/api/modelo/getModelos";
		JSONObject o = logic.LogicApp.ObjetoToJson(parametros);
		
		String response;
		
		try {
			response = logic.PeticionHTTP.peticionHttpPOST(urlWebService, o);
			
			return lstModelo = logic.ModeloLogic.JsonToGenericModelos(response);
		} catch (Exception e) {
			return lstModelo;
		}
		
		
	}
	
	
}
