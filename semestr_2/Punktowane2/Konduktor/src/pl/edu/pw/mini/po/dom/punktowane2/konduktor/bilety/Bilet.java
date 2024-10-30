package pl.edu.pw.mini.po.dom.punktowane2.konduktor.bilety;

import java.util.Objects;

import pl.edu.pw.mini.po.dom.punktowane2.konduktor.wagon.Stolik;


public class Bilet {
	
	private String imie;
	private String nazwisko;
	private Stolik nazwa_Stolika;
	private boolean skasowany;
	private int kodZabezpieczajacy;
	private RelacjaPociagu relacja;
	
	public Bilet(String imie, String nazwisko, RelacjaPociagu relacja, Stolik nazwaStolika, boolean skasowany) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.relacja = relacja;
		this.nazwa_Stolika = nazwaStolika;
		this.skasowany = skasowany;
		this.kodZabezpieczajacy = generujKodZabezpieczajacy();
	}
	
	private int generujKodZabezpieczajacy() {
		return Objects.hash(imie)*7 - Objects.hash(nazwisko) + 23374;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Bilet other = (Bilet)o;
		if (nazwa_Stolika != other.nazwa_Stolika || relacja != other.relacja)
			return false;
		return true;
	}
	
	public Stolik getNazwaStolika() {
		return nazwa_Stolika;
	}
	
	public void skasuj() {
		skasowany = true;
	}
	

}
