package model;

public class editVehiculo {
	
	private int id_vehiculo;
	private int id_color;
	private String matricula;
	private String fileData;
	
	public editVehiculo(int id_vehiculo, int id_color, String matricula,String fileData) {
		super();
		this.id_vehiculo = id_vehiculo;
		this.id_color = id_color;
		this.matricula = matricula;
		this.fileData = fileData;
	};
	

	public int getId_vehiculo() {
		return id_vehiculo;
	}
	public void setId_vehiculo(int id_vehiculo) {
		this.id_vehiculo = id_vehiculo;
	}
	public int getId_color() {
		return id_color;
	}
	public void setId_color(int id_color) {
		this.id_color = id_color;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getFileData() {
		return fileData;
	}
	public void setFileData(String fileData) {
		this.fileData = fileData;
	}
	@Override
	public String toString() {
		return "editVehiculo [id_vehiculo=" + id_vehiculo + ", id_color=" + id_color + ", matricula=" + matricula
				+ ", fileData=" + fileData + "]";
	}
	
	
	
	
	
	

}
