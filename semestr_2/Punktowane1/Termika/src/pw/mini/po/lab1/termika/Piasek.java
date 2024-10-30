package pw.mini.po.lab1.termika;

public class Piasek extends KomorkiTerenowe{
	
	private Sypkosc sypkosc;
	
	public Piasek(int temperatura) {
		super(temperatura);
		this.sypkosc = Sypkosc.values()[random.nextInt(3)];
	}
	
	@Override
	public double getPradyNoszace() {
		return temperatura * 0.2 * random.nextDouble(1);
	}
	
	@Override
	public void modyfikujTemperature(int deltaT) {
		super.modyfikujTemperature(deltaT);
		if (temperatura>50) {
			temperatura = 50;
		}
	}

}
