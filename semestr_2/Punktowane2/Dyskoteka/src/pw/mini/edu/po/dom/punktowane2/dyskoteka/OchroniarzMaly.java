package pw.mini.edu.po.dom.punktowane2.dyskoteka;

import java.util.Random;

import pw.mini.edu.po.dom.punktowane2.dyskoteka.miejsca.Hol;
import pw.mini.edu.po.dom.punktowane2.dyskoteka.miejsca.Sala;
import pw.mini.edu.po.dom.punktowane2.dyskoteka.uczestnik.Uczestnik;

public class OchroniarzMaly {
	
	protected static final Random random = new Random();
	protected Sala salaMala;
	protected Sala salaDuza;
	protected Hol hol;
	
	public OchroniarzMaly(Sala salaMala, Sala salaDuza, Hol hol) {
		this.salaDuza = salaDuza;
		this.salaMala = salaMala;
		this.hol = hol;
	}

	public boolean check(Uczestnik u) {
        if (u.getWiek() > 18) {
            if (random.nextBoolean()) {
                try {
                    salaMala.dodajUczestnika(u);
                    return true;
                } catch (PrzekroczonaPojemnoscException p) {
                    System.out.println(p.getMessage());
                    return false;
                }
            } else {
                try {
                    salaDuza.dodajUczestnika(u);
                    return true;
                } catch (PrzekroczonaPojemnoscException p) {
                    System.out.println(p.getMessage());
                    return false;
                }
            }
        } else {
            return false;
        }

    }
}
