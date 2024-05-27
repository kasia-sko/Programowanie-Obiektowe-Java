package pl.pw.mini.po.dom.punktowane3.odloty;

public abstract class Lot implements Comparable<Lot>{

	protected String godzina;
	protected String idLotu;
	protected String miejsce;
	protected String linia;
	
	public Lot(String godzina, String idLotu, String miejsce, String linia) {
		this.godzina = godzina;
		this.idLotu = idLotu;
		this.miejsce = miejsce;
		this.linia = linia;
	}
	
	public int compareTo(Lot l) {
		return idLotu.length() - l.idLotu.length();
	}

}
