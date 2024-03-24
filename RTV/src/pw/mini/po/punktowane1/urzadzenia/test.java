package pw.mini.po.punktowane1.urzadzenia;

public class test {

	public static void main(String[] args) {
		
		UrzadzeniaRTV[] tab = new UrzadzeniaRTV[3];
		tab[0] = new TelewizorCRT(20, Kolor.CZARNO_BIALY);
		tab[1] = new TelewizorPlaski(33);
		tab[2] = new Radio();
		for (UrzadzeniaRTV u : tab) {
			if (u instanceof Telewizor) {
				u.wlacz();
				System.out.println(u);
				if(u instanceof OdbieranieRozszerzone) {
					((OdbieranieRozszerzone) u).odbierzSygnal();
				}
			}
			}
		tab[0].wylacz();
		tab[2].wlacz();
		tab[2].wylacz();
		tab[2].wylacz();
		tab[2].wybierzKanal(400);
		}
		

	

}
