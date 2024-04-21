package pw.mini.edu.po.dom.punktowane2.dyskoteka.uczestnik;

public class CzlowiekZZewnatrz extends Uczestnik{
	
	public CzlowiekZZewnatrz() {
		super(random.nextInt(25) + 16);
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
//		System.out.println("kkkk");
	}

}
