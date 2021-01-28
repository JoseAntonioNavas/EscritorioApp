package controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import model.Usuario;
import service.UsuarioService;

public class GestionUsuarioController {
	

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
		
		
		for (int i = 0; i < lstUsuarios.size(); i++) {

			tableModel.isCellEditable(i, 2);
		
		}

		
		view.GestionUsuario.table.getColumnModel().getColumn(0).setMaxWidth(0);
		view.GestionUsuario.table.getColumnModel().getColumn(0).setMinWidth(0);
		view.GestionUsuario.table.getColumnModel().getColumn(0).setPreferredWidth(0);

		view.GestionUsuario.table.getTableHeader().setReorderingAllowed(false) ;
		view.GestionUsuario.table.getTableHeader().setResizingAllowed(false);
		
		
		
		

	}
	
}
