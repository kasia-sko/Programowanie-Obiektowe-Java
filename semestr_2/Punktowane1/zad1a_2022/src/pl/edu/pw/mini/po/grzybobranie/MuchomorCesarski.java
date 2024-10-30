package pl.edu.pw.mini.po.grzybobranie;
import java.util.Random;

public class MuchomorCesarski extends Muchomor{
	
	Random random = new Random();
	
	public MuchomorCesarski() {
		super();
		this.twardosc = Twardosc.TWARDY;
		this.masaOwocnika = random.nextDouble(25) + 50;
	}
	
	@Override
	public void wypiszMuchomora() {
		super.wypiszMuchomora();
		System.out.println("nazwa: muchomor cesarski");
		
	}
	
	@Override
	public String toString() {
		return super.toString() + "nazwa: muchomor cesarski";
	}
}
