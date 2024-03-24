package pw.mini.po.lab1.kret.obiektyZiemi;
import java.util.Random;

public class ObiektyZiemi {
	
	protected int wartoscOdzywcza;
	static Random random = new Random();
	
	public ObiektyZiemi(int wartosc) {
		this.wartoscOdzywcza = wartosc;
	}
	
	public int getWartoscOdzywcza() {
		return wartoscOdzywcza;
	}

}
