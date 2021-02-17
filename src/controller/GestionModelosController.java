package controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import javax.swing.text.MaskFormatter;

import model.BusquedaMarcas;
import model.GenericModelo;
import model.Marca;
import model.Modelo;
import model.ModeloAPI;
import service.MarcaService;
import service.ModeloService;

public class GestionModelosController {

	
	
	public static void getComboboxVisible(){
		
		view.GestionModelos.comboBoxVisible.addItem("Todos");
		view.GestionModelos.comboBoxVisible.addItem("Visible");
		view.GestionModelos.comboBoxVisible.addItem("No Visible");
	}
	
	private static List<String> getCamposBusqueda() {
		
		List<String> lstParametros = new ArrayList<String>(); 
	
		String busqueda = view.GestionModelos.textFieldMarcaorModelo.getText();
		String estado = String.valueOf(view.GestionModelos.comboBoxVisible.getSelectedItem());
		
		
		lstParametros.add(busqueda);
		lstParametros.add(estado);
		
		return lstParametros;
	}
	
	
	private static List<GenericModelo> getAllModelos() {
		
		
		List<String> parametros = getCamposBusqueda();
		
		String busqueda = parametros.get(0);
		String visible = logic.ModeloLogic.getCodigoComboBoxVisible(parametros.get(1));
		
		Modelo m = new Modelo("",-1);
		return ModeloService.getAllModelos(m);
		
	}
	
	
	public static void pintarTableModelo() {
		
		List<GenericModelo> lstModelos = getAllModelos();
		logic.ModeloLogic.pintarTableMarca(lstModelos, view.GestionModelos.table);
		
	}
	
	
	
	public static Modelo getSelectedRow() {
		 return logic.ModeloLogic.getSelectedRow(view.GestionModelos.table);
	}
	
	public static void btnEditarEnabled() {
		
		if(view.GestionModelos.table.getSelectedRow() == -1) {
			view.GestionModelos.btnEditar.setEnabled(false);

		}else {
			view.GestionModelos.btnEditar.setEnabled(true);
		}
		
		
	}
	
	// FORM MODELO
	public static void setMarcaFormModelos() {
		
		
		// Las marcas registrdas en mi base de datos
		List<Marca> marca =  MarcaService.getAllMarcas(new BusquedaMarcas("", "-1"));
		List<Marca> marcasVisibles = new ArrayList<Marca>();
		
		// Listado de Marca visibles
		for (Marca m : marca) {
			if(m.getVisible() == 1) {
				marcasVisibles.add(m);
				view.FormModelo.id_marca.put(m.getNombre_marca(), m.getId_marca());
				view.FormModelo.comboBoxMarca.addItem(m.getNombre_marca());
			}
		}
		
	
	}
	
	public static void setModeloFormModelos() {
		
		String marca = String.valueOf(view.FormModelo.comboBoxMarca.getSelectedItem());
		emptyModelo();
		
			// Modelos de la Primera
			List<ModeloAPI> modelo = ModeloService.getModelosByMarca(marca);
			
			for (ModeloAPI mAPI : modelo) {
				
				view.FormModelo.comboBoxModelo.addItem(mAPI.getModel_Name());
				view.FormModelo.id_modelo.put(mAPI.getModel_Name(), mAPI.getModel_ID());
				
			}
	

	}
	
	public static void onCargando() {
		view.FormModelo.okButton.setEnabled(false);
		logic.ModeloLogic.onCargando();
	}
	public static void offCargando() {
		
		view.FormModelo.okButton.setEnabled(true);
		logic.ModeloLogic.offCargando();
	}
	private static void emptyModelo(){
		view.FormModelo.comboBoxModelo.removeAllItems();
		view.FormModelo.id_modelo.clear();
	}
	
	
	private static Modelo getCamposFormModelo() {
		
		int id_marca = view.FormModelo.id_marca.get(view.FormModelo.comboBoxMarca.getSelectedItem());
		int id_modelo = view.FormModelo.id_modelo.get(view.FormModelo.comboBoxModelo.getSelectedItem());
		String nombre_modelo = String.valueOf(view.FormModelo.comboBoxModelo.getSelectedItem());
		int potencia = Integer.parseInt(view.FormModelo.formattedTextFieldPotencia.getText().trim());
		int visible = logic.ModeloLogic.booleanToInt(view.FormModelo.tgVisible.isSelected());
		float precio = Float.parseFloat(view.FormModelo.ftxtPrecio.getText());
		
		return  new Modelo(id_modelo,nombre_modelo,id_marca,potencia,visible,precio);

	}
	
	public static boolean addModelo() {
		
		Modelo m = getCamposFormModelo();
		String response = null;
		
		try {
			response = ModeloService.newModelo(m);
				if(response.equals("OK")) {
					logic.ModeloLogic.mensajeExito("Modelo creado con éxito");
					pintarTableModelo();
					return true;
				}else {
					logic.ModeloLogic.mensajeError(response);
					return false;
				}
		} catch (Exception e) {

			logic.ModeloLogic.mensajeError("Error al crear el modelo del coche");
			return false;
		}
		
	}
	
	
	public static void statusMode(String status,Modelo modelo) {
		
		if(status.equalsIgnoreCase("Editar")) {
			
			view.FormModelo.comboBoxMarca.setEnabled(false);
			view.FormModelo.comboBoxModelo.setEnabled(false);
			controller.GestionModelosController.setMarcaFormModelos();
			
			List keys = new ArrayList(view.FormModelo.id_marca.keySet());
			List value = new ArrayList(view.FormModelo.id_marca.values());
			
			
			for (int i = 0; i < keys.size(); i++) {

			    if(value.get(i).equals(modelo.getId_marca())) {
			    	view.FormModelo.comboBoxMarca.setSelectedItem(keys.get(i));
			    }
			    
			}
			
			view.FormModelo.comboBoxMarca.setSelectedItem("");
			view.FormModelo.comboBoxModelo.setSelectedItem(modelo.getNombre_modelo());	
			view.FormModelo.formattedTextFieldPotencia.setText(String.valueOf(modelo.getPotencia()));
			view.FormModelo.tgVisible.setSelected(logic.ModeloLogic.IntToBoolean(modelo.getVisible()));
			view.FormModelo.ftxtPrecio.setText(String.valueOf(modelo.getPrecio()));
			
		}else {
			
			controller.GestionModelosController.setMarcaFormModelos();
			view.FormModelo.comboBoxMarca.setEnabled(true);
			view.FormModelo.comboBoxModelo.setEnabled(true);
			view.FormModelo.formattedTextFieldPotencia.setText("0");
			view.FormModelo.tgVisible.setSelected(false);;


		}
		
		
		
		
	}


	public static boolean editModelo() {
		
		Modelo m = getCamposFormModelo();
		String response;
		
		try {
			response = ModeloService.updateModelo(m);
				if(response.equals("OK")) {
					logic.ModeloLogic.mensajeExito("Modelo actualizado con éxito");
					pintarTableModelo();
					return true;
				}else {
					logic.ModeloLogic.mensajeError(response);
					return false;
				}
		} catch (Exception e) {

			logic.ModeloLogic.mensajeError("Error al actualizar el modelo del coche");
			return false;
		}
		
	}







	

	
}
