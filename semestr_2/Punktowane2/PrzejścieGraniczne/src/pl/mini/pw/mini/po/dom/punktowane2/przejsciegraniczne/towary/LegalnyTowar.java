package pl.mini.pw.mini.po.dom.punktowane2.przejsciegraniczne.towary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LegalnyTowar extends Towar{
	
	private static List<String> zestawTowarow = new ArrayList<>(Arrays.asList("woda", "kanapka", "laptop", "zasilacz", "mysz", "książka"));
	

	public LegalnyTowar() {
		this.nazwa = zestawTowarow.get(random.nextInt(zestawTowarow.size()));
	}

}
