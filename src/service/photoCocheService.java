package service;

public class photoCocheService {
	
	
	public static String getNamePathImgVehiculo(String id_vehiculo) throws Exception {
		
		
		String urlWebService = "https://joseant1.000webhostapp.com/public/api/photo/downLoadByIdVehiculo/"+id_vehiculo;
		
		return  logic.PeticionHTTP.peticionHttpGET(urlWebService);

	}
	

}
