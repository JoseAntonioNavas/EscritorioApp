package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JTable;

import model.DetallesUsuario;
import model.GenericUsuario;
import model.Roles;
import model.Usuario;
import service.RolesService;

public class GestionUsuarioLogic {

	
	public static GenericUsuario getGenericUsuarioSelectedRow(JTable table) {

		List<String> listaTablaRow = new ArrayList<String>();
		for (int i = 0; i < table.getColumnCount() ; i++) {
			
			listaTablaRow.add(String.valueOf(table.getValueAt(table.getSelectedRow(), i)));
			
		}
		
		String id_detalle_usuario = listaTablaRow.get(0);
		String nick = listaTablaRow.get(1);
		String nombre = listaTablaRow.get(2);
		String apellido1 = listaTablaRow.get(3);
		String apellido2 = listaTablaRow.get(4);
		String id_user = listaTablaRow.get(5);
		String email = listaTablaRow.get(6);
		String password = listaTablaRow.get(7);
		String id_rol = listaTablaRow.get(8);
		String rol = listaTablaRow.get(9);

		// Creamos el objeto
	
	
		GenericUsuario gu = new GenericUsuario(	 
				new DetallesUsuario(Integer.parseInt(id_detalle_usuario),Integer.parseInt(id_user),nick,Integer.parseInt(id_rol),nombre,apellido1,apellido2)
				, new Usuario(Integer.parseInt(id_user), email, password)
				, new Roles(Integer.parseInt(id_rol),rol)
		); 
		
		return gu;
	}
	
	public static boolean getSelectedRow(JTable table) {
		if(table.getSelectedRow() == -1){
			return false;
		}else {
			return true;
		}
	}

	
	public static List<String> getCamposFormUsuario() {
		String nombre = view.FormGestionUsuario.txtNombre.getText();
		String apellido1 = view.FormGestionUsuario.txtApellido1.getText();
		String apellido2 = view.FormGestionUsuario.txtApellido2.getText();
		String nick = view.FormGestionUsuario.txtNick.getText();
		String email = view.FormGestionUsuario.txtEmail.getText();
		String password = logic.LogicApp.descrifarPassword(view.FormGestionUsuario.passwordField);
		String id_rol = String.valueOf(view.FormGestionUsuario.contenedorRoles.get(view.FormGestionUsuario.comboBoxRoles.getSelectedItem()));
		
		 List<String> getCampos = new ArrayList<String>(Arrays.asList(nombre,apellido1,apellido2,nick,email,password,id_rol));
		 return getCampos;
	}

	public static void setRolesInComboBox() {
		
		List<Roles> r = RolesService.getRoles();
		for (Roles ro: r) {
			view.FormGestionUsuario.contenedorRoles.put(ro.getNombre_rol(),ro.getId_rol());
			view.FormGestionUsuario.comboBoxRoles.addItem(ro.getNombre_rol());
		}
		
	}
	
	
}
