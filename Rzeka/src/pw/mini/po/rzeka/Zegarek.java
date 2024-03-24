package pw.mini.po.rzeka;


public class Zegarek extends BlyszczaceSuweniry{
	
	protected int nrSeryjny;
	protected static int counter = 10;
		
	public Zegarek() {
		super(random.nextInt(20000,25001)/100, random.nextBoolean());
		this.nrSeryjny = counter++;
	}
	
	@Override
	public String toString() {
		return "*";
	}

}
