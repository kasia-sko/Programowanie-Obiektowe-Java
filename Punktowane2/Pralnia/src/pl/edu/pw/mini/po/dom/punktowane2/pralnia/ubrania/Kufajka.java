package pl.edu.pw.mini.po.dom.punktowane2.pralnia.ubrania;

public class Kufajka extends Ubranie{
	
	private int rozmiar;
	
	public Kufajka() {
		this.rozmiar = random.nextInt(6) + 35;
	}

	public int getRozmiar() {
		return rozmiar;
	}

}
