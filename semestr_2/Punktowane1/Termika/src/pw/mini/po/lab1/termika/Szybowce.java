package pw.mini.po.lab1.termika;
import java.util.Random;

public abstract class Szybowce implements Latajacy{
	
	private Teren teren;
	protected int wysokosc;
	private int wspolrzednaX;
	private int wspolrzednaY;
	
	public Random random = new Random();
	
	public Szybowce(Teren teren, int wysokosc) {
		this.teren = teren;
		this.wysokosc = wysokosc;
		this.wspolrzednaX = 0;
		this.wspolrzednaY = random.nextInt(teren.getTeren().length);
	}

	@Override
	public void fly() {
		if (wysokosc != 0) {
			wspolrzednaX += 1;
			int p = random.nextInt(3);
			if (p==0) {
				wspolrzednaY -=1;
			}
			else if (p==1) {
				wspolrzednaY += 1;
			}
			if(wspolrzednaX >= teren.getTeren()[0].length || wspolrzednaY >= teren.getTeren().length || wspolrzednaY < 0) {
				System.out.println("Lot poza strefa");
				
			}
			else {
				wysokosc -= teren.getTeren()[wspolrzednaY][wspolrzednaX].getPradyNoszace();
				if (wysokosc <= 0) {
					System.out.println("Oooops, ladowanie w polu");
					wysokosc = 0;
			}}
		}

		
	}
	
	
	
	

}
