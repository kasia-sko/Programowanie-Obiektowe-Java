package pw.mini.po.lab1.kret.obiektyZiemi;

public class Larwa extends ObiektyZiemi{
	
	private double masa;
	
	public Larwa(int wartosc) {
		super(wartosc);
		this.masa = random.nextDouble(1) + 2;
	}
	
	@Override
	public String toString() {
		return "@";
	}

}
