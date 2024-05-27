package pl.pw.mini.po.dom.punktowane3.kebaby.parser;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import pl.pw.mini.po.dom.punktowane3.kebaby.Kebab;
import pl.pw.mini.po.dom.punktowane3.kebaby.KebabCiasto;
import pl.pw.mini.po.dom.punktowane3.kebaby.KebabTalerz;
import pl.pw.mini.po.dom.punktowane3.kebaby.wartosci.Dodatek;
import pl.pw.mini.po.dom.punktowane3.kebaby.wartosci.GrubeCiasto;
import pl.pw.mini.po.dom.punktowane3.kebaby.wartosci.Mieso;
import pl.pw.mini.po.dom.punktowane3.kebaby.wartosci.Rozmiar;

public class KebabParser {
	
	public static ArrayList<Kebab> parseKebabs(String nazwa) throws NieznanyRodzajMiesa {
		ArrayList<Kebab> kebaby = new ArrayList<>();
		File file = new File("resources" + File.separator + nazwa);
		
		try {
			Scanner scanner = new Scanner(file);
			scanner.useDelimiter("---");
			
			while(scanner.hasNextLine() & scanner.hasNext()) {
				String rozmiarS = scanner.next().trim();
				//System.out.println(rozmiarS);
				Rozmiar rozmiar = Rozmiar.valueOf(rozmiarS);
				//Rozmiar rozmiar = Rozmiar.valueOf(scanner.next());
				if(scanner.hasNext("yes") | scanner.hasNext("no")) {
					kebaby.add(parseKebabCiasto(scanner, rozmiar));
					//System.out.println("ok");
				}
				else {
					kebaby.add(parseKebabTalerz(scanner, rozmiar));
				}
				
			}
			scanner.close();
			
		}
		catch( FileNotFoundException e) {
			e.printStackTrace();
		}
		return kebaby;
	}
	
	private static Kebab parseKebabCiasto(Scanner scanner, Rozmiar rozmiar) throws NieznanyRodzajMiesa {
		GrubeCiasto grubeCiasto = GrubeCiasto.valueOf(scanner.next());
		Mieso mieso = null;
		if(scanner.hasNext("kurczak") | scanner.hasNext("wolowina") | scanner.hasNext("mix")) {
			mieso = Mieso.valueOf(scanner.next());
		}
		else {
			throw new NieznanyRodzajMiesa();
		}
		int waga = scanner.nextInt();
		double cena = scanner.nextDouble();
		Kebab kebab = new KebabCiasto(rozmiar, waga, mieso, cena, grubeCiasto);
		return kebab;
	}

	private static Kebab parseKebabTalerz(Scanner scanner, Rozmiar rozmiar) throws NieznanyRodzajMiesa {
		Dodatek dodatek = Dodatek.valueOf(scanner.next());
		Mieso mieso = null;
		if(scanner.hasNext("kurczak") | scanner.hasNext("wolowina") | scanner.hasNext("mix")) {
			mieso = Mieso.valueOf(scanner.next());
		}
		else {
			throw new NieznanyRodzajMiesa();
		}
		int waga = scanner.nextInt();
		boolean naWynos = scanner.nextBoolean();
		double cena = scanner.nextDouble();
		Kebab kebab = new KebabTalerz(rozmiar, waga, mieso, cena, dodatek, naWynos);
		return kebab;
	}
}
