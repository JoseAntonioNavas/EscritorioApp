package service;

import java.util.List;

import logic.DetallesUsuarioLogic;

public class DetallesUsuarioService {
	
	// Listar todos los elementos de la tabla detalle_usuario
	public static List<Object> getListDetalleUsuario() throws Exception {
		
		
		String urlWebService = "http://localhost/VehiculosAPI/WebService/public/api/detalles-usuario";
		String response =  logic.PeticionHTTP.peticionHttpGET(urlWebService);
		
		return DetallesUsuarioLogic.JsonToDetallesUsuariosObject(response);
		

	}
	
	
	// Listar el elmento  de la tabla detalle_usuario por ID
		public static List<Object> getListDetalleUsuarioByID(String id) throws Exception {
			
			
			String urlWebService = "http://localhost/VehiculosAPI/WebService/public/api/detalles-usuarioById/"+ id;
			String response =  logic.PeticionHTTP.peticionHttpGET(urlWebService);
			
			System.out.println(DetallesUsuarioLogic.JsonToDetallesUsuariosObject(response));
			return DetallesUsuarioLogic.JsonToDetallesUsuariosObject(response);
			
		}

}
