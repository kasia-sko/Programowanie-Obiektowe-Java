package pw.mini.po.dom.punktowane4.spray;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MyMenuPanel extends JMenuBar{
	
	private JMenu options;
	public MyMenuPanel() {
		this.options = new JMenu("My options");
		JMenuItem greeting = new JMenuItem("Greeting");
		greeting.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Guten Tag!");
				
			}
		});
		this.options.add(greeting);
        this.add(options);

		
	} 

}
