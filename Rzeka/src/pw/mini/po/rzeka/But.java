package pw.mini.po.rzeka;

public class But extends Suweniry{
	
	protected static String rodzaj = "Kalosz";
	
	public But() {
		super(0);
	}

	@Override
	public String toString() {
		return "@";
	}
	
	@Override
	public int distance() {
		return random.nextInt(2,4);
	}
}
