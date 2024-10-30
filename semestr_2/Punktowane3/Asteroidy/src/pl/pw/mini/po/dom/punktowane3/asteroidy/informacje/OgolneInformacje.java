package pl.pw.mini.po.dom.punktowane3.asteroidy.informacje;

import java.util.Objects;

public class OgolneInformacje implements Comparable<OgolneInformacje>{

	private int id;
	private String nazwa;
	private Srednica srednica;
	
	public OgolneInformacje(int id, String nazwa, Srednica srednica) {
		this.id = id;
		this.nazwa = nazwa;
		this.srednica = srednica;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OgolneInformacje other = (OgolneInformacje) obj;
		return Objects.equals(id, other.id);
		}
	
	@Override
	public int compareTo(OgolneInformacje o) {
		return id < o.id ? -1 : id > o.id ? 1 : 0;
	}

	public void apply(InformacjeVisitor informacjeVisitor) {}

}
