package pw.mini.po.dom.punktowane4.spray;

import java.awt.Color;
import java.awt.Graphics;

public class MyCircle extends MyGraphics{

	public MyCircle(int x, int y) {
		super(x, y);
		this.ray = random.nextInt(31) + 30;
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.drawOval(this.getX(), this.getY(), this.ray, this.ray);
	}
	

}
