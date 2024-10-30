package pw.mini.po.punktowane1.urzadzenia;

public interface Udzwiekowienie {

	default void wlaczDzwiek() {
		System.out.println("Dzwięk włączony");

	}
	default void wylaczDzwiek() {
		System.out.println("Dzwięk wyłączony");

	}
}
