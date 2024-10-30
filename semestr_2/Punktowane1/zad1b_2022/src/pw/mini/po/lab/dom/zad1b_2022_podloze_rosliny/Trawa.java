package pw.mini.po.lab.dom.zad1b_2022_podloze_rosliny;
import java.util.Random;

public class Trawa extends Roślina{

	Random random = new Random();

	public Trawa() {
		this.wysokosc = random.nextDouble(40) + 10.5;
		this.ekologiczna = true;
	}

	@Override
	public String toString() {
		return "|";
	}
}
