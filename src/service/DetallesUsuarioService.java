package service;

import logic.DetallesUsuarioLogic;

public class DetallesUsuarioService {
	
	
	public static void getListDetalleUsuario() throws Exception {
		
		
		String urlWebService = "http://localhost/VehiculosAPI/WebService/public/api/detalles-usuario";
		String response =  logic.PeticionHTTP.peticionHttpGET(urlWebService);
		
		DetallesUsuarioLogic.JsonToAllDetallesUsuarios(response);
		// System.out.println(logic.DetallesUsuarioLogic.JsonToDetallesUsuarios(response));

	}

}
