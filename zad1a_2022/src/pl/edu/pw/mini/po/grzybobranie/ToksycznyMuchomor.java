package pl.edu.pw.mini.po.grzybobranie;
import java.util.Random;

public abstract class ToksycznyMuchomor extends Muchomor{
	
	Random random = new Random();

	public ToksycznyMuchomor() {
		this.twardosc = Twardosc.values()[random.nextInt(3)];
		this.masaOwocnika = random.nextDouble(25) + 25;
	}
	
	public void wypiszMuchomora() {
		super.wypiszMuchomora();
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	@Override
	public void ugotuj() {
		super.ugotuj();
	}
	
	@Override
	public boolean isTrujacy() {
		return true;
	}
}
