package pl.pw.mini.po.dom.punktowane4.engineering;

import java.util.Objects;

public abstract class MyFigure extends Thread{

	static int counter = 10;
	private int id;
	private int x;
	private int y;
	private int side;
	private MyGraphicPanel panel;
	private Object lock;
	
	public MyFigure(int x, int y, int side, MyGraphicPanel panel, Object lock) {
		this.id = counter;
		counter = counter + 10;
		this.x = x;
		this.y = y;
		this.side = side;
		this.panel = panel;
		this.lock = lock;
		
	}
	
	public void run() {
		try {
			while (true) {
				updateSide();
				this.panel.repaint();
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void updateSide() throws InterruptedException {
		this.side++;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyFigure other = (MyFigure) obj;
		return id == other.id;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSide() {
		return side;
	}

	public int getMyId() {
		return id;
	}

	public void setSide(int side) {
		this.side = side;
	}

	public Object getLock() {
		return lock;
	}
	
}