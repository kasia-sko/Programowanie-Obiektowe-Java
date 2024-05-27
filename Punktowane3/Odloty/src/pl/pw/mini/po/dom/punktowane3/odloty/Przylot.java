package pl.pw.mini.po.dom.punktowane3.odloty;

public class Przylot extends Lot{

	private boolean wyladowal;
	protected int nrWyjscia;
	
	public Przylot(String godzina, String idLotu, String miejsce, String linia, boolean wyladowal, int nrWyjscia) {
		super(godzina, idLotu, miejsce, linia);
		this.wyladowal = wyladowal;
		this.nrWyjscia = nrWyjscia;
	}
	
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Przylot other = (Przylot)o;
		if (idLotu != other.idLotu)
			return false;
		return true;
	}

	public boolean czyWyladowal() {
		return wyladowal;
	}

	
}
