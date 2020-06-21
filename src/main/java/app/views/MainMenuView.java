package app.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainMenuView extends JFrame implements ActionListener, ListSelectionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label;
	private JButton addBtn;
    private JButton editBtn;
    private JButton deleteBtn;
    private JButton viewBtn;
    public MainMenuView() {
    	this.label = new JLabel("Welcome to student management app");
    	this.addBtn = new JButton();
    	this.editBtn = new JButton();
    	this.deleteBtn = new JButton();
    	this.viewBtn = new JButton();
		SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        this.label.setBorder(new EmptyBorder(40,30,0,0));
        panel.setSize(400, 350);
        panel.setLayout(layout);
        panel.add(this.addBtn);
        panel.add(this.editBtn);
        panel.add(this.deleteBtn);
        panel.add(this.viewBtn);
        panel.add(this.label);
        this.addBtn.setText("Add new student");
        this.editBtn.setText("Edit existing student");
        this.deleteBtn.setText("Delete student");
        this.viewBtn.setText("View all student");
        layout.putConstraint(SpringLayout.WEST, this.label, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, this.addBtn, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, this.addBtn, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, this.addBtn, 130, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, this.editBtn, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, this.editBtn, 160, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, this.deleteBtn, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, this.deleteBtn, 190, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, this.viewBtn, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, this.viewBtn, 220, SpringLayout.NORTH, panel);
	    this.add(panel);
        this.pack();
        this.setTitle("Main Menu");
        this.setSize(400, 350);
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
	  public void addViewListener(ActionListener listener) {
	    viewBtn.addActionListener(listener);
	  }
}
