package pw.mini.po.punktowane1.urzadzenia;

import java.time.LocalDate;

public abstract class Telewizor extends UrzadzeniaRTV implements Udzwiekowienie, Obrazowanie{
	
	protected double przekatna;
	protected Sygnal rodzajSygnalu;
	protected int odbieranyKanal;
	
	public Telewizor(LocalDate dataProdukcji, double przekatna, Sygnal sygnal, int kanal) {
		super(dataProdukcji);
		this.przekatna = przekatna;
		this.rodzajSygnalu = sygnal;
		this.odbieranyKanal = kanal;
		
	}

	@Override
	public void wlaczObraz() {
		System.out.println("Obraz włączony");
		
	}

	@Override
	public void wylaczObraz() {
		System.out.println("Obraz wyłączony");
		
	}

	@Override
	public void wlaczDzwiek() {
		System.out.println("Dzwięk włączony");
		
	}

	@Override
	public void wylaczDzwiek() {
		System.out.println("Dzwięk wyłączony");
		
	}
	
	

}
