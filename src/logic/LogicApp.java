package logic;

import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Usuario;

public class LogicApp {

	private void lol() {
		
	}
	/**
	 * Anchura y Altura de la pantalla 
	 * @return
	 */
	public static Hashtable<String, Integer> dimensionPantalla() {
		
		Toolkit t = Toolkit.getDefaultToolkit();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		
		Hashtable<String, Integer> dimensiones = new Hashtable<String, Integer>();
		dimensiones.put("width",ancho);
		dimensiones.put("height", alto);

		
		 return dimensiones;

	}
	
	/**
	 * Descifar contraseña de un JPassword
	 * @return
	 */
	public static String descrifarPassword(JPasswordField PasswordField ) {
		
		char [] password = PasswordField.getPassword();
		String passwordDescifrada = "";
		
		for (int i = 0; i < password.length; i++) {
			char c = password[i];
			passwordDescifrada += c;
			
		}
		
		return passwordDescifrada;
		
	}
	
	
	public static List<Usuario> JsonToUsuarios(String response) {
		List<Usuario> lstResultado = new ArrayList<>();
		
		JSONArray jsonA = new JSONArray(response);
		for (int i = 0; i < jsonA.length(); i++) {
			
			JSONObject jsonO = jsonA.getJSONObject(i);
			Usuario u = JsonToUsuario(jsonO);
					
					lstResultado.add(u);
				
		}
	
		return lstResultado;
	}
	
	private static Usuario JsonToUsuario(JSONObject jsonO) {
		
		   	Integer id_user = jsonO.getInt("id_user");
		    String email = jsonO.getString("email");
		    String password = jsonO.getString("password");
		     
		     
		     Usuario u = new Usuario(id_user, email, password);
		     return u;
		     
	}
	
	
	public static int longitudTextField(JTextField txtField) {
		
		int longitud = txtField.getText().length();
		return longitud;
	}

	public static int longitudJPassword(JPasswordField passwordField) {
		
		int longitud = descrifarPassword(passwordField).length();
		return longitud;
	}
	
	
	public static boolean pressKeyEnter(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			return true;
		}else {
			return false;
		}
	}

	
	
	
}
