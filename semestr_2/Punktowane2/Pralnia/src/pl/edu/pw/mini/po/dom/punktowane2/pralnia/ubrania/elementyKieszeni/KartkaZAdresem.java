package pl.edu.pw.mini.po.dom.punktowane2.pralnia.ubrania.elementyKieszeni;

public class KartkaZAdresem extends ElementKieszeni{

	private String ulica;
	private int nrDomu;
	
	public KartkaZAdresem(String ulica) {
		this.ulica = ulica;
		this.nrDomu = random.nextInt(222) + 1;
	}
	
	public String getUlica() {
		return ulica;
	}
	
	public int getNrDomu() {
		return nrDomu;
	}
	
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		KartkaZAdresem other = (KartkaZAdresem)o;
		if (ulica != other.ulica || nrDomu != other.nrDomu)
			return false;
		return true;
	}
}
