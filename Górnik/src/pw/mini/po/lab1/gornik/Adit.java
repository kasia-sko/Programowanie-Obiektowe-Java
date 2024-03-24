package pw.mini.po.lab1.gornik;

import java.util.Random;

public class Adit {
	
	private ObiektyKopalne[][] kopalnia;
	static Random random = new Random();
	private Górnik gornik;
	
	public Adit(int maksDystans, int dlugoscKorytarzy, int iloscKorytarzy) {
		int dlugoscSzybu = (maksDystans + 1)*iloscKorytarzy;
		this.kopalnia = new ObiektyKopalne[dlugoscSzybu][];
		int i = 0;
		int licznikPoziomu = 0;
		while (i<iloscKorytarzy){
			int p = random.nextInt(maksDystans + 1);
			licznikPoziomu += p;
			kopalnia[licznikPoziomu] = new ObiektyKopalne[dlugoscKorytarzy];
			for (int j=0; j<dlugoscKorytarzy; j++) {
				int x = random.nextInt(100);
				if(x < 10) {
					kopalnia[licznikPoziomu][j] = new Uraninit(50);
				}
				else if (x<30) {
					kopalnia[licznikPoziomu][j] = new Chalkolit(50);

				}
				else {
					kopalnia[licznikPoziomu][j] = new Skała();

				}
			}
			i++;
	}
		this.gornik = new Górnik(kopalnia);

}
	
	
//	public Adit(int maksDystans, int dlugoscKorytarzy, int iloscKorytarzy) {
//		this(maksDystans, dlugoscKorytarzy, iloscKorytarzy);
//		this.gornik = new Górnik(kopalnia);
//	}
	
	
	protected void wypiszKopalnie() {
		for (int i=0; i<kopalnia.length; i++) {
			if (kopalnia[i] == null) {
				System.out.print(" ");
			}
			else {
				System.out.print("->");
				for (int j=1; j<kopalnia[i].length; j++) {
					if (kopalnia[i][j] == null) {
						System.out.print(" ");
					}
					else {
						System.out.print(kopalnia[i][j]);
					}
				}
			}
			System.out.println();
		}
		
	}
	
	public void runAdit() {
		gornik.goMiner();
		System.out.println("Income: " + gornik.getIncome());
	}
}