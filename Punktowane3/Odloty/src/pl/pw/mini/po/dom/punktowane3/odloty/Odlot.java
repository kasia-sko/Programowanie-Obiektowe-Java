package pl.pw.mini.po.dom.punktowane3.odloty;

public class Odlot extends Lot{
	
	protected Status status;
	protected String checkIn;
	
	public Odlot(String godzina, String idLotu, String miejsce, String linia, Status status, String checkIn) {
		super(godzina, idLotu, miejsce, linia);
		this.status = status;
		this.checkIn = checkIn;
	}

	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Odlot other = (Odlot)o;
		if (idLotu != other.idLotu)
			return false;
		return true;
	}
}
