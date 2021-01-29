package model;

public class GenericUsuario {

	
	private DetallesUsuario detallesUsuario;
	private Usuario usuario;
	private Roles rol;
	
	
	public GenericUsuario(DetallesUsuario detallesUsuario, Usuario usuario, Roles rol) {
		
		this.detallesUsuario = detallesUsuario;
		this.usuario = usuario;
		this.rol = rol;
		
		
	}


	public DetallesUsuario getDetallesUsuario() {
		return detallesUsuario;
	}


	public void setDetallesUsuario(DetallesUsuario detallesUsuario) {
		this.detallesUsuario = detallesUsuario;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Roles getRol() {
		return rol;
	}


	public void setRol(Roles rol) {
		this.rol = rol;
	}


	@Override
	public String toString() {
		return "GenericUsuario [detallesUsuario=" + detallesUsuario + ", usuario=" + usuario + ", rol=" + rol + "]";
	}
	
	
}
