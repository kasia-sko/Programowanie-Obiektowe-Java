package pw.mini.po.lab1.termika;

public class Demonstrator {

	public static void main(String[] args) {
		Teren teren = new Teren(8,10);
//		teren.modyfikujAtmosfere();
		Bocian szybowiec = new Bocian(teren, 20);
		
		for (int i=0; i<25; i++) {
			teren.modyfikujAtmosfere();
			szybowiec.fly();
			System.out.println(szybowiec);
		}
//		teren.modyfikujAtmosfere();
//		szybowiec.fly();
//		System.out.println(szybowiec);
	}

}
