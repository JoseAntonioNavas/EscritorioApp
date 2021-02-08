package logic;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONObject;

import model.GenericModelo;
import model.Marca;
import model.Modelo;
import model.Vehiculo;

public class VehiculoLogic {

	public static List<Vehiculo> JsonToDetallesUsuariosObject(String response) {
		
		List<Vehiculo> listObject = new ArrayList<>();
		
	
		JSONArray jsonA = new JSONArray(response);
		for (int i = 0; i < jsonA.length(); i++) {
			
			JSONObject jsonO = jsonA.getJSONObject(i);
			Vehiculo dU = JsonToVehiculo(jsonO);
			listObject.add(dU);
				
		}
	
		return listObject;
	}

	public static Vehiculo JsonToVehiculo(JSONObject jsonO) {
		
			Integer id_vehiculo = jsonO.getInt("id_vehiculo");
			
			Integer id_marca = jsonO.getJSONObject("marca").getInt("id_marca");
			String nombre_marca = jsonO.getJSONObject("marca").getString("nombre_marca");
			
			Integer id_modelo = jsonO.getJSONObject("modelo").getInt("id_modelo");
			String nombre_modelo = jsonO.getJSONObject("modelo").getString("nombre_modelo");
			Integer potencia = jsonO.getJSONObject("modelo").getInt("potencia");
			float precio = jsonO.getJSONObject("modelo").getFloat("precio");
			
			String matricula = jsonO.getString("matricula");
			
			Integer id_color = jsonO.getJSONObject("color").getInt("id_color");
			String nombre_color = jsonO.getJSONObject("color").getString("nombre_color");
			String rgbcolor = jsonO.getJSONObject("color").getString("nombre_color");

		   
			Marca m = new Marca(id_marca, nombre_marca);
			Modelo mo = new Modelo(id_modelo, nombre_modelo, id_marca, potencia, precio);
			model.Color co = new model.Color(id_color,nombre_color,rgbcolor);
			
			
			return  new Vehiculo(id_vehiculo, m, mo, matricula, co);
		
	     
	}

	public static void pintarTableVehiculos(List<Vehiculo> list, JTable table) {

		DefaultTableModel tableModel = new DefaultTableModel();
		
		// COLUMNAS
		
		String[] columnNames = {"id_vehiculo",
				"id_marca","Marca",
				"id_modelo","Modelo",
				"Potencia","Precio",
				"Matricula","id_color","Color",
				};
		
		JLabel l = new JLabel();
		for(int i=0; i < columnNames.length;i++) {
			tableModel.addColumn(columnNames[i]);
		}
		
		// FILAS 
		
		tableModel.setColumnIdentifiers(columnNames);
		Object[] fila = new Object[tableModel.getColumnCount()];
		for (int i = 0; i < list.size(); i++) {
			
		fila[0] = list.get(i).getId_vehiculo();
		fila[1] = list.get(i).getMarca().getId_marca();
		fila[2] = list.get(i).getMarca().getNombre_marca();
		fila[3] = list.get(i).getModelo().getId_modelo();
		fila[4] = list.get(i).getModelo().getNombre_modelo();
		fila[5] = list.get(i).getModelo().getPotencia();
		fila[6] = list.get(i).getModelo().getPrecio() + " €";
		fila[7] = list.get(i).getMatricula();
		fila[8] = list.get(i).getColor().getId_color();
		fila[9] = list.get(i).getColor().getNombre_color();
		
		
		tableModel.addRow(fila);
			
		}

	
		table.setModel(tableModel);
			
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		
		table.getColumnModel().getColumn(1).setMaxWidth(0);
		table.getColumnModel().getColumn(1).setMinWidth(0);
		table.getColumnModel().getColumn(1).setPreferredWidth(0);
		
		table.getColumnModel().getColumn(3).setMaxWidth(0);
		table.getColumnModel().getColumn(3).setMinWidth(0);
		table.getColumnModel().getColumn(3).setPreferredWidth(0);

		table.getColumnModel().getColumn(8).setMaxWidth(0);
		table.getColumnModel().getColumn(8).setMinWidth(0);
		table.getColumnModel().getColumn(8).setPreferredWidth(0);
		
		
		table.getTableHeader().setReorderingAllowed(false) ;
		table.getTableHeader().setResizingAllowed(false);
		
	
	}
	
	
	public static void setColorLabel(String color) {
		
		
		String[] colour = color.substring(4,color.length()-1).split(",");
		Color c = new Color(Integer.parseInt(colour[0]),Integer.parseInt(colour[1]),Integer.parseInt(colour[2]));
		
		view.FormVehiculosCatalogo.lblColorMuestra.setBackground(c);
		view.FormVehiculosCatalogo.lblColorMuestra.setOpaque(true);
		 
		 
	}
	
	
	public static boolean tableSelectedRow() {
		
		if(view.GestionVehiculo.table.getSelectedRow() == -1){
			return false;
		}else {
			return true;
		}
		
	}
	
	
	public static void getDataRow() {
		
		List<String> response = new ArrayList<String>();
		int pos = view.GestionVehiculo.table.getSelectedRow();
		
		for (int i=0; i< view.GestionVehiculo.table.getColumnCount(); i++) {
			
			response.add(String.valueOf(view.GestionVehiculo.table.getValueAt(pos, i)));
			
		}
		
		view.FormVehiculosCatalogo.lblIdVehiculo.setText(response.get(0));
		view.FormVehiculosCatalogo.comboBoxMarca.setSelectedItem(response.get(2));
		view.FormVehiculosCatalogo.comboBoxModelo.setSelectedItem(response.get(4));
		view.FormVehiculosCatalogo.txtMatricula.setText(response.get(7));
		view.FormVehiculosCatalogo.comboBoxColor.setSelectedItem(response.get(9));
		
		view.FormVehiculosCatalogo.lblcargando.setText("");
		view.FormVehiculosCatalogo.okButton.setEnabled(true);
		
		
	}

	public static Vehiculo getVehiculoForm() {
		
		
		int id_marca = 0;
		int id_modelo = 0;
		int id_color = 0;
		
		String id_vehiculo = String.valueOf(view.FormVehiculosCatalogo.lblIdVehiculo.getText());
		//String nombre_marca = String.valueOf(view.FormVehiculosCatalogo.comboBoxMarca.getSelectedItem());
		String nombre_modelo = String.valueOf(view.FormVehiculosCatalogo.comboBoxModelo.getSelectedItem());
		String nombre_color = String.valueOf(view.FormVehiculosCatalogo.comboBoxColor.getSelectedItem());
		String matricula = view.FormVehiculosCatalogo.txtMatricula.getText();
		
		List<GenericModelo> lstModelo = controller.GestionVehiculoController.lstAllModelosVisibles;
		for (GenericModelo g : lstModelo) {
			if(g.getNombre_modelo().equals(nombre_modelo)) {
				id_modelo = g.getId_modelo();
				id_marca = g.getMarca().getId_marca();
			}
		}		
		
		List<model.Color> lstColour = controller.GestionVehiculoController.lstColor;
		for (model.Color c : lstColour) {
			if(c.getNombre_color().equals(nombre_color)) {
				id_color = c.getId_color();
			}
		}
		
		
		if(id_vehiculo.equals("")) {
			return new Vehiculo(-1, new Marca(id_marca), new Modelo(id_modelo), matricula, new model.Color(id_color));			

		}else {
			return new Vehiculo(Integer.parseInt(id_vehiculo), new Marca(id_marca), new Modelo(id_modelo), matricula, new model.Color(id_color));			

		}
		
	}
	
}
