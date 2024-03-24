package pw.mini.po.lab1.termika;

public abstract class ElementWodny extends KomorkiTerenowe{
	
	private boolean spelniaWymogiNatura2000;
	
	public ElementWodny(int temperatura) {
		super(temperatura);
		this.spelniaWymogiNatura2000 = random.nextBoolean();
	}
	
	@Override
	public double getPradyNoszace() {
		return temperatura/10 - random.nextInt(1,5);
	}
	
	@Override
	public void modyfikujTemperature(int deltaT) {
		super.modyfikujTemperature(deltaT);
		if (temperatura>20) {
			temperatura = 20;
		}
	}

}
