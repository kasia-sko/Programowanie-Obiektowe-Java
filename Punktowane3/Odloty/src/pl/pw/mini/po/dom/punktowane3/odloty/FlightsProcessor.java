package pl.pw.mini.po.dom.punktowane3.odloty;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class FlightsProcessor {
	
	ArrayList<Lot> allFlights;
	
	public FlightsProcessor(ArrayList<Lot> loty) {
		this.allFlights = loty;
	}
	
	public ArrayList<Przylot> getExpectedArrivals() {
		ArrayList<Przylot> spodziewanePrzyloty = new ArrayList<>();
		for (Lot lot : allFlights) {
			if(lot instanceof Przylot) {
				Przylot przylot = (Przylot) lot;
				if(!przylot.czyWyladowal()) {
					spodziewanePrzyloty.add(przylot);
				}
			}
		}
		return spodziewanePrzyloty;
	}
	
	public TreeSet<Lot> getFlightsOrder() {
		TreeSet<Lot> posortowaneLoty = new TreeSet<>();
		for (Lot lot : allFlights) {
			posortowaneLoty.add(lot);
		}
		return posortowaneLoty;
		
	}
}
