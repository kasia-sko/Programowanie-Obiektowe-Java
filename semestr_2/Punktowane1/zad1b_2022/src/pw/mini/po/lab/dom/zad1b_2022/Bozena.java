package pw.mini.po.lab.dom.zad1b_2022;
import java.util.Random;

import pw.mini.po.lab.dom.zad1b_2022_podloze.Element;
import pw.mini.po.lab.dom.zad1b_2022_podloze.Pole;

public class Bozena {
	
	public Pole pole;
	
	public Bozena() {
		this.pole = new Pole();
	}
	
	public static void destroyMines(Element tablica[][]) {
		
		Random random = new Random();
		
		int wiersz = random.nextInt(tablica.length);
//		System.out.println(wiersz);
		
		for (int i=0; i<tablica.length; i++) {
			if(tablica[wiersz][i] != null) {
				tablica[wiersz][i].pressMe();
				tablica[wiersz][i] = null;
			}
		}
	}

}
