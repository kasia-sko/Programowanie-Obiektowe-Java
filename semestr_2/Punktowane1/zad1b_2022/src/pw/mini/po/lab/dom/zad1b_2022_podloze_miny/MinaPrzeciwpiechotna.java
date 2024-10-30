package pw.mini.po.lab.dom.zad1b_2022_podloze_miny;
import java.util.Random;

import pw.mini.po.lab.dom.zad1b_2022_podloze.Obudowa;

public class MinaPrzeciwpiechotna extends Mina{
	
	private Obudowa obudowa;
	
	Random random = new Random();
	
	public MinaPrzeciwpiechotna(){
		super();
		this.obudowa = Obudowa.values()[random.nextInt(2)];
		if(obudowa == Obudowa.KARTON) {
			this.ekologiczna = true;
		}
		else {
			this.ekologiczna = false;
		}
	}
	
	@Override
	public void pressMe() {
		if(uzbrojona) {
			System.out.println("Boom!");
		}
		else {
			super.pressMe();
		}
	}

	@Override
	public String toString() {
		return "x";
	}
	

}
