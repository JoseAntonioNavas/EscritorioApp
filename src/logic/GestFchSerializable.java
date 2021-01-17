package logic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class GestFchSerializable {

	public static void writeDataObjecctUsuario(String FILE_NAME, List<Usuario> listado) {
		
		try {
			ObjectOutputStream fch = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
			
			for (Usuario u : listado) {
				fch.writeObject(u);
			}
			
			fch.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error leyendo el archivo");
		} catch (IOException e) {
			System.err.println("Error accediendo al archivo.");
		}
		
		
	}

	public static List<Usuario> readDataObjectUsuario(String FILE_NAME) {
		
		List<Usuario> listado = new ArrayList<Usuario>();
		
		try {
			ObjectInputStream fch = new ObjectInputStream(new FileInputStream(FILE_NAME));
			
				try {
					Object obj = fch.readObject();
					
					while(obj != null) {
						
						if(obj instanceof Usuario) {
							
							listado.add((Usuario) obj);
						}
						fch.readObject();
					}
					
					
				} catch (ClassNotFoundException e) {
					
				}
			
			fch.close();
		} catch (IOException e) {
			
		}
		
		return listado;
	}

	public static void writeDataListUsuarioUsuario(String FILE_NAME, List<Usuario> listado) {
		
		try {
			ObjectOutputStream fch = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
			
			fch.writeObject(listado);
			
			fch.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error leyendo el archivo");
		} catch (IOException e) {
			System.err.println("Error accediendo al archivo.");
		}
		
	}

	@SuppressWarnings("unchecked")
	public static List<Usuario> readDataListUsuario(String FILE_NAME) {
		
		List<Usuario> listado = new ArrayList<Usuario>();
		
		try {
			ObjectInputStream fch = new ObjectInputStream(new FileInputStream(FILE_NAME));
				
			try {
				listado = (ArrayList<Usuario>) fch.readObject();
			} catch (ClassNotFoundException e) {
				
			}
					
				
			fch.close();
		} catch (IOException e) {
			
		}
		
		return listado;
	}

}
