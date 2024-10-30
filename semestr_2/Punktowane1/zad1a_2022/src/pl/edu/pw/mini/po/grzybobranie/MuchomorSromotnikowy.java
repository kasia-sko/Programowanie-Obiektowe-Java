package pl.edu.pw.mini.po.grzybobranie;

import java.util.Random;

public class MuchomorSromotnikowy extends ToksycznyMuchomor{
	
	Random random = new Random();
	
	public MuchomorSromotnikowy() {
		super();
		if (masaOwocnika < 50) {
			this.toksyny = Toksyny.ZABOJCZE;
		}
		else {
			this.toksyny = Toksyny.WYJATKOWO_ZABOJCZE;
			
		}
	}
	@Override
	public String toString() {
		return super.toString() + "\nnazwa: muchomor sromotnikowy";
	}
	
	@Override
	public void wypiszMuchomora() {
		super.wypiszMuchomora();
		System.out.println("nazwa: muchomor sromotnikowy");
		
	}
}
