package pw.mini.po.lab1.termika;

public abstract class Gleba extends KomorkiTerenowe{
	
	protected double gestosc;
	
	public Gleba(int temperatura) {
		super(temperatura);
	}

	@Override
	public double getPradyNoszace() {
		return temperatura * 0.66 /8;
	}
	
	@Override
	public void modyfikujTemperature(int deltaT) {
		super.modyfikujTemperature(deltaT);
		if (temperatura>40) {
			temperatura = 40;
		}
	}
}
