package pw.mini.po.punktowane1.urzadzenia;

import java.time.LocalDate;
import java.util.Random;

public final class Radio extends UrzadzeniaRTV implements Udzwiekowienie{
	
	protected Czestotliwosc czestotliwosc;
	Random random = new Random();
	
	public Radio() {
		super();
		this.czestotliwosc = Czestotliwosc.values()[random.nextInt(4)];
	}

	@Override
    public void wybierzKanal(int i) {
        if (i>=1000 && i <20000){
            czestotliwosc = Czestotliwosc.values()[0];
        } else if (i>=200 && i<1000) {
            czestotliwosc = Czestotliwosc.values()[1];
        } else if (i>=10 && i<200) {
            czestotliwosc = Czestotliwosc.values()[2];
        } else if (i>=1 && i <10){
            czestotliwosc = Czestotliwosc.values()[2];
        }
        System.out.println("Wybrałeś fale: "+czestotliwosc);

    }
	
	@Override
    public void wlacz() {
        if (iloscWlaczen == 0){
            System.out.println("Urządzenie jest zepsute, spróbuj naprawić");
        } else {
            wlaczone = true;
            wlaczDzwiek();
            iloscWlaczen = iloscWlaczen-1;
        }
    }

    @Override
    public void wylacz() {
        if (wlaczone){
            wylaczDzwiek();
            wlaczone = false;
        } else System.out.println("Już jest wyłączone");
    }

	

}
