package model;

public class Vehiculo {
	
	private int id_vehiculo;
	private Marca marca;
	private Modelo modelo;
	private String matricula;
	private Color color;
	
	private int id_marca;
	private int id_modelo;
	private int id_color;
	
	public Vehiculo( Marca marca, Modelo modelo, String matricula, Color color) {
		
		this.matricula = matricula;
		this.id_marca = marca.getId_marca();
		this.id_modelo = modelo.getId_modelo();
		this.id_color = color.getId_color();
	}
	public Vehiculo(int id_vehiculo, Marca marca, Modelo modelo, String matricula, Color color) {
		
		this.id_vehiculo = id_vehiculo;
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		this.color = color;
	}
	public int getId_vehiculo() {
		return id_vehiculo;
	}
	public void setId_vehiculo(int id_vehiculo) {
		this.id_vehiculo = id_vehiculo;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Vehiculo [id_vehiculo=" + id_vehiculo + ", marca=" + marca + ", modelo=" + modelo + ", matricula="
				+ matricula + ", color=" + color + "]";
	}

	
}
