package controller;

import java.util.List;

import model.GenericModelo;
import service.ModeloService;

public class GestionModelosController {

	
	
	private static List<GenericModelo> getAllModelos() {
		
		BusquedaModelo m = new BusquedaModelo("",  -1 ,"", -1 ,-1 , -1, -1);
		return ModeloService.getAllModelos(m);
		
	}
	
	public static void pintarTableModelo() {
		
		List<GenericModelo> lstModelos = getAllModelos();
		logic.ModeloLogic.pintarTableMarca(lstModelos, view.GestionModelos.table);
		
	}
	

	public static class BusquedaModelo{
		
		private String nombre_modelo;
		private int id_modelo;
		private String nombre_marca;
		private int id_marca;
		private int potenciaMin;
		private int potenciaMax;
		private int visible;
		
		public BusquedaModelo(String nombre_modelo, int id_modelo, String nombre_marca, int id_marca, int potenciaMin,
				int potenciaMax, int visible) {
			
			this.nombre_modelo = nombre_modelo;
			this.id_modelo = id_modelo;
			this.nombre_marca = nombre_marca;
			this.id_marca = id_marca;
			this.potenciaMin = potenciaMin;
			this.potenciaMax = potenciaMax;
			this.visible = visible;
		}

		public String getNombre_modelo() {
			return nombre_modelo;
		}

		public void setNombre_modelo(String nombre_modelo) {
			this.nombre_modelo = nombre_modelo;
		}

		public int getId_modelo() {
			return id_modelo;
		}

		public void setId_modelo(int id_modelo) {
			this.id_modelo = id_modelo;
		}

		public String getNombre_marca() {
			return nombre_marca;
		}

		public void setNombre_marca(String nombre_marca) {
			this.nombre_marca = nombre_marca;
		}

		public int getId_marca() {
			return id_marca;
		}

		public void setId_marca(int id_marca) {
			this.id_marca = id_marca;
		}

		public int getPotenciaMin() {
			return potenciaMin;
		}

		public void setPotenciaMin(int potenciaMin) {
			this.potenciaMin = potenciaMin;
		}

		public int getPotenciaMax() {
			return potenciaMax;
		}

		public void setPotenciaMax(int potenciaMax) {
			this.potenciaMax = potenciaMax;
		}

		public int getVisible() {
			return visible;
		}

		public void setVisible(int visible) {
			this.visible = visible;
		}

		@Override
		public String toString() {
			return "BusquedaModelo [nombre_modelo=" + nombre_modelo + ", id_modelo=" + id_modelo + ", nombre_marca="
					+ nombre_marca + ", id_marca=" + id_marca + ", potenciaMin=" + potenciaMin + ", potenciaMax="
					+ potenciaMax + ", visible=" + visible + "]";
		}
	
	}

	
}
