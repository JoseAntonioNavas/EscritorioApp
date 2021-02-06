package model;

public class ParametrosNuevoColor {
	
	private String rgbcolor;

	public ParametrosNuevoColor(String rgbcolor) {
		
		this.rgbcolor = rgbcolor;
	}


	public String getRgbcolor() {
		return rgbcolor;
	}


	public void setRgbcolor(String rgbcolor) {
		this.rgbcolor = rgbcolor;
	}


	@Override
	public String toString() {
		return "ParametrosNuevoColor [rgbcolor=" + rgbcolor + "]";
	}
}
