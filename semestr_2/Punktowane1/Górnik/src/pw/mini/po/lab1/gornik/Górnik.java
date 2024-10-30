package pw.mini.po.lab1.gornik;

public class Górnik {
	
	private int income;
	private ObiektyKopalne[][] tab;
	
	public Górnik(ObiektyKopalne[][] tab) {
		this.tab = tab;
	}
	
	public void goMiner() {
		for (int i=0; i<tab.length; i++) {
			if (tab[i] != null) {
				for(int j=1; j<tab[i].length; j++) {
					if (tab[i][j] != null) {
						income += tab[i][j].getModifiedMarketValue();
						tab[i][j] = null;
					}
			}}
		}
		
	}
	
	public int getIncome() {
		return income;
	}

}
