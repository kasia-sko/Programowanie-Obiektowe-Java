package pw.mini.po.lab1.gornik;

public class RadioaktywneObiektyKopalne extends ObiektyKopalne{
	
	protected int radioaktywnosc;
	
	public RadioaktywneObiektyKopalne(double bazowaWartoscRynkowa) {
		super(bazowaWartoscRynkowa);
		this.radioaktywnosc = random.nextInt(251) + 700;
	}
	

}
