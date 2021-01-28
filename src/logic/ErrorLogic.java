package logic;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Usuario;

public class ErrorLogic {

	private Integer status;
	private String msg;
	
	public ErrorLogic(Integer status,String msg) {
		
		this.status = status;
		this.msg = msg;
		
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
	@Override
	public String toString() {
		return "ErrorLogic [status=" + status + ", msg=" + msg + "]";
	}
	public static List<ErrorLogic> JsonToErrores(String response) {
		List<ErrorLogic> lstResultado = new ArrayList<>();
		
		
		JSONArray jsonA = new JSONArray(response);
		for (int i = 0; i < jsonA.length(); i++) {
			
			JSONObject jsonO = jsonA.getJSONObject(i);
			ErrorLogic u = JsonToError(jsonO);
					lstResultado.add(u);
		}
	
		return lstResultado;
	}
	
	public static ErrorLogic JsonToError(JSONObject jsonO) {
		
		   
		    Integer status = jsonO.getInt("status");
		    String msg = jsonO.getString("msg");
		     
		    return new ErrorLogic(status,msg);
		  		     
	}
	
}
