package controller;

import java.util.List;

import javax.swing.JOptionPane;

import logic.ErrorLogic;
import model.BusquedaMarcas;
import model.BusquedaVehiculo;
import model.Color;
import model.GenericModelo;
import model.Marca;
import model.Modelo;
import model.ParametrosBusquedaColores;
import model.Vehiculo;
import model.editVehiculo;
import service.VehiculoService;

public class GestionVehiculoController {
	
	public static List<model.Color> lstColor;
	public static List<model.Marca> lstAllMarcasVisibles;
	public static List<model.GenericModelo> lstAllModelosVisibles;
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
		
		return lstAllMarcasVisibles = service.MarcaService.getAllMarcas(new BusquedaMarcas("", "1"));
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
		case "Añadir":
				
				view.FormVehiculosCatalogo.txtMatricula.setText("");
				view.FormVehiculosCatalogo.lblcargando.setText("");
				view.FormVehiculosCatalogo.okButton.setEnabled(true);
				view.FormVehiculosCatalogo.btnSubirImagen.setEnabled(true);
			
			break;
		case "Editar":
			
				enabledFieldsEditar();
				logic.VehiculoLogic.getDataRow();
				
			break;
		case "Borrar":
			
				enabledFieldsBorrar();
				logic.VehiculoLogic.getDataRow();
				
			break;

		default:
			break;
		}
	
	}
	
	
	private static void enabledFieldsBorrar() {
		view.FormVehiculosCatalogo.comboBoxColor.setEnabled(false);
		view.FormVehiculosCatalogo.comboBoxMarca.setEnabled(false);
		view.FormVehiculosCatalogo.comboBoxModelo.setEnabled(false);
		view.FormVehiculosCatalogo.txtMatricula.setEnabled(false);
		view.FormVehiculosCatalogo.lblLoadImg.setText("");
		view.FormVehiculosCatalogo.btnSubirImagen.setEnabled(false);

	}
	private static void enabledFieldsEditar() {
		
		view.FormVehiculosCatalogo.comboBoxMarca.setEnabled(false);
		view.FormVehiculosCatalogo.comboBoxModelo.setEnabled(false);
		view.FormVehiculosCatalogo.lblLoadImg.setText("");
		view.FormVehiculosCatalogo.btnSubirImagen.setEnabled(true);
	

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


	private static Vehiculo getFieldsFormVehiculo() {
		
		
		Vehiculo v = logic.VehiculoLogic.getVehiculoForm();
		
		return new Vehiculo(v.getMarca(),v.getModelo(),v.getMatricula(),v.getColor());
		
		
	}
	
	public static boolean btnOkFormVehiculo(String status) {
		
		switch (status) {
		case "Editar":
			String id_color_edit = "";
			String id_vehiculo_edit = view.FormVehiculosCatalogo.lblIdVehiculo.getText();
			String nombre_color = String.valueOf(view.FormVehiculosCatalogo.comboBoxColor.getSelectedItem());
			String matricula_edit = String.valueOf(view.FormVehiculosCatalogo.txtMatricula.getText());
			
			for (model.Color c : lstColor) {
				if(c.getNombre_color().equals(nombre_color)) {
					id_color_edit = String.valueOf(c.getId_color());
				}
			}
				
			String fileData = logic.imageLogic.updateImage();
			
			editVehiculo ev = new editVehiculo(Integer.parseInt(id_vehiculo_edit), Integer.parseInt(id_color_edit), matricula_edit,fileData);
			
			try {
				String response = service.VehiculoService.updateVehiculo(ev);
					if(response.equals("OK")) {
						
						pintarTableVehiculos();
						JOptionPane.showMessageDialog(null, "Vehículo editado correctamente" ,"EDITADO",JOptionPane.INFORMATION_MESSAGE);
						return true;
					}else {
						JOptionPane.showMessageDialog(null, response ,"ERROR",JOptionPane.ERROR_MESSAGE);
						return false;
					}
				
				
			} catch (Exception e2) {
				
				pintarTableVehiculos();
				JOptionPane.showMessageDialog(null, "Vehículo editado correctamente" ,"EDITADO",JOptionPane.INFORMATION_MESSAGE);
				return true;
			}
			
			
			
		
		case "Borrar":
			
			getFieldsFormVehiculo();
			
			int seleccion = JOptionPane.showOptionDialog(
					   null,
					   "¿Estás seguro de borrar este vehículo?", 
					   "Borrar Vehículo",
					   JOptionPane.YES_NO_CANCEL_OPTION,
					   JOptionPane.WARNING_MESSAGE,
					   null,    // null para icono por defecto.
					   new Object[] { "Aceptar", "Cancelar" },   // null para YES, NO y CANCEL
					   "Aceptar");
			
				if(seleccion == 0) {
					try {
						String response = VehiculoService.deleteVehiculo(view.FormVehiculosCatalogo.lblIdVehiculo.getText());
							if(response.equals("OK")) {
								
								pintarTableVehiculos();
								JOptionPane.showMessageDialog(null, "Vehículo Borrado correctamente" ,"BORRADO",JOptionPane.INFORMATION_MESSAGE);

								return true;
								
							}else {
								JOptionPane.showMessageDialog(null, response ,"ERROR",JOptionPane.ERROR_MESSAGE);
								return false;
							}
						
					} catch (Exception e1) {
						
						JOptionPane.showMessageDialog(null, "No se ha podido borrar el vehículo" ,"ERROR",JOptionPane.ERROR_MESSAGE);
						return false;
					}
				}
			
		
			
			
			
			
		case "Añadir":
			
			
			try {
				List<ErrorLogic> response = VehiculoService.newVehiculo(getFieldsFormVehiculo());
					if(response.get(0).getMsg().equalsIgnoreCase("OK")) {
						
						pintarTableVehiculos();
						String id_vehiculo = VehiculoService.getUltimoIDVehiculo();
						logic.imageLogic.upload(id_vehiculo);
						pintarTableVehiculos();
						
						return true;
					}else {
						JOptionPane.showMessageDialog(null, response.get(0).getMsg() ,"ERROR",JOptionPane.ERROR_MESSAGE);
						return false;
					}
				
				
			} catch (Exception e) {
				
				JOptionPane.showMessageDialog(null, "Error al realizar la consulta" ,"ERROR",JOptionPane.ERROR_MESSAGE);
				return false;
				
			}
			
			
			
		default:
			return false;
		}
		
		
		
		
	}

	
	

}
