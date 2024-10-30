package pl.edu.pw.mini.po.dom.punktowane2.pralnia.ubrania.elementyKieszeni;

public class GranatVisitor implements Visitor{

	@Override
	public void visit(Granat granat) throws OdbezpieczonyGranatException{
		if(granat.getOdbezpieczony()) {
			System.out.println("Przerywamy pranie");
			throw new OdbezpieczonyGranatException();
		}
	}

}
