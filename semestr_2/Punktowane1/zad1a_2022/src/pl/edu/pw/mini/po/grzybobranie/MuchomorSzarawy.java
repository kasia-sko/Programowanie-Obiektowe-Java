package pl.edu.pw.mini.po.grzybobranie;
import java.util.Random;

public class MuchomorSzarawy extends ToksycznyMuchomor{
	
	protected static int rokOdkryciaGatunku = 1783;
	Random random = new Random();

	
	public MuchomorSzarawy() {
		this.twardosc = Twardosc.TWARDY;
		this.toksyny = Toksyny.TRUJACE;
	}
	
	@Override
	public void wypiszMuchomora() {
		super.wypiszMuchomora();
		System.out.println("rok odkrycia gatunku: " + rokOdkryciaGatunku);
		System.out.println("nazwa: muchomor szarawy");
		
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nrok odkrycia gatunku: " + rokOdkryciaGatunku + "\nnazwa: muchomor szarawy";
	}
	
	@Override
	public void ugotuj() {
		super.ugotuj();
		toksyny = Toksyny.NIEOBECNE;
	}

	@Override
	public boolean isTrujacy() {
		if (toksyny == Toksyny.NIEOBECNE) {
			return false;
		}
		else {
			return true;
		}
	}

}
