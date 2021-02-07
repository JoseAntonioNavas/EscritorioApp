package logic;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONObject;

import model.DetallesUsuario;
import model.GenericUsuario;
import model.Marca;
import model.MarcasAPI;
import model.Roles;
import model.Usuario;;

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
	
	public static Marca JsonToUsMarca(JSONObject jsonO) {
		
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
		
		    
		     MarcasAPI u = new MarcasAPI(Make_ID, Make_Name);
		   
		     return u;
		     
	}
	
	
	public static void pintarTableMarca(List<Marca> list, JTable table) {
		
		
		
		
		DefaultTableModel tableModel = new DefaultTableModel();
		
		// COLUMNAS
		
		String[] columnNames = {"id_marca","Marca","Estado"};
		
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
		fila[2] = IntegertoBooleanToString(list.get(i).getVisible());
		tableModel.addRow(fila);
			
		}

	
		table.setModel(tableModel);
			
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);

		
		
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
	
	public static int BooleantoInt(boolean b) {
		
		if(b == true) {
			return 1;
		}else {
			return 0;
		}
		
	}
	
	private static int StringtoInt(String s) {
		if(s.equals("Visible")) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public static void mensajeExito(String string) {
		// TODO Auto-generated method stub
		view.FormMarcas.lblError.setText(string);
		view.FormMarcas.lblError.setForeground(Color.BLUE);
		
		view.GestionMarcas.lblError.setText(string);
		view.GestionMarcas.lblError.setForeground(Color.BLUE);

	}

	public static void mensajeError(String string) {

		view.FormMarcas.lblError.setText(string);
		view.FormMarcas.lblError.setForeground(Color.RED);
		
		view.GestionMarcas.lblError.setText(string);
		view.GestionMarcas.lblError.setForeground(Color.RED);
		
		JOptionPane.showMessageDialog(null, string);
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
	
	public static Marca getSelectedRow(JTable table) {

		List<String> listaTablaRow = new ArrayList<String>();
		for (int i = 0; i < table.getColumnCount() ; i++) {
			
			listaTablaRow.add(String.valueOf(table.getValueAt(table.getSelectedRow(), i)));
			
		}
		
		int id_marca = Integer.parseInt(listaTablaRow.get(0));
		String nombre_marca = listaTablaRow.get(1);
		int visible = StringtoInt(listaTablaRow.get(2));
		
		return new Marca(id_marca, nombre_marca, visible);
		
	}


	



	
	
	
}
