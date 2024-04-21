package pl.edu.pw.mini.po.dom.punktowane2.pralnia.ubrania;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import pl.edu.pw.mini.po.dom.punktowane2.pralnia.ubrania.elementyKieszeni.Guzik;

public class Koszula extends Ubranie{
	
	private int rozmiar;
	private Set<Guzik> guziki;
	
	public Koszula() {
		super();
		this.rozmiar = random.nextInt(6) + 35;
		this.guziki = new LinkedHashSet<>();
		generujGuziki();
	}

	private void generujGuziki() {
		for (int i = 0; i < 6; i++) {
			guziki.add(new Guzik());
		}
	}
	
	public Set<Guzik> getGuziki(){
		return guziki;
	}
	
	public int getRozmiar() {
		return rozmiar;
	}

}
