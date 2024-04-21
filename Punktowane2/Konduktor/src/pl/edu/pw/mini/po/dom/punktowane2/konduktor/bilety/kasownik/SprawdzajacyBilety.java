package pl.edu.pw.mini.po.dom.punktowane2.konduktor.bilety.kasownik;

import pl.edu.pw.mini.po.dom.punktowane2.konduktor.bilety.Bilet;

public interface SprawdzajacyBilety {
	public boolean walidujBilet(Bilet bilet) throws BrakZasieguException;
}
