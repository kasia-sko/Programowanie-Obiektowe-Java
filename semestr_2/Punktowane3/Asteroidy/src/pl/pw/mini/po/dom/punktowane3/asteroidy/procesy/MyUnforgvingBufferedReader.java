package pl.pw.mini.po.dom.punktowane3.asteroidy.procesy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class MyUnforgvingBufferedReader extends BufferedReader{
	
	private Map<String, Integer> licznik;

	public MyUnforgvingBufferedReader(Reader in) {
		super(in);
		this.licznik = new HashMap<String, Integer>();
	}
	
	public String readLine() throws IOException{
		String line = super.readLine();
		if (line != null) {
			if (licznik.containsKey(line)) {
				licznik.replace(line, licznik.get(line)+1);
			}
			else {
				licznik.put(line, 1);
			}
		}
		
		return super.readLine();
	}

	public String myReadLine() throws IOException {
		String line = super.readLine();
		if (line != null) {
			if (licznik.containsKey(line)) {
				licznik.replace(line, licznik.get(line)+1);
				System.out.println(line + "liczba wystapien: " + licznik.get(line));
			}
			else {
				licznik.put(line, 1);
			}
		}
		return super.readLine();
	}
	

}
