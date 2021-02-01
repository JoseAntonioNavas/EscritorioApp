package Logic;

import java.util.Random;

public class LogicEdificio {
	
	
	public static double TemperaturaRandom() {

		double temperatura = (Math.random() * 100) + 1;
		return temperatura;
	}
	public static boolean PersRamdon() {
		
		Random random = new Random();
	    return random.nextBoolean();
		
	}
}
