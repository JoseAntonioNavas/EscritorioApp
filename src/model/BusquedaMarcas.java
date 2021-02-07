package model;

public class BusquedaMarcas {

	
		private String nombre_marca;
		private String visible;
		
		
		
		public BusquedaMarcas(String nombre_marca, String visible) {
			this.nombre_marca = nombre_marca;
			this.visible = visible;
		}
		@Override
		public String toString() {
			return "BusquedaMarcas [nombre_marca=" + nombre_marca + ", visible=" + visible + "]";
		}
		public String getNombre_marca() {
			return nombre_marca;
		}
		public void setNombre_marca(String nombre_marca) {
			this.nombre_marca = nombre_marca;
		}
		public String getVisible() {
			return visible;
		}
		public void setVisible(String visible) {
			this.visible = visible;
		}
		
		
	
	
}
