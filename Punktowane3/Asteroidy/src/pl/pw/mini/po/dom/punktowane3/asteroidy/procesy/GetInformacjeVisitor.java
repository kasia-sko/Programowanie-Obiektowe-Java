package pl.pw.mini.po.dom.punktowane3.asteroidy.procesy;

import java.util.TreeSet;

import pl.pw.mini.po.dom.punktowane3.asteroidy.informacje.InformacjeVisitor;
import pl.pw.mini.po.dom.punktowane3.asteroidy.informacje.OgolneInformacje;
import pl.pw.mini.po.dom.punktowane3.asteroidy.informacje.SzczegoloweInformacje;

public class GetInformacjeVisitor implements InformacjeVisitor{
	
	private TreeSet<OgolneInformacje> niebezpieczneAsteroidy = new TreeSet<>();
	
	@Override
	public void visitInformacjeSzczegolowe(SzczegoloweInformacje asteroida) {
		niebezpieczneAsteroidy.add(asteroida);

	}

	public TreeSet<OgolneInformacje> getDangerousAsteroids() {
		return niebezpieczneAsteroidy;
	}

	
}
