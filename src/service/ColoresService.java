package service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.google.gson.Gson;

import logic.ErrorLogic;
import model.Color;


public class ColoresService {

	public static List<Color> getColor(Object parametros) {
		
		List<Color> listRoles = new ArrayList<Color>();
		
		String urlWebService = "https://joseant1.000webhostapp.com/public/api/color/getColor";
		
		// Object to Json
		JSONObject o = logic.LogicApp.ObjetoToJson(parametros);
		
		try {
			String response = logic.PeticionHTTP.peticionHttpPOST(urlWebService,o);
			
			return logic.ColorLogic.JsonToColors(response);
		
			
		} catch (Exception e) {
			return listRoles;
		}


		
	}

	public static String nuevoColor(Object parametros) {
		
		String urlWebService = "https://joseant1.000webhostapp.com/public/api/color/new";
				// Object to Json
		JSONObject o = logic.LogicApp.ObjetoToJson(parametros);
		
		try {
			String response = logic.PeticionHTTP.peticionHttpPOST(urlWebService,o);
			List<ErrorLogic> Errorlog = logic.ErrorLogic.JsonToErrores(response);
			
			return Errorlog.get(0).getMsg();
		} catch (Exception e) {
			return null;
		}
	}

}
