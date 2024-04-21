package pl.edu.pw.mini.po.dom.punktowane2.pralnia.ubrania.elementyKieszeni;

public class Granat extends ElementKieszeni{
	
	private boolean odbezpieczony;
	
	public Granat() {
		if(random.nextInt(10) == 0) {
			this.odbezpieczony = true;
		}
		else this.odbezpieczony = false;
	}
	
	public boolean getOdbezpieczony() {
		return odbezpieczony;
	}
	
	public void accept(Visitor visitor) throws OdbezpieczonyGranatException{
		visitor.visit(this);
		System.out.println("ok");
	}

}
