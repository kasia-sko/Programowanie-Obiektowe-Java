package pw.mini.po.lab.dom.zad1b_2022_podloze_miny;

import pw.mini.po.lab.dom.zad1b_2022_podloze.Element;

public class Mina extends Element{
	
	protected int id_miny;
	protected boolean uzbrojona;
	static int licznik;
	
	public Mina() {
		this.id_miny = 10*(licznik++);
		this.uzbrojona = false;
	}
	
	public void armMe() {
		this.uzbrojona = true;
	}
	
}
