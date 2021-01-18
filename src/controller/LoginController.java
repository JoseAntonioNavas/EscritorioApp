package controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import org.json.JSONObject;
import logic.GestFchSerializable;
import logic.globalVariables;
import model.Usuario;
import repository.UsuarioRepository;

public class LoginController {
	
	private static boolean booleanError= false;
	
	/**
	 * 
	 */
	public static void login() {
			
		
		// Recogo los datos
		
		String email = view.Login.txtEmail.getText();
		String password = logic.LogicApp.descrifarPassword(view.Login.passwordField);
		
		// FORMATO JSON
		
		 JSONObject usuarioJSON = new JSONObject();		
		 usuarioJSON.put("email", email);
		 usuarioJSON.put("password", password);
	
		// Mandamos peticion al servidor 
		 
		try {
		
			// Peticion Login
			List<Usuario> listaUsuario = UsuarioRepository.login(usuarioJSON);
			
			if(listaUsuario.size() != 0) {
				
				booleanError = false;
				mensajeError("");
				
				listaUsuario.forEach(u -> {

					Usuario u1 = new Usuario(u.getId_user(),u.getEmail(),u.getPasswd());
					
					// Pasamos el usuario que ha iniciado sesion a una variable global para que toda la aplicacion pueda usarla.
					logic.globalVariables.usuarioLogged = u1;
				});
				
				// Guardamos las variables en un archivo externo si el usuario quiere que le recuerdela contraseña y el usuario
					LoginController.escrituraRecordarUsuario();
			}else {
				
				booleanError = true;
				mensajeError("Usuario y contraseña incorrectas.");
			
			}
						
		} catch (Exception e) {
			
			booleanError = true;
			mensajeError("Error al conectarse al Servidor");

			
		}
		
	}
	





	public static void ocultarLogin(JFrame f) {
		
		if(logic.globalVariables.usuarioLogged instanceof Usuario) {
			// Si existe la variable global del Usuario que inicia sesion
			f.setVisible(false);
			
			

		}else{
			// Si no seguimos mostrando el Frame principal(Login)
			f.setVisible(true);
		};
	}
	
	
	
	public static void mensajeError(String mensaje) {
		
		view.Login.lblError.setText(mensaje);
		if(mensaje == "") {
			
			view.Login.passwordField.setBorder(BorderFactory.createLineBorder(Color.black));
			view.Login.txtEmail.setBorder(BorderFactory.createLineBorder(Color.black));
			
		}else {
			view.Login.passwordField.setBorder(BorderFactory.createLineBorder(Color.red));
			view.Login.txtEmail.setBorder(BorderFactory.createLineBorder(Color.RED));
		}
		
	}

	/**
	 * Compruebo la longitud de los campos del formulario login
	 */
	public static void lengthFieldLogin() {
		
		int fieldEmail = logic.LogicApp.longitudTextField(view.Login.txtEmail);
		int fieldPassword = logic.LogicApp.longitudJPassword(view.Login.passwordField);
		
		// Para habilitar el boton de Logear(Entrar)
		if(fieldEmail > 0  && fieldPassword > 0) {
			btnEnabledTrue(view.Login.btnEntrar);
		}else {
			btnEnabledFalse(view.Login.btnEntrar);
		}
	}

	
	
	private static void btnEnabledFalse(JButton btnEntrar) {
		
		btnEntrar.setEnabled(false);
		
	}

	
	
	private static void btnEnabledTrue(JButton btnEntrar) {
		btnEntrar.setEnabled(true);
	}


	public static void selectedRecordar(JCheckBox c) {
		if(c.isSelected()) {
			c.setSelected(false);
		}else {
			c.setSelected(true);
		}
	}
	
	
	private static void escrituraRecordarUsuario() {
		
		List<Usuario> listadoUsuario = new ArrayList<Usuario>();
		Usuario u = globalVariables.usuarioLogged;
		
		if(view.Login.chbxRecordar.isSelected()) {
			listadoUsuario = new ArrayList<Usuario>();
			listadoUsuario.add(u);
		}else {
			listadoUsuario = new ArrayList<Usuario>();
		}
	
		
		GestFchSerializable.writeDataObjecctUsuario(globalVariables.FILE_RECORDAR_USUARIO,listadoUsuario);
	}
	
	
	private static Usuario lecturaRecordarUsuario() {
		
		Usuario usuario = null;
		List<Usuario> listadoUsuario = GestFchSerializable.readDataObjectUsuario(globalVariables.FILE_RECORDAR_USUARIO);
		for (Usuario u: listadoUsuario) {
			usuario = u;
		}
		
		return usuario;
		
	}
	
	
	public static void rellenarCamposLogin() {
				
		if(lecturaRecordarUsuario() == null) {
			view.Login.txtEmail.setText("");
			view.Login.passwordField.setText("");
			
		}else{
			Usuario usuario = lecturaRecordarUsuario();
			
			view.Login.txtEmail.setText(usuario.getEmail()); // Email
			view.Login.passwordField.setText(usuario.getPasswd()); // Password
			view.Login.chbxRecordar.setSelected(true); // Recordar
			
		};
		
		
	}
	

}
