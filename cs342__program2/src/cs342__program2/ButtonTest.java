package cs342__program2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;



public class ButtonTest extends JFrame{
	private JButton plainButton, fancyButton;
	public static final int WIDTH = 200;
	public static final int HEIGHT = 200;
	
	public ButtonTest(){
		/* the title of the GUI */
		super("Playing Minesweeper...");
		/* window size */
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /* default is HIDE ON CLOSE */
		setBackground(Color.BLUE);
		
		
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		//plainButton = new JButton("Plain Button");
		//container.add(plainButton);
		Icon mine1 = new ImageIcon("mine.gif");
		Icon mine2 = new ImageIcon("mine.gif");
		fancyButton = new JButton(  mine1);
		//fancyButton.setRolloverIcon(mine2);
		container.add(fancyButton);
		ButtonHandler handler = new ButtonHandler();
		fancyButton.addActionListener(handler);
		//plainButton.addActionListener(handler);
		
		
		
		
		int i;
		for(i=0; i<99; i++){
			
		}
		
		
		
		
		
		setVisible(true); /* for buttons */	
	}
	private class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			JOptionPane.showMessageDialog(ButtonTest.this, "you pressed: " + event.getActionCommand());
		}
	}
}
