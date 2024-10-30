package pl.pw.mini.po.dom.punktowane3.odloty;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FlightParser {
	
	public FlightParser() {
	}
	
public ArrayList<Lot> parseFlights(String filePath) throws IOException{
	ArrayList<Lot> loty = new ArrayList<>();
	String path = filePath;
	
	try(BufferedReader reader = new BufferedReader(new FileReader(path))){
		String line; // !!!! ważne żeby dwa razy readline nie robić bo dostane co druga linijke
		while((line = reader.readLine())!= null) {
			//System.out.println(line);
			Lot lot = tworcaLotu(line);
			loty.add(lot);
			//System.out.println(lot);
		}
	}
	catch(NiepoprawnyCheckInException e) {
		System.out.println(e.getMessage());
	}
	return loty;
}

private Lot tworcaLotu(String line) throws NiepoprawnyCheckInException{
	String string = line;
	Scanner scanner = new Scanner(string);
	scanner.useDelimiter("###");
	Lot lot = null;
	if (scanner.hasNext()) {
		//System.out.println("ok");
		String typ = scanner.next();
		//System.out.println("typ " + typ);
		String godzina = scanner.next();
		//System.out.println("godzina" +godzina);
		String miejsce = scanner.next();
		//System.out.println("miejsce" + miejsce);
		String idLotu = scanner.next();
		//System.out.println("id" + idLotu);
		String linia = scanner.next();
		//System.out.println("linia" +linia);
		if (typ.equals("O")) {
			//System.out.println("ooooo");
			Status status = Status.valueOf(scanner.next());
			//System.out.println(status);
			String checkIn = scanner.next();
			sprawdzCheckIn(checkIn);
			lot = new Odlot(godzina, idLotu, miejsce, linia, status, checkIn);
			//System.out.println(lot);

		}
		else if (typ.equals("P")){
			//System.out.println("pppppp");
			boolean wyladowal = scanner.nextBoolean();
			int nrWyjscia = scanner.nextInt();
			lot = new Przylot(godzina, idLotu, miejsce, linia, wyladowal, nrWyjscia);
			//System.out.println(lot);
			
		}
		
	}scanner.close();
	return lot;
}

private void sprawdzCheckIn(String checkIn) throws NiepoprawnyCheckInException {
	//System.out.println("spr checkin");
	String string = checkIn;
	Scanner scanner = new Scanner(string);
	scanner.useDelimiter("-");
	if (scanner.hasNext()) {
		int start = scanner.nextInt();
		int koniec = scanner.nextInt();
		if (start > koniec) {
			System.out.println("wyjatek");
			scanner.close();
			throw new NiepoprawnyCheckInException();
		}
		}
	scanner.close();
}

}
