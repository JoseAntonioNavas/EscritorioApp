package model;

public class Modelo {

	
	private int id_modelo;
	private String nombre_modelo;
	private int id_marca;
	private int potencia;
	private int visible;
	private float precio;
	
	
	
	
	public Modelo(String nombre_modelo) {
		
		this.nombre_modelo = nombre_modelo;
	}

	public Modelo(int id_modelo, String nombre_modelo, int id_marca, int potencia, int visible, float precio) {
		
		this.id_modelo = id_modelo;
		this.nombre_modelo = nombre_modelo;
		this.id_marca = id_marca;
		this.potencia = potencia;
		this.visible = visible;
		this.precio = precio;
	}

	public Modelo(int id_modelo, String nombre_modelo, int id_marca, int potencia, int visible) {

		this.id_modelo = id_modelo;
		this.nombre_modelo = nombre_modelo;
		this.id_marca = id_marca;
		this.potencia = potencia;
		this.visible = visible;
	}
	
		public Modelo(int id_modelo, String nombre_modelo, int id_marca, int potencia, float precio) {
		
		this.id_modelo = id_modelo;
		this.nombre_modelo = nombre_modelo;
		this.id_marca = id_marca;
		this.potencia = potencia;
		this.precio = precio;
	}
		

	
	
	
	@Override
	public String toString() {
		return "Modelo [id_modelo=" + id_modelo + ", nombre_modelo=" + nombre_modelo + ", id_marca=" + id_marca
				+ ", potencia=" + potencia + ", visible=" + visible + "]";
	}
	
	public int getId_modelo() {
		return id_modelo;
	}
	public void setId_modelo(int id_modelo) {
		this.id_modelo = id_modelo;
	}
	public String getNombre_modelo() {
		return nombre_modelo;
	}
	public void setNombre_modelo(String nombre_modelo) {
		this.nombre_modelo = nombre_modelo;
	}
	public int getId_marca() {
		return id_marca;
	}
	public void setId_marca(int id_marca) {
		this.id_marca = id_marca;
	}
	public int getPotencia() {
		return potencia;
	}
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	public int getVisible() {
		return visible;
	}
	public void setVisible(int visible) {
		this.visible = visible;
	}
	
	
	
	
}
