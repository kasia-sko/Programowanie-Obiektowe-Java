package pl.pw.mini.po.dom.punktowane3.kebaby.procesor;

import java.util.ArrayList;

import pl.pw.mini.po.dom.punktowane3.kebaby.KebabTalerz;
import pl.pw.mini.po.dom.punktowane3.kebaby.wartosci.Mieso;
import pl.pw.mini.po.dom.punktowane3.kebaby.wartosci.Rozmiar;

public class KebabTalerzVisitor implements KebabVisitor{
	
		ArrayList<KebabTalerz> kebabyNaTalerzu = new ArrayList<>();
		
		@Override
		public void kebabTalerzVisit(KebabTalerz kebab) {
			if (kebab.getRozmiar() != Rozmiar.S & kebab.getMieso() == Mieso.kurczak) {
				kebabyNaTalerzu.add(kebab);
			}
		}
	
		public ArrayList<KebabTalerz> getKebabyNaTalerzu(){
			return kebabyNaTalerzu;
		}

}
