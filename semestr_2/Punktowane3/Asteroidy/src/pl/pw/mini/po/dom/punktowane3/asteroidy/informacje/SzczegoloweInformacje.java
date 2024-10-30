package pl.pw.mini.po.dom.punktowane3.asteroidy.informacje;

public class SzczegoloweInformacje extends OgolneInformacje{
	
	private boolean zagrozenieDlaZiemi;
	private String dataBliskiegoPrzejscia;
	private double predkosc;
	private double dystans;
	private Orbita orbita;
	private String link;
	
	public SzczegoloweInformacje(int id, String nazwa, Srednica srednica, boolean zagrozenieDlaZiemi, 
			String dataBliskiegoPrzejscia, double predkosc, double dystans, Orbita orbita, String link) {
		super(id, nazwa, srednica);
		this.zagrozenieDlaZiemi = zagrozenieDlaZiemi;
		this.dataBliskiegoPrzejscia = dataBliskiegoPrzejscia;
		this.predkosc = Math.round(predkosc*10d)/10d;
		this.dystans = Math.round(dystans*10d)/10d;
		this.orbita = orbita;
		this.link = link;
	}
	
	public void apply (InformacjeVisitor informacjeVisitor) {
		informacjeVisitor.visitInformacjeSzczegolowe(this);
	}
	

}
