package model;

public class BusquedaVehiculo {

	private String busquedaVehiculo;

	public BusquedaVehiculo(String busquedaVehiculo) {
		
		this.busquedaVehiculo = busquedaVehiculo;
	}

	public String getBusquedaVehiculo() {
		return busquedaVehiculo;
	}

	public void setBusquedaVehiculo(String busquedaVehiculo) {
		this.busquedaVehiculo = busquedaVehiculo;
	}

	@Override
	public String toString() {
		return "BusquedaVehiculo [busquedaVehiculo=" + busquedaVehiculo + "]";
	}
	
	
}
