package pl.edu.pw.mini.po.dom.punktowane2.pralnia;

import java.util.ArrayList;

public class Swiat {
	
	public void goLive() {
		Certificate certificate = new Certificate();
		Pralnia<Certificate> pralnia= new Pralnia<>(certificate);
		ArrayList<Klient> klienci= new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			klienci.add(new Klient(pralnia));
		}
		for (Klient klient : klienci) {
			klient.doJob();
		}
	}

}
