package controller;

import java.util.List;

import model.BusquedaMarcas;
import model.BusquedaVehiculo;
import model.Color;
import model.GenericModelo;
import model.Marca;
import model.Modelo;
import model.ParametrosBusquedaColores;
import model.Vehiculo;
import service.VehiculoService;

public class GestionVehiculoController {
	
	private static List<model.Color> lstColor;
	private static List<Marca> lstAllMarcasVisibles;
	private static List<GenericModelo> lstAllModelosVisibles;
	public static GenericModelo objectGeneric;
	
	private static BusquedaVehiculo getParametros() {
		
		String busqueda = view.GestionVehiculo.txtBusqueda.getText();
		return new BusquedaVehiculo(busqueda);
		
	}
	
	private static List<Vehiculo> getVehiculos() {
		BusquedaVehiculo bv=  getParametros();
		try {
			return VehiculoService.getAllVehiculos(bv);
		} catch (Exception e1) {
			return null;
		}
	}
	
	
	
	
	public static void pintarTableVehiculos() {
		logic.VehiculoLogic.pintarTableVehiculos(getVehiculos(),view.GestionVehiculo.table);
	}
	
	
	
	
	// FORMULARIO
	
	private static List<Marca> getAllMarcasVisibles() {
		
		return lstAllMarcasVisibles  = service.MarcaService.getAllMarcas(new BusquedaMarcas("", "1"));
	}
	
	private static List<Marca> getAllMarcasVisiblesByName(String name) {
		return service.MarcaService.getAllMarcas(new BusquedaMarcas(name, "1"));
	}
	
	private static List<GenericModelo> getModelosVisibles() {		
		return lstAllModelosVisibles = service.ModeloService.getAllModelos(new Modelo("", 1));
	}
	
	private static List<model.Color> getColor(){
		
		return lstColor = service.ColoresService.getColor(new ParametrosBusquedaColores(""));

	}

	private static void getModelosByMarca(String marca) {
		
		List<Marca> lstMarcas = getAllMarcasVisiblesByName(marca);
		
		List<GenericModelo> lstModelo = getModelosVisibles();
		
		view.FormVehiculosCatalogo.comboBoxModelo.removeAllItems();
		for (Marca m : lstMarcas) {
			
			for (GenericModelo genericModelo : lstModelo) {
				
				if(m.getId_marca() == genericModelo.getMarca().getId_marca()) {
					view.FormVehiculosCatalogo.comboBoxModelo.addItem(genericModelo.getNombre_modelo());
					//System.out.println(genericModelo.getNombre_modelo() + " " + genericModelo.getId_modelo());
				}
				
			}
		}
	}
	
	public static void changeColor() {
		
		String nombre_color = String.valueOf(view.FormVehiculosCatalogo.comboBoxColor.getSelectedItem());
		
		for (Color color : lstColor) {
			if(color.getNombre_color().equals(nombre_color)) {
				logic.VehiculoLogic.setColorLabel(color.getRdbcolor());
			}
		}
		
	
	}
	
	public static void changeModelo() {
		
		
		String nombre_marca = String.valueOf(view.FormVehiculosCatalogo.comboBoxMarca.getSelectedItem());
		getModelosByMarca(nombre_marca);
		
	}
	
	
	
	public static void setValores(String status) {
		List<Marca> lstMarcas = getAllMarcasVisibles();
		List<model.Color> lstColor = getColor();
		
		// ComboBox Marca
		for (Marca marca : lstMarcas) {
			view.FormVehiculosCatalogo.comboBoxMarca.addItem(marca.getNombre_marca());
		}
		
		// ComboBox Modelo
		if(lstMarcas.size() >0) {
			getModelosByMarca(lstMarcas.get(0).getNombre_marca());
		}
		
		// ComboBox Color
		for (Color color : lstColor) {
			view.FormVehiculosCatalogo.comboBoxColor.addItem(color.getNombre_color());
		}
	
		switch (status) {
		case "A�adir":
				
				view.FormVehiculosCatalogo.txtMatricula.setText("0");
			
			break;
		case "Editar":
			
				enabledFields();
				logic.VehiculoLogic.getDataRow();
			break;
		case "Borrar":
			
				enabledFields();
				logic.VehiculoLogic.getDataRow();
			break;

		default:
			break;
		}
	
	}
	
	
	private static void enabledFields() {
		view.FormVehiculosCatalogo.comboBoxColor.setEnabled(false);
		view.FormVehiculosCatalogo.comboBoxMarca.setEnabled(false);
		view.FormVehiculosCatalogo.comboBoxModelo.setEnabled(false);
		view.FormVehiculosCatalogo.txtMatricula.setEnabled(false);
	}

	public static void changeBtn() {
		
		if(logic.VehiculoLogic.tableSelectedRow()) {
			view.GestionVehiculo.btnBorrar.setEnabled(true);
			view.GestionVehiculo.btnEditar.setEnabled(true);
			
			
		}else {
			view.GestionVehiculo.btnBorrar.setEnabled(false);
			view.GestionVehiculo.btnEditar.setEnabled(false);
		}
		
	}

	

	
	

}