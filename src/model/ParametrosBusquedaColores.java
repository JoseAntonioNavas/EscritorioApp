package model;

public class ParametrosBusquedaColores {

	private String nombre_color;

	
	public ParametrosBusquedaColores(String nombre_color) {
		
		this.nombre_color = nombre_color;
	}

	public String getNombre_color() {
		return nombre_color;
	}

	public void setNombre_color(String nombre_color) {
		this.nombre_color = nombre_color;
	}

	@Override
	public String toString() {
		return "ParametrosBusquedaColores [nombre_color=" + nombre_color + "]";
	}
}
