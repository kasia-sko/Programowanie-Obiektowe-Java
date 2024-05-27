package pl.pw.mini.po.dom.punktowane3.kebaby;

import java.util.Objects;

import pl.pw.mini.po.dom.punktowane3.kebaby.procesor.KebabVisitor;
import pl.pw.mini.po.dom.punktowane3.kebaby.wartosci.Mieso;
import pl.pw.mini.po.dom.punktowane3.kebaby.wartosci.Rozmiar;

public abstract class Kebab {

	private Rozmiar rozmiar;
	private int waga;
	private Mieso mieso;
	private double cena;
	
	public Kebab(Rozmiar rozmiar, int waga, Mieso mieso, double cena) {
		this.rozmiar = rozmiar;
		this.waga = waga;
		this.mieso = mieso;
		this.cena = cena;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cena, mieso, rozmiar, waga);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kebab other = (Kebab) obj;
		return Double.doubleToLongBits(cena) == Double.doubleToLongBits(other.cena) && mieso == other.mieso
				&& rozmiar == other.rozmiar && waga == other.waga;
	}
	
	public void apply(KebabVisitor visitor) {}

	public Rozmiar getRozmiar() {
		return rozmiar;
	}

	public void setRozmiar(Rozmiar rozmiar) {
		this.rozmiar = rozmiar;
	}

	public int getWaga() {
		return waga;
	}

	public void setWaga(int waga) {
		this.waga = waga;
	}

	public Mieso getMieso() {
		return mieso;
	}

	public void setMieso(Mieso mieso) {
		this.mieso = mieso;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}
	
	
	
}
