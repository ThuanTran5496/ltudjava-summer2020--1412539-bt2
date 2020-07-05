package app.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GoBack extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton backBtn;

	public GoBack() {
		init();
	}

	public void init() {
		backBtn = new JButton();
		backBtn.setText("< Back");
		backBtn.addActionListener(this);
		JPanel panel = new JPanel();
		panel.add(backBtn);
		this.add(panel);
	}

	public void actionPerformed(ActionEvent e) {
	}

	public void addBackListener(ActionListener listener) {
		backBtn.addActionListener(listener);
	}
}
