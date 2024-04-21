package pl.edu.pw.mini.po.dom.punktowane2.pralnia.ubrania.elementyKieszeni;

import java.util.Random;

public abstract class ElementKieszeni {
	protected static final Random random = new Random();

	public void accept(Visitor visitor) throws OdbezpieczonyGranatException {
	}

}
