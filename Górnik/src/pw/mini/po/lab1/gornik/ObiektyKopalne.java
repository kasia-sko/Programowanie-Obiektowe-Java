package pw.mini.po.lab1.gornik;
import java.util.Random;

public class ObiektyKopalne implements MineryObjectEvaluator{
	
	protected
	double bazowaWartoscRynkowa;
	static Random random = new Random();
	
	public ObiektyKopalne(double bazowaWartoscRynkowa) {
		this.bazowaWartoscRynkowa = bazowaWartoscRynkowa;
	}
	
	public ObiektyKopalne() {
		this.bazowaWartoscRynkowa = 1;
	}

	@Override
	public String toString() {
		String s = "" + bazowaWartoscRynkowa;
		return s;
	}

}
