package pl.edu.pw.mini.po.grzybobranie;
import java.util.Random;

public class Las {
	
	Random random = new Random();
	
	public Muchomor[][] tablica;
	
	public Las(int x, int y) {
		
		if (x<=0) {
			x=100;
		}
		if (y<=0) {
			y=100;
		}
		tablica = new Muchomor[x][y];
		
		int wiersz = random.nextInt(tablica.length);
		for (int i=0; i<tablica.length; i++) {
			if(i==wiersz) {
				continue;
			}
			else {
				for (int j=0; j<tablica[i].length; j++) {
				int p = random.nextInt(100);
				if (p<5) {
					tablica[i][j] = new MuchomorCesarski();
				}
				else if (p<10) {
					tablica[i][j] = new MuchomorKolczastoglowy();
				}
				else if (p<15) {
					tablica[i][j] = new MuchomorSromotnikowy();
				}
				else if (p<20) {
					tablica[i][j] = new MuchomorSzarawy();
				}
				else {
					tablica[i][j] = null;
				}
				}
		}
	}
	}
	
	public Object zwrocGrzyba() {
		int x = random.nextInt(tablica.length);
		int y = random.nextInt(tablica[x].length);
		if(tablica[x][y] != null) {
			Muchomor grzyb = tablica[x][y];
			tablica[x][y] = null;
			return grzyb;
		}
		else {
			return null;
		}
				
	}
}
