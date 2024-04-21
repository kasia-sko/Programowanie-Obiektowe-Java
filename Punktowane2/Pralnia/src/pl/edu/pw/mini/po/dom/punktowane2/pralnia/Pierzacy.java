package pl.edu.pw.mini.po.dom.punktowane2.pralnia;

import java.util.LinkedHashSet;
import java.util.LinkedList;

import pl.edu.pw.mini.po.dom.punktowane2.pralnia.ubrania.Ubranie;
import pl.edu.pw.mini.po.dom.punktowane2.pralnia.ubrania.elementyKieszeni.ElementKieszeni;
import pl.edu.pw.mini.po.dom.punktowane2.pralnia.ubrania.elementyKieszeni.OdbezpieczonyGranatException;

public interface Pierzacy {
	public LinkedHashSet<Ubranie> pickUpWashedClothes();
	public LinkedList<ElementKieszeni> getPocketStuffByClothes(Ubranie ubranie);
	public void washAll() throws OdbezpieczonyGranatException;
	public void putToWash(Ubranie ubranie);
}
