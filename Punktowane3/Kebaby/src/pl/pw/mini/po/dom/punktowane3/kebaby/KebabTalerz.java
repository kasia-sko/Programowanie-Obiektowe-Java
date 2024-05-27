package pl.pw.mini.po.dom.punktowane3.kebaby;

import java.util.Objects;

import pl.pw.mini.po.dom.punktowane3.kebaby.procesor.KebabVisitor;
import pl.pw.mini.po.dom.punktowane3.kebaby.wartosci.Dodatek;
import pl.pw.mini.po.dom.punktowane3.kebaby.wartosci.Mieso;
import pl.pw.mini.po.dom.punktowane3.kebaby.wartosci.Rozmiar;

public class KebabTalerz extends Kebab{
	
	private Dodatek dodatek;
	private boolean naWynos;
	
	public KebabTalerz(Rozmiar rozmiar, int waga, Mieso mieso, double cena, Dodatek dodatek, boolean naWynos) {
		super(rozmiar, waga, mieso, cena);
		this.dodatek = dodatek;
		this.naWynos = naWynos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dodatek, naWynos);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		KebabTalerz other = (KebabTalerz) obj;
		return dodatek == other.dodatek && naWynos == other.naWynos;
	}

	@Override 
	public void apply(KebabVisitor visitor) {
		visitor.kebabTalerzVisit(this);
	}
	
	@Override
	public String toString() {
		return "KebabNaTalerzu [rozmiar=" + this.getRozmiar() + " dodatek=" + dodatek + " mieso=" + this.getMieso() + " waga=" + this.getWaga() + ", NaWynos=" + naWynos + " cena=" + this.getCena()+ "]";
	}
	
	
	

}
