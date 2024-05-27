package pl.pw.mini.po.dom.punktowane3.asteroidy.informacje;

public class NiepoprawnaSrednicaException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public NiepoprawnaSrednicaException() {
		super("Niepoprawna srednica - min wiekszy od max");
	}

}
