package pl.pw.mini.po.dom.punktowane3.asteroidy.procesy;

import java.util.TreeSet;

import pl.pw.mini.po.dom.punktowane3.asteroidy.informacje.OgolneInformacje;

public class AsteroidProcessor {
	
	
	public TreeSet<OgolneInformacje> getDangerousAsteroidsOnly(TreeSet<OgolneInformacje> asteroidy){
		GetInformacjeVisitor getInformacjeVisitor = new GetInformacjeVisitor();
		
		for(OgolneInformacje asteroida : asteroidy) {
			asteroida.apply(getInformacjeVisitor);
		}
		return getInformacjeVisitor.getDangerousAsteroids();
		
	}

}
