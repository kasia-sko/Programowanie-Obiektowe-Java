package pl.mini.pw.mini.po.dom.punktowane2.przejsciegraniczne.towary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class TrefnyTowar extends Towar{
	
	private int wartoscCzarnorynkowa;
	private Map<String, ArrayList<Integer>> zestawTowarow = stworzZestawTowarow(); // jakies enumy nie wiem????
	
	public TrefnyTowar() {
		this.nazwa = getRandomName();
		this.wartoscCzarnorynkowa = zestawTowarow.get(nazwa).get(random.nextInt(zestawTowarow.get(nazwa).size()));
	}
	
	private Map<String, ArrayList<Integer>> stworzZestawTowarow(){
        Map<String, ArrayList<Integer>> map = new HashMap<>();
		map.put("broń", new ArrayList<>(Arrays.asList(15000,12000)));
		map.put("alkohol bez banderoli", new ArrayList<>(Arrays.asList(700,750,800)));
		map.put("bursztyn", new ArrayList<>(Arrays.asList(35000)));
		map.put("łopatka wieprzowa", new ArrayList<>(Arrays.asList(1450,1350)));
		return map;
		
	}
	
	public int getWartoscCzarnorynkowa() {
		return wartoscCzarnorynkowa;
	}
	
	private String getRandomName() {
        Set<String> klucze = zestawTowarow.keySet();
        String[] kluczeArray = klucze.toArray(new String[0]); // konwersja zbioru na tablicę typu String[]
        return kluczeArray[random.nextInt(klucze.size())];

	}
	
	public void printMe() {
		for(String key : zestawTowarow.keySet()) {
			System.out.println(key);
		}
	}
//		Set<Entry<String, ArrayList<Integer>>> entrySet = zestawTowarow.entrySet();
//		for(Entry<String, ArrayList<Integer>> entry : entrySet ) {
//			System.out.println(entry.getKey() + " " + entry.getValue());
//		}
	

}
