package cs342__program2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;



public class ButtonTest extends JFrame{
	private JButton plainButton, fancyButton;
	public static final int WIDTH = 200;
	public static final int HEIGHT = 200;
	
	public ButtonTest(){
		/* the title of the GUI */
		super("Playing Minesweeper...");
		/* window size */
		//setSize(WIDTH, HEIGHT);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /* default is HIDE ON CLOSE */
		getContentPane().setBackground(Color.BLUE);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		JPanel firstPanel = new JPanel();
		firstPanel.setLayout(new GridLayout(10, 10));
		firstPanel.setMaximumSize(new Dimension(300, 300));
		JButton btn;
		
		
		//Container container = getContentPane();
		//container.setLayout(new FlowLayout());
		/*
		plainButton = new JButton("Plain Button");
		container.add(plainButton);
		Icon mine1 = new ImageIcon("mine.gif");
		Icon mine2 = new ImageIcon("mine.gif");
		fancyButton = new JButton(  mine1);
		fancyButton.setRolloverIcon(mine2);
		container.add(fancyButton);
		ButtonHandler handler = new ButtonHandler();
		fancyButton.addActionListener(handler);
		plainButton.addActionListener(handler)*/
		Icon mine1 = new ImageIcon("mine.gif");
		
		int i, j;
		for(i=0; i<10; i++){
			for(j=0; j<10; j++){
				btn=new JButton(mine1);
				btn.setPreferredSize(new Dimension(10, 10));
				firstPanel.add(btn);
			}
		}
		
		/*
		JPanel secondPanel = new JPanel();
	    secondPanel.setLayout(new GridLayout(5, 13));
	    secondPanel.setMaximumSize(new Dimension(520, 200));
	    for (i=1; i<=5; i++) {
	        for (j=1; j<=13; j++) {
	            btn = new JButton();
	            btn.setPreferredSize(new Dimension(40, 40));
	            secondPanel.add(btn);
	        }
	    }*/
		
	    mainPanel.add(firstPanel);
	    //mainPanel.add(secondPanel);
	    frame.setContentPane(mainPanel);
	    frame.setBackground(Color.BLUE);

	    frame.setSize(300, 300);
	    frame.setMinimumSize(new Dimension(300, 300));
	    
		
		frame.setVisible(true); /* for buttons */	
	}
	private class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			JOptionPane.showMessageDialog(ButtonTest.this, "you pressed: " + event.getActionCommand());
		}
	}
}
