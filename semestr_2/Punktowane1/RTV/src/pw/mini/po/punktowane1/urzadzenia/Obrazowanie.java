package pw.mini.po.punktowane1.urzadzenia;

public interface Obrazowanie {

	default void wlaczObraz() {
		System.out.println("Obraz włączony");
		
	}
	default void wylaczObraz() {
		System.out.println("Obraz wyłączony");
		
	}

}
