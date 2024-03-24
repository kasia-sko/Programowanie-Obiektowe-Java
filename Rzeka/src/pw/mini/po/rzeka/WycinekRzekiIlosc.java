package pw.mini.po.rzeka;

public class WycinekRzekiIlosc extends WycinekRzeki{
	
	private int iloscWywolan;
	
	public WycinekRzekiIlosc(int szerokosc, int dlugosc) {
		super(szerokosc, dlugosc);
		this.iloscWywolan = 0;
	}
	
	@Override
	public void moveAll() {
		super.moveAll();
		iloscWywolan++;
	}
	
	public int getWywolania() {
		return iloscWywolan;
	}

}
