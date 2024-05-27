package pl.pw.mini.po.dom.punktowane3.kebaby.procesor;

import java.util.ArrayList;

import pl.pw.mini.po.dom.punktowane3.kebaby.Kebab;
import pl.pw.mini.po.dom.punktowane3.kebaby.KebabTalerz;

public class KebabProcessor {

	public static ArrayList<KebabTalerz> getTellerKebabs(ArrayList<Kebab> kebaby){
		KebabTalerzVisitor visitor = new KebabTalerzVisitor();
		for(Kebab kebab : kebaby) {
			kebab.apply(visitor);
		}
		return visitor.getKebabyNaTalerzu();
	}
	
	public static void getSummary(ArrayList<Kebab> kebaby) {
		double sumaCena = 0d;
		int sumaWaga = 0;
		for (Kebab kebab : kebaby) {
			System.out.println(kebab);
			sumaCena += kebab.getCena();
			sumaWaga += kebab.getWaga();
		}
		System.out.println("srednia cena: " + sumaCena / kebaby.size());
		System.out.println("laczna waga: " + sumaWaga);
	}
}
