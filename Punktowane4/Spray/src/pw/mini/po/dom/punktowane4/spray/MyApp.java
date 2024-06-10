package pw.mini.po.dom.punktowane4.spray;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class MyApp {

	private JFrame frame;

	public MyApp() {
		MyFrame frame = new MyFrame();
		frame.setVisible(true);
		frame.setTitle("Ramka jak ramka!");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setPreferredSize(new Dimension(700, 700));
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		MyGraphicPanel graphicPanel = getGraphicPanel();
		mainPanel.add(graphicPanel);
		mainPanel.add(getBottomPanel(graphicPanel));
		
		frame.add(mainPanel);
		frame.setJMenuBar(getMenuPanel(graphicPanel));
		
		frame.pack();
		
	}
	
	private MyGraphicPanel getGraphicPanel() {
		MyGraphicPanel graphicPanel = new MyGraphicPanel();
		graphicPanel.setPreferredSize(new Dimension(700, 700));
		return graphicPanel;
	}
	
	private MyBottomPanel getBottomPanel(MyGraphicPanel graphicPanel) {
		MyBottomPanel bottomPanel = new MyBottomPanel(graphicPanel);
		return bottomPanel;
	}
	
	private JMenuBar getMenuPanel(MyGraphicPanel graphicPanel) {
		MyMenuPanel menuPanel = new MyMenuPanel();
		return menuPanel;
	}
}
