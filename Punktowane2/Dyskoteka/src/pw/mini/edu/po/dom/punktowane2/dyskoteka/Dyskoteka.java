package pw.mini.edu.po.dom.punktowane2.dyskoteka;

import java.util.Iterator;
import java.util.Random;

import pw.mini.edu.po.dom.punktowane2.dyskoteka.miejsca.Hol;
import pw.mini.edu.po.dom.punktowane2.dyskoteka.miejsca.Sala;
import pw.mini.edu.po.dom.punktowane2.dyskoteka.uczestnik.Uczestnik;

public class Dyskoteka {
	
	protected static final Random random = new Random();
	protected Hol hol;
	protected Sala salaMala;
	protected Sala salaDuza;
	protected OchroniarzMaly ochroniarzMaly;
	protected OchroniarzDuzy ochroniarzDuzy;
	
	public Dyskoteka() {
		this.hol = new Hol();
		this.salaMala = new Sala(51);
		this.salaDuza = new Sala(75);
		this.ochroniarzMaly = new OchroniarzMaly(salaMala, salaDuza, hol);
		this.ochroniarzDuzy = new OchroniarzDuzy(salaMala, salaDuza, hol, new RejestrObcych());
	}

	public void inviteAll() {
		Iterator<Uczestnik> iterator = hol.getUczestnicy().iterator();
		while (iterator.hasNext()) {
			Uczestnik u = iterator.next();
			if (random.nextBoolean()) {
				System.out.println("Zaprasza ochroniarz maly");
				boolean x = ochroniarzMaly.check(u);
				if (x) {
					iterator.remove();
					
				}
			}
			else {
				System.out.println("Zaprasza ochroniarz duzy");
				boolean x = ochroniarzDuzy.check(u);
				if (x) {
					iterator.remove();
					
				}
				
			}
			
		}
	}
	
	public void goLive() {
		inviteAll();
		ochroniarzDuzy.printStrangers();
	}
}
