package logic;

import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

import model.Usuario;

public class LogicApp {


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

	
	public static JSONObject ObjetoToJson(Object o) {
		Gson g = new Gson();
		String jsonInString = g.toJson(o);
	
		JSONObject jsonObject  = new JSONObject(jsonInString);
		return jsonObject;
	}
	
	// Solo digitos
	
	public static MaskFormatter digitosOnly() {
		MaskFormatter mascara = null;
		try {
			mascara = new MaskFormatter("######");
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		return mascara;
	}
	


	
	
}
