package pw.mini.po.lab1.termika;
import java.util.Random;

public abstract class KomorkiTerenowe {
	protected int temperatura;
	public Random random = new Random();
	
	public KomorkiTerenowe(int temperatura) {
		this.temperatura = temperatura;
	}
	
	public abstract double getPradyNoszace();
	
	public void modyfikujTemperature(int deltaT) {
		if (deltaT < -20 || deltaT > 50) {
			System.out.println("Nie obsługujemy takiej zmiany temperatury!");
		}
		else {
			temperatura += deltaT;
		}
	}

}
