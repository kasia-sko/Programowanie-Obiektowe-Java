package pl.pw.mini.po.dom.punktowane3.kebaby;

import java.util.Objects;

import pl.pw.mini.po.dom.punktowane3.kebaby.wartosci.GrubeCiasto;
import pl.pw.mini.po.dom.punktowane3.kebaby.wartosci.Mieso;
import pl.pw.mini.po.dom.punktowane3.kebaby.wartosci.Rozmiar;

public class KebabCiasto extends Kebab{
	
	private GrubeCiasto czyGrubeCiasto;

	public KebabCiasto(Rozmiar rozmiar, int waga, Mieso mieso, double cena, GrubeCiasto czyGrubeCiasto) {
		super(rozmiar, waga, mieso, cena);
		this.czyGrubeCiasto = czyGrubeCiasto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(czyGrubeCiasto);
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
		KebabCiasto other = (KebabCiasto) obj;
		return czyGrubeCiasto == other.czyGrubeCiasto;
	}
	
	@Override
	public String toString() {
		return "KebabWCiescie [rozmiar=" + this.getRozmiar() + " grubeCiasto=" + czyGrubeCiasto + " mieso=" + this.getMieso() + " waga=" + this.getWaga() + " cena=" + this.getCena()+ "]";
	}
}
