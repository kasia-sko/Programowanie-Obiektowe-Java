package pw.mini.po.rzeka;

public class Moneta extends BlyszczaceSuweniry{
	
	public Moneta() {
		super(random.nextInt(500000)/100, random.nextBoolean());
	}
	
	@Override
	public String toString() {
		return "O";
	}

}
