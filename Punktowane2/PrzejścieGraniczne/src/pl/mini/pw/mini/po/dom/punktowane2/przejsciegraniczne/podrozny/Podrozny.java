package pl.mini.pw.mini.po.dom.punktowane2.przejsciegraniczne.podrozny;

import java.util.List;
import java.util.Random;

import pl.mini.pw.mini.po.dom.punktowane2.przejsciegraniczne.towary.Towar;

public abstract class Podrozny implements Comparable<Podrozny>{
	protected static final Random random = new Random();
	private int wiek;
	protected static int counter;
	protected List<Towar> towary;
	protected int id;
	
	public Podrozny(int wiek) {
		this.id = counter++;
		this.wiek = wiek;
	}
	
	protected abstract List<Towar> generujTowary();
	
	public int getWiek() {
		return wiek;
	}
	
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Podrozny other = (Podrozny)o;
		if (id != other.id)
			return false;
		return true;
	}
	
	public int compareTo(Podrozny podrozny) {
		return this.wiek - podrozny.wiek;
		}
	
	public List<Towar> getTowary(){
		return towary;
	}

}
