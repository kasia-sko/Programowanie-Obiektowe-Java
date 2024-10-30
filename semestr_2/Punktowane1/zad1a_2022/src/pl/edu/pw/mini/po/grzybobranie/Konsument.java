package pl.edu.pw.mini.po.grzybobranie;
import java.util.Random;

public class Konsument {
	
	public Las las;
	
	public Konsument(Las las) {
		this.las = las;
	}
	
	public void konsumujGrzyby() {
		Random random = new Random();
		int n = random.nextInt(50) + 50;
		for(int i=0; i<n; i++) {
			if(las.zwrocGrzyba() instanceof Muchomor){
				Muchomor grzyb = (Muchomor)las.zwrocGrzyba();
	//			System.out.println(grzyb==null);
				boolean czy_przerwac = zjedz(grzyb);
				if(czy_przerwac) {
					break;
				}
			
		}
	} }
	
	public boolean zjedz(Muchomor grzyb) {
		if (grzyb != null) {
			grzyb.ugotuj();
			if(grzyb.isTrujacy()) {
				System.out.println("Uuups");
				return true;
			}
		}
		return false;
		
	}
	
//	public void konsumujGrzyby() {
//		Random random = new Random();
//		int n = random.nextInt(50) + 50;
//		for(int i=0; i<n; i++) {
//			Muchomor grzyb = las.zwrocGrzyba();
//			if (grzyb != null) {
//				grzyb.ugotuj();
//				if(grzyb.isTrujacy()) {
//					System.out.println("Uuups");
//					break;
//				}
//			}
//			
//			
//		}
//	}

}
