package controller;

import java.awt.Color;
import java.util.List;

import javax.swing.JOptionPane;

import model.ParametrosBusquedaColores;
import model.ParametrosNuevoColor;
import service.ColoresService;
import view.FormGestionColor;

public class GestionColorController {

	public static void setComboBoxColor() {
		
		List<model.Color> lstColores = listColores();
		view.GestionColor.comboBoxColores.addItem("Todos");
	
		for (model.Color color : lstColores) {
			view.GestionColor.comboBoxColores.addItem(color.getNombre_color());
		}
	
	}
	
	public static List<model.Color> listColores(){
		
		ParametrosBusquedaColores p;
		if(view.GestionColor.comboBoxColores.getSelectedItem() == null){
			 p = new ParametrosBusquedaColores("");
		}else{
			 p = new ParametrosBusquedaColores(getCampo());
		};
	
		
		return ColoresService.getColor(p);
	}
	

	
	public static String getCampo() {
		
		if(view.GestionColor.comboBoxColores.getSelectedItem().equals("Todos")) {
			return "";
		}else {
			return String.valueOf(view.GestionColor.comboBoxColores.getSelectedItem());
		}
	}
	
	
	public static void pintarTablaLogic() {
		
		logic.ColorLogic.pintarTablaColores(listColores(),view.GestionColor.table);
	}
	

	
	public static String guardarColor() {
		
		String rgbcolor = getColorRGBForm();
		
		// Guardamos El Color
		ParametrosNuevoColor p = new ParametrosNuevoColor(rgbcolor);
		String response = ColoresService.nuevoColor(p);
		
		if(response.equals("OK")) {
			
			view.GestionColor.comboBoxColores.removeAllItems();
			setComboBoxColor();
			logic.ColorLogic.pintarTablaColores(listColores(), view.GestionColor.table);
			
			mensajeExito("Color creado correctamente");
			
			
		}else {
			
			mensajeError(response);
		}
		
		return response;
	}

	private static  String getColorRGBForm() {
		
		int red = view.FormGestionColor.tcc.getColor().getRed();
		int blue = view.FormGestionColor.tcc.getColor().getBlue();
		int green = view.FormGestionColor.tcc.getColor().getGreen();
		String rgbcolor = "rgb("+red+","+green+","+blue+")";
		return rgbcolor;
	}

	private static void mensajeExito(String mensaje) {
		
		view.GestionColor.lblError.setText(mensaje);
		view.GestionColor.lblError.setForeground(Color.BLUE);
		
		view.FormGestionColor.lblError.setText(mensaje);
		view.FormGestionColor.lblError.setForeground(Color.BLUE);
		
	}

	private static void mensajeError(String mensaje) {
		
		view.GestionColor.lblError.setText(mensaje);
		view.GestionColor.lblError.setForeground(Color.RED);
		
		view.FormGestionColor.lblError.setText(mensaje);
		view.FormGestionColor.lblError.setForeground(Color.RED);
		
		JOptionPane.showMessageDialog(null, mensaje);
		
	}
	


}
