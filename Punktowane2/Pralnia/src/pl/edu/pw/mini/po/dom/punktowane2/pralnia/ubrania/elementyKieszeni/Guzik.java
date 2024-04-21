package pl.edu.pw.mini.po.dom.punktowane2.pralnia.ubrania.elementyKieszeni;

public class Guzik extends ElementKieszeni{
	
	private int id;
	private static int counter;
	
	public Guzik() {
		this.id = counter++;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Guzik other = (Guzik)o;
		if (id != other.id)
			return false;
		return true;
	}
	
	public int getId() {
		return id;
	}
}
