package pw.mini.po.lab1.gornik;

public class Uraninit extends RadioaktywneObiektyKopalne{
	
	private FormaWystepowania formaWystepowania;
	
	public Uraninit(double bazowaWartoscRynkowa) {
		super(bazowaWartoscRynkowa);
		this.formaWystepowania = FormaWystepowania.values()[random.nextInt(3)];	
	}
	
	@Override
	public double getModifiedMarketValue() {
		if(formaWystepowania == FormaWystepowania.URANOFAN) {
			return bazowaWartoscRynkowa;
		}
		else if(formaWystepowania == FormaWystepowania.TORBERNIT) {
			return bazowaWartoscRynkowa*1.5;
		}
		else {
			return bazowaWartoscRynkowa*2.5;
		}
	}

}
