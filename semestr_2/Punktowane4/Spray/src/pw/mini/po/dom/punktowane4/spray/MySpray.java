package pw.mini.po.dom.punktowane4.spray;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class MySpray extends MyGraphics{
	
	LinkedList<MyDot> dots = new LinkedList<MyDot>();
	
	public MySpray(int x, int y) {
		super(x, y);
		this.ray = random.nextInt(31) + 30;
		for (int i = 0; i < 500; i++) {
			double a = random.nextDouble(this.ray);
			double alpha = random.nextDouble(2*Math.PI);
			int xp = (int) Math.round(a*Math.cos(alpha)) + x;
			int yp = (int) Math.round(a*Math.sin(alpha)) + y;
			dots.add(new MyDot(xp, yp));
		}
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.black);
		for (MyDot dot : dots) {
			g.drawLine(dot.getX(), dot.getY(), dot.getX(), dot.getY());
		}
	}
}
