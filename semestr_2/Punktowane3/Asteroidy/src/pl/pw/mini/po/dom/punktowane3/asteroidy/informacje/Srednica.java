package pl.pw.mini.po.dom.punktowane3.asteroidy.informacje;

public class Srednica {

	private double max;
	private double min;
	
	
	public Srednica(String srednica) throws NiepoprawnaSrednicaException{
		String[] split = srednica.replace("(", "").replace(")", "").split("--");
		
		double max = Double.valueOf(split[0]);
		double min = Double.valueOf(split[1]);
		
		if (min > max) {
			throw new NiepoprawnaSrednicaException();
		}
		else {
			this.min = min;
			this.max = max;
		}
	}

	@Override
	public String toString() {
		return "Srednica [max=" + Math.round(max*100d)/100d + ", min=" + Math.round(min*100d)/100d + "]";
	}
	
	
}
