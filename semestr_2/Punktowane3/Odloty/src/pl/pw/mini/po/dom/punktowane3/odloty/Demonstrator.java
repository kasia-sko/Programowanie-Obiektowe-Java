package pl.pw.mini.po.dom.punktowane3.odloty;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

public class Demonstrator {

	public static void main(String[] args) {
		FlightParser flightsParser = new FlightParser();
		String filePath = "resources/loty.txt";
		
		try {
			ArrayList<Lot> listaLotow = flightsParser.parseFlights(filePath);
			FlightsProcessor flightsProcessor = new FlightsProcessor(listaLotow);
			System.out.println(listaLotow);
			System.out.println(listaLotow.size());
			ArrayList<Przylot> spodziewanePrzyloty = flightsProcessor.getExpectedArrivals();
			System.out.println(spodziewanePrzyloty);
			System.out.println(spodziewanePrzyloty.size());
			for (Przylot przylot : spodziewanePrzyloty) {
				System.out.println(przylot.czyWyladowal());
			}
			TreeSet<Lot> posortowaneLoty = flightsProcessor.getFlightsOrder();
			System.out.println(posortowaneLoty);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
