package pl.pw.mini.po.dom.punktowane3.kebaby;

import java.util.ArrayList;

import pl.pw.mini.po.dom.punktowane3.kebaby.parser.KebabParser;
import pl.pw.mini.po.dom.punktowane3.kebaby.parser.NieznanyRodzajMiesa;
import pl.pw.mini.po.dom.punktowane3.kebaby.procesor.KebabProcessor;

public class Demonstator {

	public static void main(String[] args) {
		try {
			ArrayList<Kebab> kebaby = KebabParser.parseKebabs("/kebaby.txt");
			System.out.println(KebabProcessor.getTellerKebabs(kebaby));
			System.out.println();
			KebabProcessor.getSummary(kebaby);
		} catch (NieznanyRodzajMiesa e) {
			e.printStackTrace();
		}
	}

}
