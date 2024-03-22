package pw.mini.po.punktowane1.urzadzenia;

import java.time.LocalDate;

public class TelewizorCRT extends Telewizor {
	
	protected Kolor kolor;
	
	public TelewizorCRT(LocalDate dataProdukcji, double przekatna, Sygnal sygnal, int kanal, Kolor kolor) {
		super(dataProdukcji, przekatna, sygnal, kanal);
		this.rodzajSygnalu = Sygnal.ANALOGOWY;
		

	}

	@Override
	public void wlaczDzwiek() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void wylaczDzwiek() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void wlaczObraz() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void wylaczObraz() {
		// TODO Auto-generated method stub
		
	}
	

}
