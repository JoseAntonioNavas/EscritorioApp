package service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import logic.ErrorLogic;
import model.Marca;
import model.MarcasAPI;


public class MarcaService {

	
	public static List<MarcasAPI> getAllMarcasAPI() {
		
		List<MarcasAPI> listMarcas = new ArrayList<MarcasAPI>();
		
		String urlWebService = logic.globalVariables.HOST + "api/marca/getAllMarcas";
		
		String response;
		
		try {
			response = logic.PeticionHTTP.peticionHttpGET(urlWebService);
			
			return listMarcas = logic.MarcaLogic.JsonToMarcasAPI(response);
			
		} catch (Exception e) {
			return listMarcas;
		}
		
		
		
	}
	
	public static List<Marca> getAllMarcas(Object parametros){
		
		List<Marca> listMarcas = new ArrayList<Marca>();
		
		String urlWebService = logic.globalVariables.HOST + "api/marca/getMarcas";
		JSONObject o = logic.LogicApp.ObjetoToJson(parametros);
		
		
		String response;
		
		try {
			
			response = logic.PeticionHTTP.peticionHttpPOST(urlWebService, o);
			
			return listMarcas = logic.MarcaLogic.JsonToMarcas(response);
		} catch (Exception e) {
			return listMarcas;
		}
		
		
		
	}
	
	
	public static String newMarca(Marca marca) throws Exception {
		
		String urlWebService = logic.globalVariables.HOST + "api/marca/new";
		JSONObject o = logic.LogicApp.ObjetoToJson(marca);

		String response;
		
		response = logic.PeticionHTTP.peticionHttpPOST(urlWebService, o);
		List<ErrorLogic> p = logic.ErrorLogic.JsonToErrores(response);
		return p.get(0).getMsg();
		
	}
	
	public static String updateMarca(Marca marca) throws Exception{
		
		String urlWebService = logic.globalVariables.HOST + "api/marca/update";
		JSONObject o = logic.LogicApp.ObjetoToJson(marca);

		String response;
	
		response = logic.PeticionHTTP.peticionHttpPOST(urlWebService, o);
		List<ErrorLogic> p = logic.ErrorLogic.JsonToErrores(response);
		return p.get(0).getMsg();
	}
	
	
	
	
	
}
