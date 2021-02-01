package logic;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONObject;

import controller.GestionMarcasController.MarcasAPI;
import model.Marca;;

public class MarcaLogic {

	public static List<Marca> JsonToMarcas(String response) {
		List<Marca> lstResultado = new ArrayList<>();
		
		JSONArray jsonA = new JSONArray(response);
		for (int i = 0; i < jsonA.length(); i++) {
			
			JSONObject jsonO = jsonA.getJSONObject(i);
			Marca u = JsonToUsMarca(jsonO);
					
					lstResultado.add(u);
				
		}
	
		return lstResultado;
	}
	
	private static Marca JsonToUsMarca(JSONObject jsonO) {
		
		   	Integer id_marca = jsonO.getInt("id_marca");
		    String nombre_marca = jsonO.getString("nombre_marca");
		    Integer visible = jsonO.getInt("visible");
		    
		     Marca u = new Marca(id_marca, nombre_marca, visible);
		     return u;
		     
	}
	
	
	
	public static List<MarcasAPI> JsonToMarcasAPI(String response) {
		List<MarcasAPI> lstResultado = new ArrayList<>();
		
		JSONArray jsonA = new JSONArray(response);
		for (int i = 0; i < jsonA.length(); i++) {
			
			JSONObject jsonO = jsonA.getJSONObject(i);
			MarcasAPI u = JsonToUsMarcaAPI(jsonO);
					
					lstResultado.add(u);
				
		}
	
		return lstResultado;
	}
	
	private static MarcasAPI JsonToUsMarcaAPI(JSONObject jsonO) {
		
		   	Integer Make_ID = jsonO.getInt("Make_ID");
		    String Make_Name = jsonO.getString("Make_Name");
		
		    
		     controller.GestionMarcasController.MarcasAPI u = new MarcasAPI(Make_ID, Make_Name);
		   
		     return u;
		     
	}
	
	
	public static void pintarTableMarca(List<Marca> list, JTable table) {
		
		
		
		
		DefaultTableModel tableModel = new DefaultTableModel();
		
		// COLUMNAS
		
		String[] columnNames = {"id_marca","Marca","visible"};
		
		JLabel l = new JLabel();
		for(int i=0; i < columnNames.length;i++) {
			tableModel.addColumn(columnNames[i]);
		}
		
		// FILAS 
		
		tableModel.setColumnIdentifiers(columnNames);
		Object[] fila = new Object[tableModel.getColumnCount()];
		
		for (int i = 0; i < list.size(); i++) {
			
		fila[0] = list.get(i).getId_marca();
		fila[1] = list.get(i).getNombre_marca();
		fila[2] = logic.LogicApp.IntegertoBoolean(list.get(i).getVisible());
		tableModel.addRow(fila);
			
		}

	
		table.setModel(tableModel);
			
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);

		
		
		table.getTableHeader().setReorderingAllowed(false) ;
		table.getTableHeader().setResizingAllowed(false);
		
	}
	
	
	
	
}
