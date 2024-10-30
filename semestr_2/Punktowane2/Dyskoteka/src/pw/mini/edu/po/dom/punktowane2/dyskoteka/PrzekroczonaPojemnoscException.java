package pw.mini.edu.po.dom.punktowane2.dyskoteka;

public class PrzekroczonaPojemnoscException extends Exception{
	
	private static final long serialVersionUID = -1890020973033152556L;

	public PrzekroczonaPojemnoscException() {
		super("Przekroczono pojemnosc sali!");
	}

}
