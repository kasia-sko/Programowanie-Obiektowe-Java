package pw.mini.po.dom.punktowane4.spray;

import java.awt.Graphics;
import java.util.Random;

public abstract class MyGraphics {
	
	protected static Random random = new Random();
	protected int ray;
	private int x;
	private int y;
	
	public MyGraphics(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public void paint(Graphics g) {
	}


	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getRay() {
		return ray;
	}

	public void pain(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
