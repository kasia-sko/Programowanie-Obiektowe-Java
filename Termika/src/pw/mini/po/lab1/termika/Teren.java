package pw.mini.po.lab1.termika;
import java.util.Random;

public class Teren {
	
	private KomorkiTerenowe[][] teren;
	public Random random = new Random();
	
	public Teren(int x, int y) {
		
		if (x<=0) {
			x=100;
		}
		if (y<=0) {
			y=100;
		}
		this.teren = new KomorkiTerenowe[x][y];
		for (int i=0; i<teren.length; i++) {
			for (int j=0; j<teren[1].length; j++) {
				int p = random.nextInt(5);
				switch(p) {
				case 0:
					teren[i][j] = new Piasek(random.nextInt(10,20));
					break;
				case 1:
					teren[i][j] = new GlebaKamienista(random.nextInt(2,10));
					break;
				case 2:
					teren[i][j] = new GlebaNiekamienista(random.nextInt(3,15));
					break;
				case 3:
					teren[i][j] = new PodmoklaLaka(random.nextInt(8));
					break;
				case 4:
					teren[i][j] = new TerenWodny(random.nextInt(-5,5));
		}
		}
			}
	}
		
		
	public void modyfikujAtmosfere() {
		for (int i=0; i<teren.length; i++) {
			for (int j=0; j<teren[i].length; j++) {
				teren[i][j].modyfikujTemperature(random.nextInt(1,4));
			}
		
		
		
	}

}
	public KomorkiTerenowe[][] getTeren(){
		return teren;
	}
	}
