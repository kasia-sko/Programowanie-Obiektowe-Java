package pw.mini.po.rzeka;

public class Demonstrator {

	public static void main(String[] args) {
		
//		WycinekRzeki w1 = new WycinekRzeki(5, 10);
////		w1.wypiszRzeke();
//		w1.moveAll();
//		
//		WycinekRzekiIlosc w2 = new WycinekRzekiIlosc(5, 10);
//		w2.moveAll();
//		System.out.println(w2.getWywolania());
//		
//		WycinekRzekiTekst w3 = new WycinekRzekiTekst(50, 100);
//		for (int i=0; i<10; i++) {
//			w3.moveAll();
//		}
//		
//		Moneta m = new Moneta();
//		System.out.println(m);
		
		Zegarek z1 = new Zegarek();
		System.out.println(z1.nrSeryjny);
		ZegarekPodwodny z2 = new ZegarekPodwodny();
		System.out.println(z2.nrSeryjny);
		ZegarekPodwodny z3 = new ZegarekPodwodny();
		System.out.println(z3.nrSeryjny);
	}

}
