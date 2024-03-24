package pw.mini.po.lab1.kret.obiektyZiemi;

public class Dzdzownica extends ObiektyZiemi{
	
	private double masa;
	
	public Dzdzownica(int wartosc) {
		super(wartosc);
		this.masa = random.nextDouble(0.5) + 1;
	}
	
	@Override
	public String toString() {
		return "{}";
	}

}
