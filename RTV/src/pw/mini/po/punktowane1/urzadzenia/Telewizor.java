package pw.mini.po.punktowane1.urzadzenia;

import java.time.LocalDate;
import java.util.Random;

public abstract class Telewizor extends UrzadzeniaRTV implements Udzwiekowienie, Obrazowanie{
	
	protected double przekatna;
	protected Sygnal rodzajSygnalu;
	protected int odbieranyKanal;
	
	public Telewizor(double przekatna) {
		super();
		this.przekatna = przekatna;
		this.rodzajSygnalu = Sygnal.ANALOGOWY;
		
	}


	public abstract String toString();
	
	@Override
	public void wlacz() {
		if(wlaczone) {
			System.out.println("Jest już włączone");
		}
		else if(iloscWlaczen == 0){
			System.out.println("Urządzenie zepsute, spróbuj je naprawić");
		}
		else {
			wlaczone = true;
			wlaczDzwiek();
			wlaczObraz();
			iloscWlaczen--;
			}
	}
	
	@Override
	public void wylacz() {
		if (wlaczone) {
			wylaczDzwiek();
			wylaczObraz();
			wlaczone = false;
		}
		else {
			System.out.println("Urządzenie jest już wyłączone");
		}
	}

	@Override
	public void wybierzKanal(int i) {
		odbieranyKanal = i;
		
	}
	
	
	

}
