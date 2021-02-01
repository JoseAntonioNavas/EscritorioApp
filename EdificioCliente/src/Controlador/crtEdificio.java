package Controlador;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Logica.PeticionHTTP;
import Modelo.Edificio;

public class crtEdificio {

	public static void addEdificio(JTextField txtNombre, JTextField txtCiudad, JTextField txtDireccion) {

		try {
			PeticionHTTP.peticionHttpGET(
					"https://clinicadentaljava.000webhostapp.com/Edificios/NewEdificio.php?NOMBRE_EDIFICIO="
							+ txtNombre.getText() + "&DIRECCION=" + txtDireccion.getText() + "&CIUDAD="
							+ txtCiudad.getText());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void deleteEdificio(int iID) {

		try {
			PeticionHTTP.peticionHttpGET(
					"https://clinicadentaljava.000webhostapp.com/Edificios/DeleteEdificio.php?ID_EDIFICIO=" + iID);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Edificio readEdificio() throws IOException, ClassNotFoundException {
		Edificio Edificio;
		try {

			Socket scSocket = new Socket("localhost", 8888);
			ObjectInputStream inputStream = new ObjectInputStream(scSocket.getInputStream());

			Edificio = (Edificio)inputStream.readObject();

			scSocket.close();
			return Edificio;
		} catch (Exception e) {
			return null;
		}

	}

	public static List<Edificio> getEdificios() {
		try {
			String respuesta=PeticionHTTP.peticionHttpGET("https://clinicadentaljava.000webhostapp.com/Edificios/ListEdificio.php");
			List<Edificio>lstEdificios= PeticionHTTP.jsonToEdificios(respuesta);
			
			return lstEdificios;
		} catch (IOException e) {
			return null;
		}
		
	}

}
