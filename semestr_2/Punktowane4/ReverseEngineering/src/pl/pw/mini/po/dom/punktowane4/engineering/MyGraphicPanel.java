package pl.pw.mini.po.dom.punktowane4.engineering;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public class MyGraphicPanel extends JPanel {

	private List<MyFigure> figureList;
	private Object lock;
	
	public MyGraphicPanel() {
		this.figureList = new LinkedList<MyFigure>();
		this.lock = new Object();
		
		addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX() - 25;
				int y = e.getY() - 25;
				if (e.getButton() == MouseEvent.BUTTON1) {
					addSquare(x, y, lock);
				}
				if (e.getButton() == MouseEvent.BUTTON3) {
					addCircle(x, y, lock);
				}
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public void addSquare(int x, int y, Object lock) {
		MyFigure square = new MySquare(x, y, 50, this, lock);
		square.start();
		figureList.add(square);
		repaint();
	}
	
	public void addCircle(int x, int y, Object lock) {
		MyFigure circle = new MyCircle(x, y, 50, this, lock);
		circle.start();
		figureList.add(circle);
		repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);
		
		for (MyFigure figure : figureList) {
			// Może visitor?
			if (figure instanceof MySquare) {
				g.setColor(Color.blue);
				g.drawRect(figure.getX(), figure.getY(), figure.getSide(), figure.getSide());
			}
			else if (figure instanceof MyCircle) {
				g.setColor(Color.green);
				g.drawOval(figure.getX(), figure.getY(), figure.getSide(), figure.getSide());
			}
			g.drawString("My id: " + figure.getMyId(), figure.getX()+25, figure.getY()+25);
		}
		
	}
	
	public int getRays() {
		int rays = 0;
		for (MyFigure figure : figureList) {
			rays += figure.getSide();
		}
		return rays;
	}

	public Object getLock() {
		return lock;
	}
	
}