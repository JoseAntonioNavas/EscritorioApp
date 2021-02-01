package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import Controlador.ContrEdificio;
import Controlador.PeticionHTTP;
import Modelo.Edificio;

public class Servidor implements Runnable, Serializable {

	private static final long serialVersionUID = 1L;
	private int port;

	public Servidor(int port) {
		this.port = port;
	}

	@Override
	public void run() {
		ServerSocket servidor = null;
		Socket socket = null;
		//DataInputStream inputStream;
		ObjectOutputStream outputStream;

		try {
			servidor = new ServerSocket(port);
			System.out.println("SERVER INICIADO.");
			String sResString = PeticionHTTP.peticionHttpGET("https://clinicadentaljava.000webhostapp.com/Edificios/ListEdificio.php");
			System.out.println(sResString);
			List<Edificio> lstedificios = PeticionHTTP.jsonToEdificios(sResString);

			socket = servidor.accept();
			System.out.println("CLIENTE CONECTADO.");
			//inputStream = new DataInputStream(socket.getInputStream());
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			//String sMensaje = inputStream.readUTF();
			//System.out.println(sMensaje);
			for (int i = 0; i < lstedificios.size(); i++) {
				outputStream.writeObject(lstedificios.get(i));
				System.out.println("Objeto enviado."+lstedificios.get(i));
			}
			
			socket.close();
			System.out.println("Cliente desconectado");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Thread mihilo = new Thread(new Servidor(8888));
		mihilo.start();
	}

}
