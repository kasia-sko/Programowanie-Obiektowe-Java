package pw.mini.po.lab1.kret;
import java.util.Random;

import pw.mini.po.lab1.kret.obiektyZiemi.ObiektyZiemi;

public class Kret implements MoleMotion{
	
	private Gatunek gatunek;
	private int wartoscOdzywcza;
	private ObiektyZiemi[][] tablica;
	Random random = new Random();

	
	public Kret(Gatunek gatunek, ObiektyZiemi[][] tablica) {
		this.tablica = tablica;
		this.gatunek = gatunek;
		this.wartoscOdzywcza = random.nextInt(200,241);
	}

	@Override
	public void goMole() {
		int x = random.nextInt(tablica.length);
		int y = random.nextInt(tablica[1].length);
		if (tablica[x][y] != null) {
			wartoscOdzywcza += tablica[x][y].getWartoscOdzywcza();
			System.out.println("Mniam! Obiekt: " + tablica[x][y] +" Wartosc odzywcza: " + tablica[x][y].getWartoscOdzywcza() + " Lokalizacja: (" + x + ", " + y +")");
			tablica[x][y] = null;
		}
		else {
			System.out.println("Pusto :(");
		}
		
	}

	@Override
	public String getNutritionalValue() {
		String s = "" + wartoscOdzywcza;
		return s;
	}
	

}
