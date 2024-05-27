package pl.pw.mini.po.dom.punktowane3.asteroidy.procesy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

import pl.pw.mini.po.dom.punktowane3.asteroidy.informacje.NiepoprawnaSrednicaException;
import pl.pw.mini.po.dom.punktowane3.asteroidy.informacje.OgolneInformacje;
import pl.pw.mini.po.dom.punktowane3.asteroidy.informacje.Orbita;
import pl.pw.mini.po.dom.punktowane3.asteroidy.informacje.Srednica;
import pl.pw.mini.po.dom.punktowane3.asteroidy.informacje.SzczegoloweInformacje;

public class AstroParser {
	
	public AstroParser() {
		
	}
	
	public static TreeSet<OgolneInformacje> parseReliableAsteroidInformation(String resourceName) throws NiepoprawnaSrednicaException{
		
		File plik = new File("from_nasa" + File.separator + resourceName);
		TreeSet<OgolneInformacje> wczytaneInformacje = new TreeSet<OgolneInformacje>(Collections.reverseOrder());

		try {
			Scanner scanner  = new Scanner(plik);
			scanner.useDelimiter("___");
			
			while(scanner.hasNextLine()) {
				System.out.println("ok");

				String line = scanner.nextLine();
				String[] parts = line.split("___");
				int id = Integer.parseInt(parts[0]);
                String nazwa = parts[1];
                Srednica srednica = new Srednica(parts[2]);
                boolean zagrozenieDlaZiemi = Boolean.parseBoolean(parts[3].toLowerCase());
                String dataBliskiegoPrzejscia = parts[4];
                double predkosc = Double.parseDouble(parts[5]);
                double dystans = Double.parseDouble(parts[6]);
                Orbita oribita = Orbita.valueOf(parts[7].toUpperCase());
                String link = parts[8];
	
//	            int id = Integer.valueOf(parts[0]);
//	            String nazwa = parts[1];
//	            Srednica srednica = new Srednica(parts[2]);
//	            boolean zagrozenieDlaZiemi = Boolean.valueOf(parts[3].toLowerCase());
//	            String dataBliskiegoPrzejscia = parts[4];
//	            double predkosc = Double.valueOf(parts[5]);
//	            double dystans = Double.valueOf(parts[6]); // valueof czy parse????
//	            Orbita oribita = Orbita.valueOf(parts[7].toUpperCase());
//	            String link = parts[8];
	            OgolneInformacje asteroida;
	            
	            if (zagrozenieDlaZiemi) {
	            	asteroida = new SzczegoloweInformacje(id, nazwa, srednica, zagrozenieDlaZiemi, dataBliskiegoPrzejscia, predkosc, dystans, oribita, link);
	            }
	            else {
	            	asteroida = new OgolneInformacje(id, nazwa, srednica);
	            }
	            System.out.println(asteroida);
	            wczytaneInformacje.add(asteroida);
			}
			scanner.close();
		}
		catch(FileNotFoundException e) {
			e.getStackTrace();
		}
		return wczytaneInformacje;
	}
	

}
