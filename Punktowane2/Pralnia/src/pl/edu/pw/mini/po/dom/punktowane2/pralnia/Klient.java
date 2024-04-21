package pl.edu.pw.mini.po.dom.punktowane2.pralnia;

import pl.edu.pw.mini.po.dom.punktowane2.pralnia.ubrania.Koszula;
import pl.edu.pw.mini.po.dom.punktowane2.pralnia.ubrania.Kufajka;
import pl.edu.pw.mini.po.dom.punktowane2.pralnia.ubrania.Plaszcz;
import pl.edu.pw.mini.po.dom.punktowane2.pralnia.ubrania.Ubranie;
import pl.edu.pw.mini.po.dom.punktowane2.pralnia.ubrania.elementyKieszeni.OdbezpieczonyGranatException;

public class Klient {
	private Pierzacy pralnia;
	
	public Klient(Pierzacy pralnia) {
		this.pralnia = pralnia;
	}
	
	public void doJob() {
		Ubranie koszula = new Koszula();
		Ubranie plaszcz = new Plaszcz();
		Ubranie kufajka = new Kufajka();
		pralnia.putToWash(kufajka);
		pralnia.putToWash(plaszcz);
		pralnia.putToWash(koszula);
		try{
			pralnia.washAll();
		}
		catch (OdbezpieczonyGranatException e) {
			System.out.println(e.getMessage());
		}
		pralnia.pickUpWashedClothes();
		pralnia.getPocketStuffByClothes(kufajka);
		pralnia.getPocketStuffByClothes(plaszcz);
		pralnia.getPocketStuffByClothes(koszula);

	}


}
