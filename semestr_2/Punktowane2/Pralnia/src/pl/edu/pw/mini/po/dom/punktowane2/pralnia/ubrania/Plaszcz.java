package pl.edu.pw.mini.po.dom.punktowane2.pralnia.ubrania;

public class Plaszcz extends Ubranie{
	
	private int waga;
	
	public Plaszcz() {
		super();
		this.waga = random.nextInt(6) + 5;
	}

	public int getWaga() {
		return waga;
	}
}
