package controller;

import java.util.List;
import model.BusquedaMarcas;
import model.Marca;
import model.MarcasAPI;
import service.MarcaService;
import view.FormMarcas;
import view.GestionMarcas;

public class GestionMarcasController {

	
	public static void getComboboxVisible(){
		
		view.GestionMarcas.comboBoxVisible.addItem("Todos");
		view.GestionMarcas.comboBoxVisible.addItem("Visible");
		view.GestionMarcas.comboBoxVisible.addItem("No Visible");
	}
	

	
	private static BusquedaMarcas getCampos() {
		
		String nombreMarca = view.GestionMarcas.txtFieldMarca.getText();
		String visible = logic.MarcaLogic.getCodigoComboBoxVisible((String) view.GestionMarcas.comboBoxVisible.getSelectedItem());
		
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
	

	
	public static void abrirFormMarcas(String status) {
	
		if(status.equals("Añadir")) {
			
			new FormMarcas("Añadir").setVisible(true);
			
			
		}else{
			
			new FormMarcas("Editar").setVisible(true);
			
		}
		
	}
	
	
	
	public static List<MarcasAPI> getAllMarcasAPI() {
		return service.MarcaService.getAllMarcasAPI();
	}
	
	private static Marca getCamposFormMarcas() {
		
		int idMarca = view.FormMarcas.idMarca.get(view.FormMarcas.comboBoxMarcas.getSelectedItem());
		String nombre_marca = String.valueOf(view.FormMarcas.comboBoxMarcas.getSelectedItem());
		int visible =  logic.MarcaLogic.BooleantoInt(view.FormMarcas.chBoxVisible.isSelected());
		
		return new Marca(idMarca, nombre_marca, visible);
		
	}

	public static boolean formGuardarMarca() {
		
		Marca m = getCamposFormMarcas();
		try {
			
			String response = MarcaService.newMarca(m);
			if(response.equals("OK")) {
				logic.MarcaLogic.mensajeExito("Marca creada correctamente");
				pintarTableMarcas();
				
				return true;
			}else {
				logic.MarcaLogic.mensajeError(response);
				return false;
			}
			
			
		} catch (Exception e) {
			
			logic.MarcaLogic.mensajeError("Error al crear una Marca");
			return false;
		}
	}
	
	public static boolean formEditarMarca() {
		Marca m = getCamposFormMarcas();
	
		try {
			String response = MarcaService.updateMarca(m);
				if(response.equals("OK")) {
					logic.MarcaLogic.mensajeExito("Marca editada correctamente");
					pintarTableMarcas();
					return true;
				}else {
					logic.MarcaLogic.mensajeError(response);
					return false;
				}
		} catch (Exception e) {
			logic.MarcaLogic.mensajeError("Error al intentar editar marca");
			return false;
		}
		
		
	}
	
	public static Marca getSelectedRow() {
		 return logic.MarcaLogic.getSelectedRow(view.GestionMarcas.table);
	}
	
	public static void setValoresFormMarca(Marca marca) {
		
		if(marca.getVisible() == 0){
			view.FormMarcas.chBoxVisible.setSelected(false);
		}else {
			view.FormMarcas.chBoxVisible.setSelected(true);
		}
		
		view.FormMarcas.comboBoxMarcas.setSelectedItem(marca.getNombre_marca());
		
	}
	
	
	public static void comboBoxMarcasEnabled(String status) {
		
		if(status.equals("Añadir")) {
			view.FormMarcas.comboBoxMarcas.setEnabled(true);

		}else {
			view.FormMarcas.comboBoxMarcas.setEnabled(false);
		}
	}
	
	public static void btnBorrarEnabled() {
		
		if(view.GestionMarcas.table.getSelectedRow() == -1) {
			view.GestionMarcas.btnEditar.setEnabled(false);

		}else {
			view.GestionMarcas.btnEditar.setEnabled(true);
		}
		
		
	}
	

	
	






	





}
