package pw.mini.po.rzeka;

import java.util.Random;

public abstract class Suweniry {
	
	protected double wartosc;
	
	static Random random = new Random();

	public Suweniry(double i) {
		this.wartosc = i;
	}
	
	protected void setwartosc(double wartosc) {
		this.wartosc = wartosc;
	}
	
	public abstract int distance();
}
