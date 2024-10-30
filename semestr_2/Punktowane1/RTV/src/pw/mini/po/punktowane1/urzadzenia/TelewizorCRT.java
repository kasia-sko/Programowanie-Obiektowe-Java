package pw.mini.po.punktowane1.urzadzenia;

import java.time.LocalDate;

public class TelewizorCRT extends Telewizor {
	
	protected Kolor kolor;
	
	public TelewizorCRT(double przekatna, Kolor kolor) {
		super(przekatna);
		this.kolor = kolor;
	
	}

	@Override
	public void napraw() {
		if(iloscWlaczen == 0) {
			System.out.println("Popsuty na stałe");
		} else {
			super.napraw();
		}
	}
	
	@Override
	public void wybierzKanal(int i) {
		System.out.println("Brak sygnału analogowego");
		odbieranyKanal = 0;
	}
	
	
	@Override
	public String toString() {
		if (wlaczone) {
			return "TelewizorCRT: nazwa: " + nazwa +
					", kolor= " + kolor +
					", przekatna= " + przekatna +
					", rodzaj sygnału: " + rodzajSygnalu +
					", odbierany kanal= " + odbieranyKanal +
					", data produkcji: " + dataProdukcji.getYear();
		} else {
			return "Wyłączony";
		}
	}
	
	
	
}
