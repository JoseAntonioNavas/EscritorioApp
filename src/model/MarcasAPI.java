package model;

public class MarcasAPI {
	private int Make_ID;
	private String Make_Name;
	public MarcasAPI(int make_ID, String make_Name) {
		super();
		Make_ID = make_ID;
		Make_Name = make_Name;
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
	@Override
	public String toString() {
		return "MarcasAPI [Make_ID=" + Make_ID + ", Make_Name=" + Make_Name + "]";
	}

}
