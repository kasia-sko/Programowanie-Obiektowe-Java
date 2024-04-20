package pl.mini.pw.mini.po.dom.punktowane2.przejsciegraniczne.podrozny;


public abstract class UzbrojonyPodrozny extends Podrozny{
	
	protected boolean uzbrojony;

	public UzbrojonyPodrozny() {
		super(random.nextInt(35,76));
		this.uzbrojony = random.nextBoolean();
		}

	
}
