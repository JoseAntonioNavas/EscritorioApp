package controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import model.Usuario;
import service.UsuarioService;
import view.GestionUsuario;

public class GestionUsuarioController {
	

	public static void btnBorrarEnabled() {
		
		if(view.GestionUsuario.table.getSelectedRow() == -1) {
			view.GestionUsuario.btBorrar.setEnabled(false);

		}else {
			view.GestionUsuario.btBorrar.setEnabled(true);
		}
		
		
	}
	
	
	private static void vaciarCamposBusqueda() {

		 view.GestionUsuario.txtEmail.setText("");
		 view.GestionUsuario.txtPassword.setText("");
	}
	
	private static Usuario getCamposBusqueda() {
		
		String email  = view.GestionUsuario.txtEmail.getText();
		String passwd = view.GestionUsuario.txtPassword.getText();
		
		Usuario usuario = new Usuario(email, passwd);
		
		return usuario;
		
	}
	
	private static List<Usuario> getUsuarios() {
		
		Usuario usuario = getCamposBusqueda();
		
		List<Usuario> listUsuario = UsuarioService.getUsuarios(usuario);
		return listUsuario;
	}
	
	public static void pintarTableUsuario() {
		
		List<Usuario> lstUsuarios = getUsuarios();

		
		DefaultTableModel tableModel = new DefaultTableModel();
		
		
		// COLUMNAS
		
		String[] columnNames = {"id__user","Email","Contraseña"};
		for(int i=0; i < columnNames.length;i++) {
			tableModel.addColumn(columnNames[i]);
		}
		
		// FILAS 
		
		tableModel.setColumnIdentifiers(columnNames);
		Object[] fila = new Object[tableModel.getColumnCount()];
		
		for (int i = 0; i < lstUsuarios.size(); i++) {

		fila[0] = lstUsuarios.get(i).getId_user();
		fila[1] = lstUsuarios.get(i).getEmail();
		fila[2] = lstUsuarios.get(i).getPasswd();
		
		tableModel.addRow(fila);
			
		
		}

	
		view.GestionUsuario.table.setModel(tableModel);
			
		view.GestionUsuario.table.getColumnModel().getColumn(0).setMaxWidth(0);
		view.GestionUsuario.table.getColumnModel().getColumn(0).setMinWidth(0);
		view.GestionUsuario.table.getColumnModel().getColumn(0).setPreferredWidth(0);
		
		view.GestionUsuario.table.getTableHeader().setReorderingAllowed(false) ;
		view.GestionUsuario.table.getTableHeader().setResizingAllowed(false);
		
			
		/**view.GestionUsuario.table.changeSelection(0, 0, false, false);
		view.GestionUsuario.table.requestFocus ();
		**/
	
	}

	
	public static void mensajeError(String respuesta,String msgSuccess) {
		
		if(respuesta.equals("OK")) {
			view.GestionUsuario.lblError.setText(msgSuccess);
			view.GestionUsuario.lblError.setForeground(Color.BLUE);
			System.out.println("ola");
			vaciarCamposBusqueda();
			pintarTableUsuario();
		}else{
			view.GestionUsuario.lblError.setText(respuesta);
			view.GestionUsuario.lblError.setForeground(Color.RED);
		};
	}
	
	public static void insertarUsuario() {
		
		getCamposBusqueda();
		Usuario usuario = getCamposBusqueda();
		String respuesta = UsuarioService.insertarUsuario(usuario);
		
		mensajeError(respuesta,"Usuario Registrado Correctamente");

	}
	
	public static void borrarUsuario(String id) {
		String respuesta = UsuarioService.deleteUsuario(id);
		mensajeError(respuesta,"Usuario Borrado Correctamente");
		btnBorrarEnabled(); 
	}
	
	
	public static void modalBorrar() {
		String id =  view.GestionUsuario.table.getValueAt(view.GestionUsuario.table.getSelectedRow(), 0).toString();
		String email = (String) view.GestionUsuario.table.getValueAt(view.GestionUsuario.table.getSelectedRow(), 1);
		
		int seleccion = JOptionPane.showOptionDialog(
				   null,
				   "¿Estás Seguro de borrar el usuario: + "+ email + "? \n Recuerda que se borraran todos los datos asociados a ese email", 
				   "Selector de opciones",
				   JOptionPane.YES_NO_CANCEL_OPTION,
				   JOptionPane.WARNING_MESSAGE,
				   null,    // null para icono por defecto.
				   new Object[] { "Aceptar", "Cancelar" },   // null para YES, NO y CANCEL
				   "Aceptar");

				if (seleccion != -1) {
					
					borrarUsuario(id);
					
				}
					 
				
	}
	
}
