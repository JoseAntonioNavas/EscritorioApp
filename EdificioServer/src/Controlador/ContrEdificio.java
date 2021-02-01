package Controlador;

public class ContrEdificio {

	public static String ctrFuego() {
		
		String sMensaje = "TODO VA BIEN.";
		double temp = Logic.LogicEdificio.TemperaturaRandom();
		if (temp >= 50) {
			sMensaje = "HAY FUEGO \n LLAMANDO A LOS BOMBEROS \n ACTIVANDO ROCIADORES DE AGUA.";
			if (Logic.LogicEdificio.PersRamdon()) {
				sMensaje = sMensaje + "\n"
						+ "MANTENIENDO PUERTAS ABIERTAS PARA LA EVACUACION \n LLAMANDO A LA AMBULANCIA.";
			} else {
				sMensaje = sMensaje + "\n" + "BLOQUEANDO PUERTAS Y VENTANAS PARA EVITAR PROPAGACION DEL FUEGO.";
			}
		}
		return sMensaje;
	}
	
	
	
}
