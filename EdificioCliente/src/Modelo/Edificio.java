package Modelo;

public class Edificio {

	private int ID_EDIFICIO;
	private String NOMBRE_EDIFICIO;
	private String DIRECCION;
	private String CIUDAD;
	private String mensaje;

	

	public Edificio(int ID_EDIFICIO, String NOMBRE_EDIFICIO, String DIRECCION, String CIUDAD,String mensaje) {
		this.ID_EDIFICIO = ID_EDIFICIO;
		this.NOMBRE_EDIFICIO = NOMBRE_EDIFICIO;
		this.DIRECCION = DIRECCION;
		this.CIUDAD = CIUDAD;
		this.mensaje=mensaje;
	}

	public Edificio(int ID_EDIFICIO, String NOMBRE_EDIFICIO, String DIRECCION, String CIUDAD) {
		this.ID_EDIFICIO = ID_EDIFICIO;
		this.NOMBRE_EDIFICIO = NOMBRE_EDIFICIO;
		this.DIRECCION = DIRECCION;
		this.CIUDAD = CIUDAD;	}

	public int getID_EDIFICIO() {
		return ID_EDIFICIO;
	}

	public void setID_EDIFICIO(int iD_EDIFICIO) {
		ID_EDIFICIO = iD_EDIFICIO;
	}

	public String getNOMBRE_EDIFICIO() {
		return NOMBRE_EDIFICIO;
	}

	public void setNOMBRE_EDIFICIO(String nOMBRE_EDIFICIO) {
		NOMBRE_EDIFICIO = nOMBRE_EDIFICIO;
	}

	public String getDIRECCION() {
		return DIRECCION;
	}

	public void setDIRECCION(String dIRECCION) {
		DIRECCION = dIRECCION;
	}

	public String getCIUDAD() {
		return CIUDAD;
	}

	public void setCIUDAD(String cIUDAD) {
		CIUDAD = cIUDAD;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
