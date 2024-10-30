package pw.mini.po.lab.dom.zad1b_2022_podloze_miny;
import java.util.Random;

public class MinaPrzeciwczołgowa extends Mina{
	
	double masa_mat_wybuchowego;
	
	Random random = new Random();
	
	public MinaPrzeciwczołgowa(){
		super();
		this.masa_mat_wybuchowego = random.nextDouble() + 1.5;
		this.ekologiczna = false;
	}
	
	@Override
	public void pressMe() {
		if(uzbrojona) {
			System.out.println("Kaboom!");
		}
		else {
			super.pressMe();
		}
	}
	
	@Override
	public String toString() {
		return "X";
	}
	
	
}
