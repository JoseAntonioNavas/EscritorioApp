package model;

public class ModeloAPI {

	private int Make_ID;
	private String Make_Name;
	private int Model_ID;
	private String Model_Name;
	

	public ModeloAPI(int make_ID, String make_Name, int model_ID, String model_Name) {
		super();
		Make_ID = make_ID;
		Make_Name = make_Name;
		Model_ID = model_ID;
		Model_Name = model_Name;
	}
	@Override
	public String toString() {
		return "ModeloAPI [Make_ID=" + Make_ID + ", Make_Name=" + Make_Name + ", Model_ID=" + Model_ID + ", Model_Name="
				+ Model_Name + "]";
	}
	public int getMake_ID() {
		return Make_ID;
	}
	public void setMake_ID(int make_ID) {
		Make_ID = make_ID;
	}
	public String getMake_Name() {
		return Make_Name;
	}
	public void setMake_Name(String make_Name) {
		Make_Name = make_Name;
	}
	public int getModel_ID() {
		return Model_ID;
	}
	public void setModel_ID(int model_ID) {
		Model_ID = model_ID;
	}
	public String getModel_Name() {
		return Model_Name;
	}
	public void setModel_Name(String model_Name) {
		Model_Name = model_Name;
	}
	
	
	
	
}
