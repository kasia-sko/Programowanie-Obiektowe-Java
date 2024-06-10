package pw.mini.po.dom.punktowane4.spray;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

public class MyGraphicPanel extends JPanel{
	
	private List<MyGraphics> graphicsList;
	private static Random random = new Random();

	
	public MyGraphicPanel() {
		
		this.graphicsList = new LinkedList<MyGraphics>();
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					if (random.nextBoolean()) {
						graphicsList.add(new MySquare(e.getX(), e.getY()));
					}
					else {
						graphicsList.add(new MyCircle(e.getX(), e.getY()));
					}
				}
				else if(e.getButton() == MouseEvent.BUTTON3) {
					graphicsList.add(new MySpray(e.getX(), e.getY()));
				}
				repaint();
				
			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (MyGraphics graphic : graphicsList) {
			graphic.paint(g);
		}
	}
	
	public int getArea() {
		int area = 0;
		for (MyGraphics graphic : graphicsList) {
			if (graphic instanceof MyCircle) {
				area += graphic.getRay() * graphic.getRay() * 2 * Math.PI;
			}
		}
		return area;
	}

}
