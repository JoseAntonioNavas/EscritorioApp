package controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import model.GenericUsuario;
import model.Roles;
import model.Usuario;
import service.DetallesUsuarioService;
import service.RolesService;
import service.UsuarioService;
import view.GestionUsuario;

public class GestionUsuarioController {
	
	private static void resetCamposBusqueda() {
		
		view.GestionUsuario.txtBusqueda.setText("");
		view.GestionUsuario.comboBoxRoles.setSelectedIndex(0);
	}
	
	public static void setRolesComboBox() {
		
		List<Roles> r = RolesService.getRoles();
	
		view.GestionUsuario.comboBoxRoles.addItem("Todos");
		view.GestionUsuario.contenedorRoles.put("Todos",-1);
		
		for (Roles ro: r) {
			
			view.GestionUsuario.contenedorRoles.put(ro.getNombre_rol(),ro.getId_rol());
			view.GestionUsuario.comboBoxRoles.addItem(ro.getNombre_rol());

		}
		
		
	}
	
	public static ParametrosBusquedaDetalleUsuarios getCamposBusqueda() {
		
		String txtBusqueda = view.GestionUsuario.txtBusqueda.getText();
		String id_rol = String.valueOf(view.GestionUsuario.contenedorRoles.get(view.GestionUsuario.comboBoxRoles.getSelectedItem()));

		ParametrosBusquedaDetalleUsuarios p = new ParametrosBusquedaDetalleUsuarios(txtBusqueda,id_rol);
		
		return p;
		
	}
	
	
	public static List<GenericUsuario> getDetallesUsuariosFiltrados() {
		
		List<GenericUsuario> listUsuarios = new ArrayList<GenericUsuario>();
		
	 	ParametrosBusquedaDetalleUsuarios p =  getCamposBusqueda();
	 	
		try {
			
			return listUsuarios = DetallesUsuarioService.getListDetalleUsuario(p);

		} catch (Exception e) {
			
			mensajeError("Error al realizar la Búsqueda");
			return listUsuarios;
		}
		
	}

	public static void btnBorrarEnabled() {
		
		if(view.GestionUsuario.table.getSelectedRow() == -1) {
			view.GestionUsuario.btBorrar.setEnabled(false);

		}else {
			view.GestionUsuario.btBorrar.setEnabled(true);
		}
		
		
	}
	
	public static boolean getSelectedRow(JTable table) {
		return logic.GestionUsuarioLogic.getSelectedRow(table);
	}
	
	public static GenericUsuario getDatosTableSelectedRow(JTable table) {
		
		return logic.GestionUsuarioLogic.getGenericUsuarioSelectedRow(table);
	}
	
	public static void pintarTableUsuario() {
		
		List<GenericUsuario> lstUsuarios = getDetallesUsuariosFiltrados();
	
		DefaultTableModel tableModel = new DefaultTableModel();
				
		// COLUMNAS
		
		String[] columnNames = {"id_detalle_usuario","Nick","Nombre","Primer Apellido", "Segundo Apellido", "id_user","Email","Contraseña","id_rol","Rol"};
		
		for(int i=0; i < columnNames.length;i++) {
			tableModel.addColumn(columnNames[i]);
		}
		
		// FILAS 
		
		tableModel.setColumnIdentifiers(columnNames);
		Object[] fila = new Object[tableModel.getColumnCount()];
		
		for (int i = 0; i < lstUsuarios.size(); i++) {
			
		fila[0] = lstUsuarios.get(i).getDetallesUsuario().getId_detalle_usuario();
		fila[1] = lstUsuarios.get(i).getDetallesUsuario().getNick_user();
		fila[2] = lstUsuarios.get(i).getDetallesUsuario().getNombre();
		fila[3] = lstUsuarios.get(i).getDetallesUsuario().getApellido_1(); 
		fila[4] = lstUsuarios.get(i).getDetallesUsuario().getApellido_2();
		fila[5] = lstUsuarios.get(i).getUsuario().getId_user();
		fila[6] = lstUsuarios.get(i).getUsuario().getEmail();
		fila[7] = lstUsuarios.get(i).getUsuario().getPasswd();
		fila[8] = lstUsuarios.get(i).getRol().getId_rol();
		fila[9] = lstUsuarios.get(i).getRol().getNombre_rol();
		
		tableModel.addRow(fila);
			
		}

	
		view.GestionUsuario.table.setModel(tableModel);
			
		view.GestionUsuario.table.getColumnModel().getColumn(0).setMaxWidth(0);
		view.GestionUsuario.table.getColumnModel().getColumn(0).setMinWidth(0);
		view.GestionUsuario.table.getColumnModel().getColumn(0).setPreferredWidth(0);
		view.GestionUsuario.table.getColumnModel().getColumn(5).setMaxWidth(0);
		view.GestionUsuario.table.getColumnModel().getColumn(5).setMinWidth(0);
		view.GestionUsuario.table.getColumnModel().getColumn(5).setPreferredWidth(0);
		view.GestionUsuario.table.getColumnModel().getColumn(8).setMaxWidth(0);
		view.GestionUsuario.table.getColumnModel().getColumn(8).setMinWidth(0);
		view.GestionUsuario.table.getColumnModel().getColumn(8).setPreferredWidth(0);
		
		view.GestionUsuario.table.getTableHeader().setReorderingAllowed(false) ;
		view.GestionUsuario.table.getTableHeader().setResizingAllowed(false);
		
	}

	
	public static void mensajeError(String mensaje) {
		
			view.GestionUsuario.lblError.setText(mensaje);
			view.GestionUsuario.lblError.setForeground(Color.RED);
	
	}
	
	public static void mensajeExito(String mensaje) {
		
		view.GestionUsuario.lblError.setText(mensaje);
		view.GestionUsuario.lblError.setForeground(Color.BLUE);
		
	}
	

	
}


class ParametrosBusquedaDetalleUsuarios{
	
	private String Busqueda;
	private String id_rol;
	
	public ParametrosBusquedaDetalleUsuarios(String Busqueda,String id_rol) {
		this.Busqueda = Busqueda;
		this.id_rol = id_rol;
	}

	public String getBusqueda() {
		return Busqueda;
	}

	public void setBusqueda(String busqueda) {
		Busqueda = busqueda;
	}

	public String getId_rol() {
		return id_rol;
	}

	public void setId_rol(String id_rol) {
		this.id_rol = id_rol;
	}

	@Override
	public String toString() {
		return "ParametrosBusquedaDetalleUsuarios [Busqueda=" + Busqueda + ", id_rol=" + id_rol + "]";
	}
	
	
}





