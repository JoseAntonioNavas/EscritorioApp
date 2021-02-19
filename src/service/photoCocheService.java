package service;

public class photoCocheService {
	
	
	public static String getNamePathImgVehiculo(String id_vehiculo) throws Exception {
		
		
		String urlWebService = logic.globalVariables.HOST + "api/photo/downLoadByIdVehiculo/"+id_vehiculo;
		
		return  logic.PeticionHTTP.peticionHttpGET(urlWebService);

	}
	

}
