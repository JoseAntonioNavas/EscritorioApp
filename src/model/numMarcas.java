package model;

public class numMarcas {
	
	
	private String nombre_marca;
	private int numMarca;
	
	public numMarcas(String nombre_marca, int numMarca) {
		this.nombre_marca = nombre_marca;
		this.numMarca = numMarca;
	}
	
	public String getNombre_marca() {
		return nombre_marca;
	}
	
	
	public void setNombre_marca(String nombre_marca) {
		this.nombre_marca = nombre_marca;
	}
	public int getNumMarca() {
		return numMarca;
	}
	public void setNumMarca(int numMarca) {
		this.numMarca = numMarca;
	}

	
	@Override
	public String toString() {
		return "numMarcas [nombre_marca=" + nombre_marca + ", numMarca=" + numMarca + "]";
	}

	
	
}
