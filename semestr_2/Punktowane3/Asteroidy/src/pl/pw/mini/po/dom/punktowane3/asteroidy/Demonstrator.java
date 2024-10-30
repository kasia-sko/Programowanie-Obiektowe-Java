package pl.pw.mini.po.dom.punktowane3.asteroidy;

import java.util.TreeSet;

import pl.pw.mini.po.dom.punktowane3.asteroidy.informacje.NiepoprawnaSrednicaException;
import pl.pw.mini.po.dom.punktowane3.asteroidy.informacje.OgolneInformacje;
import pl.pw.mini.po.dom.punktowane3.asteroidy.procesy.AsteroidProcessor;
import pl.pw.mini.po.dom.punktowane3.asteroidy.procesy.AstroParser;

public class Demonstrator {

	public static void main(String[] args) {

		try {
			TreeSet<OgolneInformacje> asteroidy = AstroParser.parseReliableAsteroidInformation("/asteroidy.txt");
			AsteroidProcessor procesor = new AsteroidProcessor();
			System.out.println(asteroidy);
			TreeSet<OgolneInformacje> niebezpieczneAsteroidy = procesor.getDangerousAsteroidsOnly(asteroidy);
			System.out.println(niebezpieczneAsteroidy);
			
		
		}
		catch(NiepoprawnaSrednicaException e) {
			e.getMessage();
		}
	}

}
