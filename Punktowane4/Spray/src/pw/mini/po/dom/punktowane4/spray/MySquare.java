package pw.mini.po.dom.punktowane4.spray;

import java.awt.Color;
import java.awt.Graphics;

public class MySquare extends MyGraphics{
	
	public MySquare(int x, int y) {
		super(x, y);
		this.ray = random.nextInt(11) + 10;
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(this.getX(), this.getY(), this.ray, this.ray);
	}
	

}
