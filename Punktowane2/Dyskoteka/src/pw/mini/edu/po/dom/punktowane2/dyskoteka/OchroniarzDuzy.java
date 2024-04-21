package pw.mini.edu.po.dom.punktowane2.dyskoteka;

import java.util.Map;
import java.util.Set;

import pw.mini.edu.po.dom.punktowane2.dyskoteka.miejsca.Hol;
import pw.mini.edu.po.dom.punktowane2.dyskoteka.miejsca.Sala;
import pw.mini.edu.po.dom.punktowane2.dyskoteka.uczestnik.Uczestnik;
import pw.mini.edu.po.dom.punktowane2.dyskoteka.uczestnik.UczestnikVisitor;

public class OchroniarzDuzy extends OchroniarzMaly{
	
	protected RejestrObcych rejestr;

	public OchroniarzDuzy(Sala salaMala, Sala salaDuza, Hol hol, RejestrObcych rejestr) {
		super(salaDuza, salaMala, hol);
		this.rejestr = rejestr;
	}
	
	@Override
	public boolean check(Uczestnik u) {
		if (u.getWiek() > 18) {
            if (random.nextBoolean()) {
                try {
                    salaMala.dodajUczestnika(u);
                    UczestnikVisitor visitor = new UczestnikVisitor(rejestr);
                    u.accept(visitor);
                    return true;
                } catch (PrzekroczonaPojemnoscException p) {
                    System.out.println(p.getMessage());
                    return false;
                }
            } else {
                try {
                    salaDuza.dodajUczestnika(u);
                    UczestnikVisitor visitor = new UczestnikVisitor(rejestr);
                    u.accept(visitor);
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
	
	// wersja bez visitora
//	@Override
//	public boolean check(Uczestnik u) {
//		if (u.getWiek() > 18) {
//            if (random.nextBoolean()) {
//                try {
//                    salaMala.dodajUczestnika(u);
//                    if (u instanceof CzlowiekZZewnatrz) {
//            			CzlowiekZZewnatrz c = (CzlowiekZZewnatrz)u;
//            			if(rejestr.czyDodac(c)) {
//            				rejestr.dodaj(c);
//            			}
//            		}
//                    return true;
//                } catch (PrzekroczonaPojemnoscException p) {
//                    System.out.println(p.getMessage());
//                    return false;
//                }
//            } else {
//                try {
//                    salaDuza.dodajUczestnika(u);
//                    if (u instanceof CzlowiekZZewnatrz) {
//            			CzlowiekZZewnatrz c = (CzlowiekZZewnatrz)u;
//            			if(rejestr.czyDodac(c)) {
//            				rejestr.dodaj(c);
//            			}
//            		}
//                    return true;
//                } catch (PrzekroczonaPojemnoscException p) {
//                    System.out.println(p.getMessage());
//                    return false;
//                }
//            }
//        } else {
//            return false;
//        }
//    }
	
	public void printStrangers() {
		System.out.println(rejestr.rejestr);
	}

}
