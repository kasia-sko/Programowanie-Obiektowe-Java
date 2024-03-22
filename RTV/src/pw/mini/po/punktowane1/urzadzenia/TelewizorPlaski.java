package pw.mini.po.punktowane1.urzadzenia;

import java.time.LocalDate;

public class TelewizorPlaski extends Telewizor implements OdbieranieRozszerzone{
	
	protected Matryca matryca;
	
	public TelewizorPlaski(LocalDate dataProdukcji, double przekatna, Sygnal sygnal, int kanal, Matryca matryca) {
		super(dataProdukcji, przekatna, sygnal, kanal);
		this.matryca = matryca;

	}
	
	@Override
	public void odbierzSygnal() {
		
	}
	
	@Override
	public void wlaczObraz() {
		
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
	public void wylaczObraz() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void zakres() {
		// TODO Auto-generated method stub
		
	}

}
