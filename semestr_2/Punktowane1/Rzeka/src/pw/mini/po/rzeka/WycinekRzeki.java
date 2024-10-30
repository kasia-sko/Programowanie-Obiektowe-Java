package pw.mini.po.rzeka;
import java.util.Random;

public class WycinekRzeki {
	
	protected Suweniry[][] tablica;
	Random random = new Random();
	
	public WycinekRzeki(int szerokosc, int dlugosc) {
		if (szerokosc >=1 && szerokosc <= 100 && dlugosc >=1 && dlugosc <= 100) {
			this.tablica = new Suweniry[szerokosc][dlugosc];
			for (int i=0; i<szerokosc; i++) {
				for (int j=0; j<dlugosc; j++) {
					int x = random.nextInt(50);
					switch(x) {
						case 1:
							tablica[i][j] = new Moneta();
							break;
						case 2:
							tablica[i][j] = new But();
							break;
						case 3:
							tablica[i][j] = new Butelka();	
							break;
						case 4:
							tablica[i][j] = new Zegarek();
							break;
						case 5:
							tablica[i][j] = new ZegarekPodwodny();
							break;
						default:
							tablica[i][j] = null;
			}
		}
		
	}
		}}
	
//	public void wypiszRzeke() {
//		System.out.println("Prezentacja rzeki:");
//		for (int i=0; i<tablica.length; i++) {
//			for (int j=0; j<tablica[1].length; j++) {
//				if (tablica[i][j] == null) {
//					System.out.print("n");
//				}
//				else {
//					System.out.print(tablica[i][j]);
//				}
//			}
//			System.out.println();
//		}
//		
//	}
	
	public void moveAll() {
		for (int i=0; i<tablica.length; i++) {
			for (int j=0; j<tablica[1].length; j++) {
				if (tablica[i][j] != null) {
					int x = tablica[i][j].distance();
					if (x + j >= tablica[1].length) {
						tablica[i][j] = null;
					} else if(tablica[i][j + x] == null) {
						tablica[i][j + x] = tablica[i][j];
						tablica[i][j] = null;
				}
			}
		}
	}}
}
