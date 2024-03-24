package pw.mini.po.lab1.gornik;

public class Chalkolit extends RadioaktywneObiektyKopalne{

	public Chalkolit(double bazowaWartoscRynkowa) {
		super(bazowaWartoscRynkowa);
	}
	
	@Override
	public double getModifiedMarketValue() {
		return bazowaWartoscRynkowa;
		
	}
}
