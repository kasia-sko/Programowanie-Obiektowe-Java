package pw.mini.po.punktowane1.urzadzenia;

import java.time.LocalDate;

public final class Radio extends UrzadzeniaRTV implements Udzwiekowienie{
	
	protected Czestotliwosc czestotliwosc;
	
	public Radio(LocalDate dataProdukcji, Czestotliwosc czestotliwosc) {
		super(dataProdukcji);
		this.czestotliwosc = czestotliwosc;
		
	}

	@Override
	public void wlaczDzwiek() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void wylaczDzwiek() {
		// TODO Auto-generated method stub
		
	}

}
