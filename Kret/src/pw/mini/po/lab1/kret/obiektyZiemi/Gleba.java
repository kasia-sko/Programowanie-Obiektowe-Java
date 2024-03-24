package pw.mini.po.lab1.kret.obiektyZiemi;

public class Gleba extends ObiektyZiemi{
	
	private double gestosc;
	
	public Gleba(int wartosc) {
		super(wartosc);
		this.gestosc = random.nextDouble(1) + 1.4;
	}
	
	@Override
	public String toString() {
		return "#";
	}

}
