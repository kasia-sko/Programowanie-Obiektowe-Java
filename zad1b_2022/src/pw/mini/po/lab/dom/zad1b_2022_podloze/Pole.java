package pw.mini.po.lab.dom.zad1b_2022_podloze;
import java.util.Random;

import pw.mini.po.lab.dom.zad1b_2022_podloze_miny.Mina;
import pw.mini.po.lab.dom.zad1b_2022_podloze_miny.MinaPrzeciwczołgowa;
import pw.mini.po.lab.dom.zad1b_2022_podloze_miny.MinaPrzeciwpiechotna;
import pw.mini.po.lab.dom.zad1b_2022_podloze_rosliny.Purchawka;
import pw.mini.po.lab.dom.zad1b_2022_podloze_rosliny.Trawa;

public class Pole {
	
	public Element[][] tab;
	Random losowanie = new Random();
	
	public Pole() {
		
		tab = new Element[100][100];
		
		for(int i=0; i<tab.length; i++) {
			for(int j=0; j<tab.length; j++) {
				if(losowanie.nextInt()<= 5) {
					tab[i][j] = null;
				}
				else {
					int x = losowanie.nextInt(4);
					if(x==0) {
						tab[i][j] = new Trawa();
					}
					else if(x==1) {
						tab[i][j] = new Purchawka();
					}
					else {
						if(x==2) {
							tab[i][j] = new MinaPrzeciwczołgowa();
						}
						else if(x==3) {
							tab[i][j] = new MinaPrzeciwpiechotna();
						}
						int y = losowanie.nextInt(10);
						if (y!=9) {
							((Mina)tab[i][j]).armMe();
						}
							
						}
				}
				
			}
		}
		
	}
	
	public void wypisz_pole() {
		for(int i = 0; i<tab.length; i++) {
			for(int j=0; j<tab.length; j++) {
				System.out.print(tab[i][j] + " ");
			}
			System.out.println();
		}
	}
	
} 
