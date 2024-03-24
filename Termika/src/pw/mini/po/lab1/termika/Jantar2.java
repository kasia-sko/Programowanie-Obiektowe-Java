package pw.mini.po.lab1.termika;

public class Jantar2 extends Szybowce{
	
	private Teren teren;
	
	public Jantar2(Teren teren, int wysokosc) {
		super(teren, wysokosc);
	}
	
	@Override
	public void fly() {
		super.fly();
		if(wysokosc != 0) {
			System.out.println("Aktualna wyskosc: " + wysokosc);
		}
	}

	@Override
	public String toString() {
		return "Jantar2: aktualna wysokosc: " + wysokosc;
	}

}
