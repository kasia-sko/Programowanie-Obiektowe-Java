package pw.mini.po.dom.punktowane4.spray;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyBottomPanel extends JPanel{

	public MyBottomPanel(MyGraphicPanel graphicPanel) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JButton button = new JButton();
		button.setText("Calculate area");
		add(button);
		
		JTextField text = new JTextField();
		text.setText("");
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text.setText("" + graphicPanel.getArea());
			}
		});
		
		add(text);
		
		setPreferredSize(new Dimension(700, (int) getMinimumSize().getHeight()));
		
	}
	
}
