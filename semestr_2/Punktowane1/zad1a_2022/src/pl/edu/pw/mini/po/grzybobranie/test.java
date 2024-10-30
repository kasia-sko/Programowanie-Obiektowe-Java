package pl.edu.pw.mini.po.grzybobranie;

public class test {

	public static void main(String[] args) {
		MuchomorSzarawy szarawy = new MuchomorSzarawy();
		szarawy.wypiszMuchomora();
		System.out.println(szarawy.isTrujacy());
		szarawy.ugotuj();
		szarawy.wypiszMuchomora();
		System.out.println(szarawy.isTrujacy());

		
		MuchomorSromotnikowy sromotnikowy = new MuchomorSromotnikowy();
		sromotnikowy.wypiszMuchomora();
		System.out.println(sromotnikowy.isTrujacy());

//		
		MuchomorCesarski cesarski = new MuchomorCesarski();
		cesarski.wypiszMuchomora();
		System.out.println(cesarski.isTrujacy());

////		
//		MuchomorKolczastoglowy kolczasty = new MuchomorKolczastoglowy();
//		kolczasty.wypiszMuchomora();
		
		Las las = new Las(-9,60);
//		Muchomor m = las.zwrocGrzyba();
//		
//		if (m != null) {
//			m.wypiszMuchomora();
//		}
//		else{
//			System.out.println(m);
//		}
		
		Konsument konsument = new Konsument(las);
		konsument.konsumujGrzyby();
		
//		System.out.println(szarawy);
	}
	
}
