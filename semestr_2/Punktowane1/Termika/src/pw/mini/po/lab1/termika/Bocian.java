package pw.mini.po.lab1.termika;

public class Bocian extends Szybowce {
	
	private Teren teren;
	
	public Bocian(Teren teren, int wysokosc) {
		super(teren, wysokosc);
	}
	
	@Override
	public void fly() {
		super.fly();
		if(wysokosc != 0) {
			System.out.println("Lece jak prawdziwy bocian!");
		}
	}
	
	@Override
	public String toString() {
		return "Bocian: aktualna wysokosc: " + wysokosc;
	}

}
