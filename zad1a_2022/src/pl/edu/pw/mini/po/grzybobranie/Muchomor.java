package pl.edu.pw.mini.po.grzybobranie;

public abstract class Muchomor {
	
	protected Twardosc twardosc;
	protected double masaOwocnika;
	protected Toksyny toksyny;
	
	public Muchomor() {
		this.toksyny = Toksyny.NIEOBECNE;
	}

	public void wypiszMuchomora() {
		System.out.println("Muchomor:" );
		System.out.println("twardosc: " + twardosc);
		System.out.println("toksyny: " + toksyny);
		System.out.println("masa owocnika:  " + masaOwocnika);

	}
	
	@Override
	public String toString() {
		return "Muchomor:\n" + "twardosc: " + twardosc + "\ntoksyny: " + toksyny + "\nmasa owocnika: " + masaOwocnika;
	}
	
	public void ugotuj() {
		twardosc = Twardosc.MIEKKI;
	}
	
	public boolean isTrujacy() {
		return false;
	}
	

}
