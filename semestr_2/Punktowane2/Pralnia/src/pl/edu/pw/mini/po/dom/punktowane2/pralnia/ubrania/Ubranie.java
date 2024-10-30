package pl.edu.pw.mini.po.dom.punktowane2.pralnia.ubrania;

import java.util.LinkedList;
import java.util.Random;

import pl.edu.pw.mini.po.dom.punktowane2.pralnia.ubrania.elementyKieszeni.ElementKieszeni;
import pl.edu.pw.mini.po.dom.punktowane2.pralnia.ubrania.elementyKieszeni.Granat;
import pl.edu.pw.mini.po.dom.punktowane2.pralnia.ubrania.elementyKieszeni.Guzik;
import pl.edu.pw.mini.po.dom.punktowane2.pralnia.ubrania.elementyKieszeni.KartkaZAdresem;

public abstract class Ubranie {
	
	protected static final Random random = new Random();
	private boolean czystosc;
	private LinkedList<ElementKieszeni> kieszen;
	
	public Ubranie() {
		this.czystosc = false;
		this.kieszen = new LinkedList<ElementKieszeni>();
		wypelnijKieszen();
	}
	
	public void wypelnijKieszen() {
		int x = random.nextInt(3) + 1;
		for (int i = 0; i < x; i++) {
			int s = random.nextInt(3);
			if (s == 0) {
				kieszen.add(new Guzik());
			}
			else if (s == 1) {
				kieszen.add(new Granat());
			}
			else kieszen.add(new KartkaZAdresem(losujCiągZnakow()));
		}
		
	}
	 private String losujCiągZnakow() {
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < 10; i++) {
	            char losowyZnak = (char) (random.nextInt(95) + 32);
	            sb.append(losowyZnak);
	        }
	        return sb.toString();
	    }
	 
	 public LinkedList<ElementKieszeni> getKieszen(){
		 return kieszen;
	 }
	 
	 public boolean getCzystosc() {
		 return czystosc;
	 }
	 
	 public void setCzystosc() {
		 czystosc = true;
	 }

}
