package pw.mini.edu.po.dom.punktowane2.dyskoteka;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import pw.mini.edu.po.dom.punktowane2.dyskoteka.uczestnik.CzlowiekZZewnatrz;

public class RejestrObcych {
	
	protected Map<String, Set<CzlowiekZZewnatrz>> rejestr;
	
	public RejestrObcych() {
		this.rejestr = new HashMap<String, Set<CzlowiekZZewnatrz>>();
	}
	
	// czy to jest ok????
//	public boolean czyDodac(CzlowiekZZewnatrz u) {
//		if (rejestr.containsKey(u.getImie())) {
//			return false;
//		}
//		return true;
//	}
	
	public boolean czyDodac(CzlowiekZZewnatrz u) {
		if (rejestr.containsValue(u)) {
			return false;
		}
		return true;
	}
	
	public void dodaj(CzlowiekZZewnatrz u) {
        String imie = u.getImie();
        System.out.println(imie);
        Set<CzlowiekZZewnatrz> set = rejestr.get(imie);
        if (set == null) {
            set = new HashSet<>();
            rejestr.put(imie, set);
        }
        set.add(u);
    }
	

}
