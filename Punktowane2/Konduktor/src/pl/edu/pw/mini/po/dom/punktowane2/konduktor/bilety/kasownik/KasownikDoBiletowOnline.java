package pl.edu.pw.mini.po.dom.punktowane2.konduktor.bilety.kasownik;

import java.util.Random;

import pl.edu.pw.mini.po.dom.punktowane2.konduktor.bilety.Bilet;

public class KasownikDoBiletowOnline<T> extends KasownikDoBiletow{
	
	private static final Random random = new Random();
	private T generatorKomentarzy;
	
	public KasownikDoBiletowOnline(SystemSprzedazyBiletow system, T generatorKomentarzy) {
		super(system);
		this.generatorKomentarzy = generatorKomentarzy;
	}

	@Override
	public boolean walidujBilet(Bilet bilet) throws BrakZasieguException {
		int x = random.nextInt(100);
		if (x < 2) {
			throw new BrakZasieguException();
		}
		boolean s = this.getSystem().zweryfikujBilet(bilet);
		if(!s) {
			System.out.println(generatorKomentarzy.toString());
		}
		return s;
	}
	
	

}
