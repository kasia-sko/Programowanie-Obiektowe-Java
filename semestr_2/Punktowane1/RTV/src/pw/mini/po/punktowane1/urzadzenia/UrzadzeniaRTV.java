package pw.mini.po.punktowane1.urzadzenia;
import java.time.LocalDate;
import java.util.Random;

public abstract class UrzadzeniaRTV implements Odbieranie{
	
	protected LocalDate dataProdukcji;
	protected final String nazwa;
	protected int iloscWlaczen;
	protected boolean wlaczone;
	protected static String nazwaBezNr = stworzNazwe();
	protected static int nrSeryjny;
		
	public UrzadzeniaRTV() {
		Random random = new Random();
		int year = random.nextInt(1999,2023);
		int day = random.nextInt(366);
		this.dataProdukcji = LocalDate.ofYearDay(year, day);
		this.wlaczone = false;
		this.iloscWlaczen = random.nextInt(3,8);
		this.nazwa = nazwaBezNr + String.valueOf(nrSeryjny++);
	}
	
	protected static String stworzNazwe() {
		Random random = new Random();
		String losowaNazwa = "";
		for (int i = 0; i<6; i++) {
			if (i<=4) {
				losowaNazwa += (char)(random.nextInt(26)+65);
			}
			else {
				losowaNazwa += "_";
			}
		}
		return losowaNazwa;
		
	}
	public abstract void wlacz();
	public abstract void wylacz();
	
	public void napraw() {
		Random random = new Random();
		if(iloscWlaczen == 0) {
			System.out.println("Naprawione");
			iloscWlaczen = random.nextInt(3,8);
			
		}
	}
	

}
