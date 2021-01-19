package logic;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import model.DetallesUsuario;
import model.Roles;
import model.Usuario;

public class DetallesUsuarioLogic {

	
	public static void JsonToAllDetallesUsuarios(String response) {
		
		List<DetallesUsuario> du = JsonToDetallesUsuarios(response);
		
		JSONArray jsonA = new JSONArray(response);
		System.out.println(response);
	
		for (Object object : jsonA) {
		     
			System.out.println(object);

		}
		
		
		List<Roles> r = RolesLogic.JsonToRoles(response);
		List<Usuario> u = UsuarioLogic.JsonToUsuarios(response);

		for (Usuario usuario : u) {
			System.out.println( usuario);
		}
		for (Roles roles : r) {
			System.out.println( roles);
		}
		for (DetallesUsuario Detalleusuario : du) {
			System.out.println( Detalleusuario);
		}
	}
	
	
	
	public static List<DetallesUsuario> JsonToDetallesUsuarios(String response) {
		
		List<DetallesUsuario> listDetalleUsuario = new ArrayList<>();
		
		JSONArray jsonA = new JSONArray(response);
		for (int i = 0; i < jsonA.length(); i++) {
			
			JSONObject jsonO = jsonA.getJSONObject(i);
			DetallesUsuario dU = JsonToDetalleUsuario(jsonO);
					
				listDetalleUsuario.add(dU);
				
		}
	
		return listDetalleUsuario;
	}
	
	private static DetallesUsuario JsonToDetalleUsuario(JSONObject jsonO) {
		
		   	Integer id_detalle_usuario = jsonO.getInt("id_detalle_usuario");
		    String nick_user = jsonO.getString("nick_user");
		    String nombre = jsonO.getString("nombre");
		    String apellido_1 = jsonO.getString("apellido_1");
		    String apellido_2 = jsonO.getString("apellido_2");
		    int id_user = jsonO.getJSONObject("usuario").getInt("id_user");
		    int id_rol = jsonO.getJSONObject("rol").getInt("id_rol");
		    
		   DetallesUsuario du = new DetallesUsuario(id_detalle_usuario, id_user, nick_user, id_rol, nombre, apellido_1, apellido_2);
		     return du;
		     
	}
	
	
}
