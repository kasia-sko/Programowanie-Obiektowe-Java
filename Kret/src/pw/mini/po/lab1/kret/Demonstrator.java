package pw.mini.po.lab1.kret;

public class Demonstrator {

	public static void main(String[] args) {
		Environment tab = new Environment(6, 10, 3, 5, Gatunek.EUROPAEA);
		tab.wypiszTablice();
		tab.runMole();
	}

}
