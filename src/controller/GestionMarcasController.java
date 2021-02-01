package controller;

import java.util.List;

import model.Marca;
import service.MarcaService;
import view.GestionMarcas;

public class GestionMarcasController {

	
	
	public static void getComboboxVisible(){
		
		view.GestionMarcas.comboBoxVisible.addItem("Todos");
		view.GestionMarcas.comboBoxVisible.addItem("Visible");
		view.GestionMarcas.comboBoxVisible.addItem("No Visible");
	}
	
	
	private static BusquedaMarcas getCampos() {
		
		String nombreMarca = view.GestionMarcas.txtFieldMarca.getText();
		String visible = (String) view.GestionMarcas.comboBoxVisible.getSelectedItem();
		
		BusquedaMarcas b = new BusquedaMarcas(nombreMarca, visible);
		return b;
	}
	
	public static List<Marca> getListMarcas() {
		
	   BusquedaMarcas o = getCampos();
	   return MarcaService.getAllMarcas(o);
				
	}
	
	public static void pintarTableMarcas() {
		
		List<Marca> m = getListMarcas();
		logic.MarcaLogic.pintarTableMarca(m , GestionMarcas.table);
	}
	
	
	
	public static class MarcasAPI{
		
		private int Make_ID;
		private String Make_Name;
		public MarcasAPI(int make_ID, String make_Name) {
			super();
			Make_ID = make_ID;
			Make_Name = make_Name;
		}
		public int getMake_ID() {
			return Make_ID;
		}
		public void setMake_ID(int make_ID) {
			Make_ID = make_ID;
		}
		public String getMake_Name() {
			return Make_Name;
		}
		public void setMake_Name(String make_Name) {
			Make_Name = make_Name;
		}
		@Override
		public String toString() {
			return "MarcasAPI [Make_ID=" + Make_ID + ", Make_Name=" + Make_Name + "]";
		}
	
	}
	
	
	public static class BusquedaMarcas{
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
}
