package pl.edu.pw.mini.po.dom.punktowane2.pralnia;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;

import pl.edu.pw.mini.po.dom.punktowane2.pralnia.ubrania.Ubranie;
import pl.edu.pw.mini.po.dom.punktowane2.pralnia.ubrania.elementyKieszeni.ElementKieszeni;
import pl.edu.pw.mini.po.dom.punktowane2.pralnia.ubrania.elementyKieszeni.GranatVisitor;
import pl.edu.pw.mini.po.dom.punktowane2.pralnia.ubrania.elementyKieszeni.OdbezpieczonyGranatException;

public class Pralnia<T> implements Pierzacy{
	
	private T certificate;
	private HashSet<Ubranie> elementyDoPrania;
	private LinkedHashSet<Ubranie> elementyWyprane;
	private Map<Ubranie, LinkedList<ElementKieszeni>> wyjeteRzeczy;
	
	public Pralnia(T certificate) {
		this.elementyDoPrania = new HashSet<>();
		this.elementyWyprane = new LinkedHashSet<>();
		this.wyjeteRzeczy = new HashMap<>();
		this.certificate = certificate;
	}
	
	public void putToWash(Ubranie ubranie) {
		elementyDoPrania.add(ubranie);
	}
	
	public void washAll() throws OdbezpieczonyGranatException{
		Iterator<Ubranie> i = elementyDoPrania.iterator();
		while (i.hasNext()) {
			Ubranie ubranie = i.next();
			LinkedList<ElementKieszeni> kieszen = ubranie.getKieszen();
			for (ElementKieszeni element : kieszen) {
				GranatVisitor visitor = new GranatVisitor();
				element.accept(visitor);
			}
			ubranie.getKieszen().clear();
			wyjeteRzeczy.put(ubranie, kieszen);
			ubranie.setCzystosc();
			i.remove();
		}
	}
	
	// bez visitora
//	public void washAll() throws OdbezpieczonyGranatException{
//		Iterator<Ubranie> i = elementyDoPrania.iterator();
//		while (i.hasNext()) {
//			Ubranie ubranie = i.next();
//			LinkedList<ElementKieszeni> kieszen = ubranie.getKieszen();
//			for (ElementKieszeni element : kieszen) {
//				if (element instanceof Granat) {
//					if(((Granat)element).getOdbezpieczony()) {
//						System.out.println("Przerywamy pranie");
//						throw new OdbezpieczonyGranatException();
//					}
//				}
//			}
//			ubranie.getKieszen().clear();
//			wyjeteRzeczy.put(ubranie, kieszen);
//			ubranie.setCzystosc();
//			i.remove();
//		}
//	}
	
	public LinkedHashSet<Ubranie> pickUpWashedClothes(){
		LinkedHashSet<Ubranie> wyprane =  elementyWyprane; 
		elementyWyprane.clear();
		return wyprane;
	}
	
	public LinkedList<ElementKieszeni> getPocketStuffByClothes(Ubranie ubranie) {
		LinkedList<ElementKieszeni> kieszen = wyjeteRzeczy.get(ubranie);
		wyjeteRzeczy.remove(ubranie);
		return kieszen;
	}
	
	public T retriveCertificate() {
		System.out.println(certificate.toString());
		return certificate;
	}

}
