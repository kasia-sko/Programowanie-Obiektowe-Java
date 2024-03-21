package pw.mini.po.lab.dom.zad1b_2022;

public class Demonstrator {

	public static void main(String[] args) {
		
		Bozena bozena = new Bozena();
		
		System.out.println("Testujemy bozene");
		
//		bozena.pole.wypisz_pole();
//		Bozena.destroyMines(bozena.pole.tab);
//		bozena.pole.wypisz_pole();

		for(int i=0; i<50; i++) {
			Bozena.destroyMines(bozena.pole.tab);
			System.out.println();
		}

	}

}
