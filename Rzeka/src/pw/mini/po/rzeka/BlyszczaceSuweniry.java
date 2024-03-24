package pw.mini.po.rzeka;

public abstract class BlyszczaceSuweniry extends Suweniry{
	
	protected boolean polysk;
	
	public BlyszczaceSuweniry(double wartosc, boolean polysk) {
		super(wartosc);
		this.polysk = polysk;
	}

	@Override
	public int distance() {
		return 1;
	}
}
