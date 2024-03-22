package pw.mini.po.punktowane1.urzadzenia;

import java.time.LocalDate;
import java.util.Random;

public abstract class UrzadzeniaRTV {
	
	protected LocalDate dataProdukcji;
	protected String nazwa;
	protected int iloscWlaczen;
	protected boolean wlaczone;
	
	Random random = new Random();
	
	public UrzadzeniaRTV(LocalDate dataProdukcji) {
		this.dataProdukcji = dataProdukcji;
		this.wlaczone = false;
		this.iloscWlaczen = random.nextInt(4) + 3;
		
	}
	
	public boolean isWlaczone() {
		return wlaczone;
	}
	

}
