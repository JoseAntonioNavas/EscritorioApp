package model;

public class photoCoche {
	
	private int id_vehiculo;
	private String fileData;
	
	public int getId_vehiculo() {
		return id_vehiculo;
	}
	public void setId_vehiculo(int id_vehiculo) {
		this.id_vehiculo = id_vehiculo;
	}
	public String getFileData() {
		return fileData;
	}
	public void setFileData(String fileData) {
		this.fileData = fileData;
	}
	public photoCoche(int id_vehiculo, String fileData) {
		super();
		this.id_vehiculo = id_vehiculo;
		this.fileData = fileData;
	}
	
	public photoCoche( String fileData) {
		
		this.fileData = fileData;
	}
	
	@Override
	public String toString() {
		return "photoCoche [id_vehiculo=" + id_vehiculo + ", fileData=" + fileData + "]";
	}
	
	

}
