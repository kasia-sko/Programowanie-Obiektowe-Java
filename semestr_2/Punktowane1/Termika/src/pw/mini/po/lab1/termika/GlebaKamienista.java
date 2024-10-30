package pw.mini.po.lab1.termika;

public class GlebaKamienista extends Gleba{
	
	private static int gestoscMinimalna = 1;
	
	public GlebaKamienista(int temperatura) {
		super(temperatura);
		this.gestosc = random.nextDouble(1) + 1;
	}

}
