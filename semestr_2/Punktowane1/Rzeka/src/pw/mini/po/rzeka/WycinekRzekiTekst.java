package pw.mini.po.rzeka;

public class WycinekRzekiTekst extends WycinekRzeki{
	
	public WycinekRzekiTekst(int szerokosc, int dlugosc) {
		super(szerokosc, dlugosc);
	}
	
	@Override
	public void moveAll() {
		super.moveAll();
		System.out.println("Prezentacja rzeki:");
		for (int i=0; i<tablica.length; i++) {
			for (int j=0; j<tablica[1].length; j++) {
				if (tablica[i][j] == null) {
					System.out.print(" ");
				}
				else {
					System.out.print(tablica[i][j]);
				}
			}
			System.out.println();
		}
	}

}
