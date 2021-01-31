package model;

public class Color {

	private Integer id_color;
	private String nombre_color;
	private String rgbcolor;
	
	
	public Color(String nombre_color, String rdbcolor) {

		
		this.nombre_color = nombre_color;
		this.rgbcolor = rdbcolor;
	}

	
	public Color(Integer id_color, String nombre_color, String rdbcolor) {

		this.id_color = id_color;
		this.nombre_color = nombre_color;
		this.rgbcolor = rdbcolor;
	}


	public Integer getId_color() {
		return id_color;
	}


	public void setId_color(Integer id_color) {
		this.id_color = id_color;
	}


	public String getNombre_color() {
		return nombre_color;
	}


	public void setNombre_color(String nombre_color) {
		this.nombre_color = nombre_color;
	}


	public String getRdbcolor() {
		return rgbcolor;
	}


	public void setRdbcolor(String rdbcolor) {
		this.rgbcolor = rdbcolor;
	}


	@Override
	public String toString() {
		return "Color [id_color=" + id_color + ", nombre_color=" + nombre_color + ", rdbcolor=" + rgbcolor + "]";
	}

	
	
	
}
