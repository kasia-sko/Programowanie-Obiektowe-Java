package pl.mini.pw.mini.po.dom.punktowane2.przejsciegraniczne;

import java.util.Set;
import java.util.TreeSet;

import pl.mini.pw.mini.po.dom.punktowane2.przejsciegraniczne.podrozny.Podrozny;

public class Areszt {
	
	protected Set<Podrozny> aresztowani;
	
	public Areszt() {
		this.aresztowani = new TreeSet<Podrozny>();
	}
	
	public void aresztuj(Podrozny oszust) throws NieletniException{
		if(oszust.getWiek() < 18) {
//			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			throw new NieletniException();
		}
		else {
			aresztowani.add(oszust);
//			System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!" + aresztowani.size());
		}
		
	}

}
