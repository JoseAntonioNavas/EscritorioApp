package logic;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONObject;
import model.GenericModelo;
import model.Marca;
import model.ModeloAPI;
import view.GestionModelos;


public class ModeloLogic {

	public static List<GenericModelo> JsonToGenericModelos(String response) {
		
		List<GenericModelo> listObject = new ArrayList<>();
		
	
		JSONArray jsonA = new JSONArray(response);
		
		for (int i = 0; i < jsonA.length(); i++) {
			
			JSONObject jsonO = jsonA.getJSONObject(i);
			GenericModelo dU = JsonToGenericModelo(jsonO);
			listObject.add(dU);
				
		}
	
		return listObject;
	}

	private static GenericModelo JsonToGenericModelo(JSONObject jsonO) {
				
			
		   	Integer id_modelo = jsonO.getInt("id_modelo");
		    String nombre_modelo = jsonO.getString("nombre_modelo");
		    Integer id_marca = jsonO.getJSONObject("marca").getInt("id_marca");
		    String nombre_marca = jsonO.getJSONObject("marca").getString("nombre_marca");
		    Integer potencia = jsonO.getInt("potencia");
		    Integer visible = jsonO.getInt("visible");
		    
		    GenericModelo g = new GenericModelo(id_modelo, nombre_modelo, new Marca(id_marca, nombre_marca), potencia, visible);
		    return g;
		    
	}
	
	
	public static List<ModeloAPI> JsonToModeloAPIs(String response) {
		
		List<ModeloAPI> listObject = new ArrayList<>();
		
	
		JSONArray jsonA = new JSONArray(response);
		
		for (int i = 0; i < jsonA.length(); i++) {
			
			JSONObject jsonO = jsonA.getJSONObject(i);
			ModeloAPI dU = JsonToModeloAPI(jsonO);
			listObject.add(dU);
				
		}
	
		return listObject;
	}

	private static ModeloAPI JsonToModeloAPI(JSONObject jsonO) {
				
			
		   	Integer id_marca = jsonO.getInt("Make_ID");
		    String nombre_marca = jsonO.getString("Make_Name");
		    Integer id_modelo = jsonO.getInt("Model_ID");
		    String nombre_modelo = jsonO.getString("Model_Name");
		    
		    return new ModeloAPI(id_marca, nombre_marca, id_modelo, nombre_modelo);
		    
		   
	}
	
	public static void pintarTableMarca(List<model.GenericModelo> list, JTable table) {
		
		
		DefaultTableModel tableModel = new DefaultTableModel();
		
		// COLUMNAS
		
		String[] columnNames = {"id_modelo","Modelo","id_marca","Marca","Potencia","Estado"};
		
		JLabel l = new JLabel();
		for(int i=0; i < columnNames.length;i++) {
			tableModel.addColumn(columnNames[i]);
		}
		
		// FILAS 
		
		tableModel.setColumnIdentifiers(columnNames);
		Object[] fila = new Object[tableModel.getColumnCount()];
		
		for (int i = 0; i < list.size(); i++) {
			
		fila[0] = list.get(i).getId_modelo();
		fila[1] = list.get(i).getNombre_modelo();
		fila[2] = list.get(i).getMarca().getId_marca();
		fila[3] = list.get(i).getMarca().getNombre_marca();
		fila[4] = list.get(i).getPotencia();
		fila[5] = IntegertoBooleanToString(list.get(i).getVisible());
		tableModel.addRow(fila);
			
		}

	
		table.setModel(tableModel);
			
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);

		table.getColumnModel().getColumn(2).setMaxWidth(0);
		table.getColumnModel().getColumn(2).setMinWidth(0);
		table.getColumnModel().getColumn(2).setPreferredWidth(0);

		
		table.getTableHeader().setReorderingAllowed(false) ;
		table.getTableHeader().setResizingAllowed(false);
		
	}
	
	private static String IntegertoBooleanToString(int e) {
		
		if(e == 0) {
			return "No visible";
		}else {
			return "Visible";
		}
	}
	
	public static String getCodigoComboBoxVisible(String valueItem) {
		
		String codItem = "-1";
		
		switch (valueItem) {
		case "Todos":
			codItem = "-1";
			break;
		case "Visible":
			codItem = "1";
			break;
		case "No Visible":
			codItem = "0";
			break;

		default:
			break;
		}
		
		
		return codItem;
	}
	
}
