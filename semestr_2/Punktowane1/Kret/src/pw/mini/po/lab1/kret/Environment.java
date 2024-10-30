package pw.mini.po.lab1.kret;

import pw.mini.po.lab1.kret.obiektyZiemi.Dzdzownica;
import pw.mini.po.lab1.kret.obiektyZiemi.Gleba;
import pw.mini.po.lab1.kret.obiektyZiemi.Larwa;
import pw.mini.po.lab1.kret.obiektyZiemi.ObiektyZiemi;
import java.util.Random;

public class Environment {
	
	protected ObiektyZiemi[][] tablica;
	protected static int wartoscOdzywczaDzdzownicy = 3;
	protected MoleMotion kret;
	
	public Environment(int m, int n, int iloscLarw, int iloscDzdzownic) {
		
		Random random = new Random();
		this.tablica = new ObiektyZiemi[m][n];
		
		int i =0;
		while (i<iloscDzdzownic) {
			int x = random.nextInt(tablica.length);
			int y = random.nextInt(tablica[1].length);
			if (tablica[x][y] == null) {
				tablica[x][y] = new Dzdzownica(wartoscOdzywczaDzdzownicy);
				i++;
				
			}
			
		}
		
		int j =0;
		while (j<iloscLarw) {
			int x = random.nextInt(tablica.length);
			int y = random.nextInt(tablica[1].length);
			if (tablica[x][y] == null) {
				tablica[x][y] = new Larwa(random.nextInt(3,6));
				j++;
				
			}
			
		}
		
		for (int a=0; a<tablica.length; a++) {
			for (int b=0; b<tablica[1].length; b++) {
				if (tablica[a][b] == null) {
					tablica[a][b] = new Gleba(0);
				}
			}
		}
	}
	
	public Environment(int m, int n, int iloscLarw, int iloscDzdzownic, Gatunek gatunek) {
		this(m, n, iloscLarw, iloscDzdzownic);
		this.kret = new Kret(gatunek, tablica);
	}
		
	public void wypiszTablice() {
		System.out.println("Schemat tablicy:");
		for (int i=0; i<tablica.length; i++) {
			for (int j=0; j<tablica[1].length; j++) {
				if (tablica[i][j] != null) {
					System.out.print(tablica[i][j]);
			
			}
				else {
					System.out.print(" ");
				}
		}
			System.out.println();
	}
		
	}
	
	public void runMole() {
		for (int i=0; i<10; i++) {
			kret.goMole();
			wypiszTablice();
		}
	}

}
