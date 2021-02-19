package logic;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONObject;


public class ColorLogic {
	
	
	public static List<model.Color> JsonToColors(String response) {
		
		List<model.Color> listRoles = new ArrayList<>();
		
		JSONArray jsonA = new JSONArray(response);
		for (int i = 0; i < jsonA.length(); i++) {
			
			JSONObject jsonO = jsonA.getJSONObject(i);
			model.Color r = JsonToColor(jsonO);
					
			listRoles.add(r);
				
		}
	
		return listRoles;
	}
	
	public static model.Color JsonToColor(JSONObject jsonO) {
		
		 	Integer id_color = jsonO.getInt("id_color");
		    String nombre_color = jsonO.getString("nombre_color");
		    String rgbcolor = jsonO.getString("rgbcolor");
		    
		    model.Color r = new model.Color(id_color,nombre_color,rgbcolor);
		    return r;
		     
	}

	public static void pintarTablaColores(List<model.Color> list, JTable table) {
		
		
		DefaultTableModel tableModel = new DefaultTableModel();
				
		// COLUMNAS
		
		String[] columnNames = {"id_color","Nombre","RGB Color","Color"};
		
		JLabel l = new JLabel();
		for(int i=0; i < columnNames.length;i++) {
			tableModel.addColumn(columnNames[i]);
		}
		
		// FILAS 
		
		tableModel.setColumnIdentifiers(columnNames);
		Object[] fila = new Object[tableModel.getColumnCount()];
		
		for (int i = 0; i < list.size(); i++) {
			
		fila[0] = list.get(i).getId_color();
		fila[1] = list.get(i).getNombre_color();
		fila[2] = list.get(i).getRdbcolor();
		fila[3] = "";
		tableModel.addRow(fila);
			
		}

	
		table.setModel(tableModel);
			
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);

		
		table.getColumnModel().getColumn(3).setMaxWidth(50);
		table.getColumnModel().getColumn(3).setMinWidth(0);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setCellRenderer(new Renderer(list));
		
		table.getTableHeader().setReorderingAllowed(false) ;
		table.getTableHeader().setResizingAllowed(false);
		
		
	}

	 private static class Renderer extends DefaultTableCellRenderer {
		
		private static final long serialVersionUID = 1L;
		JLabel lbl = new JLabel();
		List<model.Color> clistColor = new ArrayList<model.Color>();
		
		  public Renderer(List<model.Color> list) {
			  this.clistColor = list;
		}

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
			   boolean hasFocus, int row, int column) {
			
			String color = this.clistColor.get(row).getRdbcolor();

			String[] colour = color.substring(4,color.length()-1).split(",");
			Color c = new Color(Integer.parseInt(colour[0]),Integer.parseInt(colour[1]),Integer.parseInt(colour[2]));
			 lbl.setBackground(c);
			 lbl.setOpaque(true);
			 return lbl;
			 }
		 }
	 
	
}


