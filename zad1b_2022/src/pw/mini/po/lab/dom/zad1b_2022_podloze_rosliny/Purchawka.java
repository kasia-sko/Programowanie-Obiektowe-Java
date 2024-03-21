package pw.mini.po.lab.dom.zad1b_2022_podloze_rosliny;
import java.util.Random;

public class Purchawka extends Roślina{
	
	Random random = new Random();

	public Purchawka() {
		this.wysokosc = random.nextDouble(4) + 3.5;
		this.ekologiczna = random.nextBoolean();
	}

	@Override
	public void pressMe() {
		System.out.println("Puffff");
	}
	
	@Override
	public String toString() {
		return "o";
	}
}