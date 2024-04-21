package pw.mini.edu.po.dom.punktowane2.dyskoteka.uczestnik;

import pw.mini.edu.po.dom.punktowane2.dyskoteka.RejestrObcych;

public class UczestnikVisitor implements Visitor{
	

	private RejestrObcych rejestr;

	public UczestnikVisitor(RejestrObcych rejestr) {
		this.rejestr = rejestr;
	}
		
	@Override
	public void visit(CzlowiekZZewnatrz czlowiek) {
//		System.out.println("ok");
		if(rejestr.czyDodac(czlowiek)) {
			rejestr.dodaj(czlowiek);
		}
		
	}
	
	

}
