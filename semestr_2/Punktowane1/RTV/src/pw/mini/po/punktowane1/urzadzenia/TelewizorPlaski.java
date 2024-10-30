package pw.mini.po.punktowane1.urzadzenia;

import java.time.LocalDate;
import java.util.Random;


public class TelewizorPlaski extends Telewizor implements OdbieranieRozszerzone{
	
	protected Matryca matryca;
	Random random = new Random();
	
	public TelewizorPlaski(double przekatna) {
		super(przekatna);
		this.matryca = Matryca.values()[random.nextInt(3)];
	}
	
	@Override
    public String toString() {
        if(wlaczone){
            return "TelewizorPlaski{" + "nazwa=" + nazwa +
                    ", matryca='" + matryca + '\'' +
                    ", przekatna=" + przekatna +
                    ", rodzajSygnalu='" + rodzajSygnalu + '\'' +
                    ", odbieranyKanal=" + odbieranyKanal +
                    ", dataProdukcji=" + dataProdukcji.getYear() +
                    '}';
        } else return "Wyłączony";
    }
	
	@Override
	public void odbierzSygnal() {
		rodzajSygnalu = Sygnal.values()[random.nextInt(2)];
		System.out.println("Zmieniono sygnal na " + rodzajSygnalu);
		
	}

}
