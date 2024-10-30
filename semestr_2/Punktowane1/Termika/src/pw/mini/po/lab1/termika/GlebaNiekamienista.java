package pw.mini.po.lab1.termika;

public class GlebaNiekamienista extends Gleba{
	
	public GlebaNiekamienista(int temperatura) {
		super(temperatura);
		this.gestosc = random.nextDouble(0.5) + 1;
	}

}
