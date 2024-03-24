package pw.mini.po.rzeka;

public class ZegarekPodwodny extends Zegarek{
	
	protected boolean dziala;

	public ZegarekPodwodny() {
		super();
		this.dziala = random.nextBoolean();
	}
	
	@Override
	public String toString() {
		return "-*-";
	}
}
