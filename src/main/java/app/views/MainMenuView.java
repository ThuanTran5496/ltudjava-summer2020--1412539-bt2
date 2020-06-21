package app.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainMenuView extends JFrame implements ActionListener, ListSelectionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton addBtn;
    private JButton editBtn;
    private JButton deleteBtn;
    public MainMenuView() {
    	this.addBtn = new JButton();
    	this.editBtn = new JButton();
    	this.deleteBtn = new JButton();
		SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        panel.setSize(400, 300);
        panel.setLayout(layout);
        panel.add(this.addBtn);
        panel.add(this.editBtn);
        panel.add(this.deleteBtn);
        this.addBtn.setText("Add new student");
        this.editBtn.setText("Edit existing student");
        this.deleteBtn.setText("Delete student");

        layout.putConstraint(SpringLayout.WEST, this.addBtn, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, this.addBtn, 80, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, this.editBtn, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, this.editBtn, 105, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, this.deleteBtn, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, this.deleteBtn, 130, SpringLayout.NORTH, panel);
	    this.add(panel);
        this.pack();
        this.setTitle("Main Menu");
        this.setSize(700, 500);
        this.setResizable(false);
    }

	  public void actionPerformed(ActionEvent e) {
	    
	  }
	    
	  public void valueChanged(ListSelectionEvent e) {
	    
	  }
	    public void addAddNewListener(ActionListener listener) {
	    	addBtn.addActionListener(listener);
	    }
	    public void addEditListener(ActionListener listener) {
	    	editBtn.addActionListener(listener);
	    }
	    public void addDeleteListener(ActionListener listener) {
	    	deleteBtn.addActionListener(listener);
	    }
}
