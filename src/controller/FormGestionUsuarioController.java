package controller;

import java.awt.Color;
import java.util.List;

import javax.swing.JOptionPane;

import model.DetallesUsuario;
import model.GenericUsuario;
import model.Usuario;
import service.DetallesUsuarioService;
import service.UsuarioService;
import view.FormGestionUsuario;

public class FormGestionUsuarioController {
	
	
	public static void visualStatusFrame() {
		
		Integer keyStatus = view.FormGestionUsuario.getStatus();
		
		switch (keyStatus) {
		case 0:
			//Añadir
				fieldsCrear();
				
			break;
		case 1:
			// Editar
			putGenericUsuario();	
			fieldsEditar();
				
			break;
		case 2:
			// Borrar
			putGenericUsuario();
			fieldsBorrar();
			break;
		default:
			break;
		}
	}
	
	private static void fieldsEditar() {
		view.FormGestionUsuario.txtNombre.setEnabled(true);
		view.FormGestionUsuario.txtApellido1.setEnabled(true);
		view.FormGestionUsuario.txtApellido2.setEnabled(true);
		view.FormGestionUsuario.txtNick.setEnabled(true);
		view.FormGestionUsuario.txtEmail.setEnabled(false);
		view.FormGestionUsuario.passwordField.setEnabled(true);
		view.FormGestionUsuario.passwordField.setEchoChar((char) 0);
		view.FormGestionUsuario.comboBoxRoles.setEnabled(true);
		
		view.FormGestionUsuario.btnBorrar.setEnabled(false);
		view.FormGestionUsuario.btnCrear.setEnabled(false);
		view.FormGestionUsuario.btnEditar.setEnabled(true);
	}
	
	private static void fieldsCrear() {
		view.FormGestionUsuario.txtNombre.setEnabled(true);
		view.FormGestionUsuario.txtApellido1.setEnabled(true);
		view.FormGestionUsuario.txtApellido2.setEnabled(true);
		view.FormGestionUsuario.txtNick.setEnabled(true);
		view.FormGestionUsuario.txtEmail.setEnabled(true);
		view.FormGestionUsuario.passwordField.setEnabled(true);
		view.FormGestionUsuario.passwordField.setEchoChar((char) 0);
		view.FormGestionUsuario.comboBoxRoles.setEnabled(true);
		
		view.FormGestionUsuario.btnBorrar.setEnabled(false);
		view.FormGestionUsuario.btnCrear.setEnabled(true);
		view.FormGestionUsuario.btnEditar.setEnabled(false);
	}
	
	private static void fieldsBorrar() {
			
		view.FormGestionUsuario.txtNombre.setEnabled(false);
		view.FormGestionUsuario.txtApellido1.setEnabled(false);
		view.FormGestionUsuario.txtApellido2.setEnabled(false);
		view.FormGestionUsuario.txtNick.setEnabled(false);
		view.FormGestionUsuario.txtEmail.setEnabled(false);
		view.FormGestionUsuario.passwordField.setEnabled(false);
		view.FormGestionUsuario.passwordField.setEchoChar((char) 0);
		view.FormGestionUsuario.comboBoxRoles.setEnabled(false);
		
		view.FormGestionUsuario.btnBorrar.setEnabled(true);
		view.FormGestionUsuario.btnCrear.setEnabled(false);
		view.FormGestionUsuario.btnEditar.setEnabled(false);

	}

	public static void setRolesComboBox() {
		
		logic.GestionUsuarioLogic.setRolesInComboBox();
		
	}
	
	public static List<String>  getCampos () {
		return logic.GestionUsuarioLogic.getCamposFormUsuario();
	}

	public static boolean crearUsuario() {
		
		String nombre = getCampos().get(0);
		String apellido1 = getCampos().get(1);
		String apellido2 = getCampos().get(2);
		String nick = getCampos().get(3);
		String email = getCampos().get(4);
		String password = getCampos().get(5);
		Integer id_rol = Integer.parseInt(getCampos().get(6));
		
		
		// Añadimos Usuario
		Usuario usuario = new Usuario(email,password);
		String respuesta;
		try {
			respuesta = UsuarioService.insertarUsuario(usuario);
			if(respuesta.equals("OK")){
				
				// Cogemos el ID generado
				ParametrosUsuario parametros = new ParametrosUsuario(email, password);
				List<Usuario> listUsuario = UsuarioService.getUsuarios(parametros);
				
					// Tabla detalle-usuario
					DetallesUsuario du = new DetallesUsuario(listUsuario.get(0).getId_user(), nick, id_rol, nombre, apellido1, apellido2);
					String respuesta1;
					
					try {
						respuesta1 = DetallesUsuarioService.newDetallesUsuario(du);
						
						if(respuesta1.equals("OK")) {
							
							mensajeExito("Usuario creado correctamente");
							vaciarCampos();
							controller.GestionUsuarioController.mensajeExito("Usuario creado Correctamente");
							controller.GestionUsuarioController.pintarTableUsuario();
							
							return true;
						}else {
							mensajeError(respuesta1);
							
							//borrar Usuario si da error
							borrarUsuarioById(String.valueOf(listUsuario.get(0).getId_user()));
							return false;
						}
						
					} catch (Exception e) {
						mensajeError("Error al crear el Usuario");
						//borrar Usuario si da error
						borrarUsuarioById(String.valueOf(listUsuario.get(0).getId_user()));
						return false;
					}	
				
			}else{
				mensajeError(respuesta);
				return false;
			}
		
		} catch (Exception e1) {
			mensajeError("Error al crearel Usuario");
			return false;
		}

		
	}

	private static void mensajeExito(String mensaje) {
		
		view.FormGestionUsuario.lblError.setText(mensaje);
		view.FormGestionUsuario.lblError.setForeground(Color.BLUE);

	}

	private static void mensajeError(String mensaje) {
		
		view.FormGestionUsuario.lblError.setText(mensaje);
		view.FormGestionUsuario.lblError.setForeground(Color.RED);
		
		JOptionPane.showMessageDialog(null, mensaje);
		
	}

	private static void vaciarCampos() {
		
		view.FormGestionUsuario.txtNombre.setText("");
		view.FormGestionUsuario.txtApellido1.setText("");
		view.FormGestionUsuario.txtApellido2.setText("");
		view.FormGestionUsuario.txtNick.setText("");
		view.FormGestionUsuario.txtEmail.setText("");
		view.FormGestionUsuario.passwordField.setText("");

		
	}
	
	
	public static boolean borrarModal() {
		
		
			String id_user = String.valueOf(view.FormGestionUsuario.usuariogenerico.getUsuario().getId_user());
			
			int seleccion = JOptionPane.showOptionDialog(
					   null,
					   "¿Estás Seguro de borrar el usuario? \n Recuerda que se borraran todos los datos asociados a este usuario", 
					   "Atencion",
					   JOptionPane.YES_NO_CANCEL_OPTION,
					   JOptionPane.ERROR_MESSAGE,
					   null,    // null para icono por defecto.
					   new Object[] { "Aceptar", "Cancelar" },   // null para YES, NO y CANCEL
					   "Aceptar");

			
					if (seleccion == 0) {
						
						String r = borrarUsuarioById(id_user);
						
						if(r.equals("OK")) {
							mensajeExito("Usuario eliminado Correctamente");
							controller.GestionUsuarioController.mensajeExito("Usuario eliminado Correctamente");
							controller.GestionUsuarioController.pintarTableUsuario();
							return true;
							// Cerramos formulario
							
						}else {
							mensajeError(r);
							return false;
						}
						
					}
					
			return false;
						 
					
		
	}
	
	private static String borrarUsuarioById(String id_user) {
		
		String response = null;
		
		try {
			
			return response  = UsuarioService.deleteUsuario(id_user);
			
		} catch (Exception e) {
			
			return response;
		}
		
	}
	

	private static void putGenericUsuario() {
		GenericUsuario usuariogenerico = FormGestionUsuario.usuariogenerico;
		view.FormGestionUsuario.txtNombre.setText(usuariogenerico.getDetallesUsuario().getNombre());
		view.FormGestionUsuario.txtApellido1.setText(usuariogenerico.getDetallesUsuario().getApellido_1());
		view.FormGestionUsuario.txtApellido2.setText(usuariogenerico.getDetallesUsuario().getApellido_2());
		view.FormGestionUsuario.txtEmail.setText(usuariogenerico.getUsuario().getEmail());
		view.FormGestionUsuario.passwordField.setText(usuariogenerico.getUsuario().getPasswd());
		view.FormGestionUsuario.txtNick.setText(usuariogenerico.getDetallesUsuario().getNick_user());
		view.FormGestionUsuario.comboBoxRoles.setSelectedItem(usuariogenerico.getRol().getNombre_rol());
	}

	public static boolean editar() {
		
		// Editamos tabla Usuario
		GenericUsuario usuariogenerico = FormGestionUsuario.usuariogenerico;
		Usuario u = new Usuario(usuariogenerico.getUsuario().getId_user(), getCampos().get(4), getCampos().get(5));
		DetallesUsuario d = new DetallesUsuario(
				usuariogenerico.getDetallesUsuario().getId_detalle_usuario()
				,usuariogenerico.getDetallesUsuario().getId_user()
				,getCampos().get(3)
				,Integer.parseInt(getCampos().get(6))
				,getCampos().get(0)
				,getCampos().get(1)
				,getCampos().get(2));
		
		
		
		try {
		
			String respuesta = UsuarioService.updatePassword(u);
			String respuesta1 = DetallesUsuarioService.updateDetallesUsuario(d);
			
			
			 	   if(respuesta.equals("OK") && respuesta1.equals("OK")) {
			 		   mensajeExito("Usuario editado correctamente");
			 		   controller.GestionUsuarioController.mensajeExito("Usuario editado correctamente");
			 		   controller.GestionUsuarioController.pintarTableUsuario();
			 		   return true;
			 		   // cerramos formulario
			 		   
			 	   }else {
			 		   if(respuesta1.equals("OK")) {
			 			  mensajeError(respuesta);
			 			  return false;
			 		   }else{
			 			   
			 		  
				 		   if(respuesta.equals("OK")){
				 			   mensajeError(respuesta1);
				 			  return false;
				 		   }else {
				 			   mensajeError(respuesta1);
				 			  return false;
				 		   }
			 		  }
			 		   
			 	   }
			
			
		} catch (Exception e) {
			mensajeError("Error al editar el usuario");
			return false;
		}
		
	}


	// Clase para crear objeto ( Objeto pasarle parametros a la búsqueda)
	private static class ParametrosUsuario {
		
		private String email;
		private String passwd;
		
		public ParametrosUsuario(String email, String passwd) {

			this.email = email;
			this.passwd = passwd;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPasswd() {
			return passwd;
		}
		public void setPasswd(String passwd) {
			this.passwd = passwd;
		}
		
		
		
	}








	
}


