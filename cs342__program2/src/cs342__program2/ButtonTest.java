package cs342__program2;
/* Matt Borgelt & Jeet Patel */
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.util.Random;



public class ButtonTest extends JFrame{
	private JButton plainButton, fancyButton;
	public static final int WIDTH = 300;
	public static final int HEIGHT = 300;
	
	public ButtonTest(){
		/* the title of the GUI */
		//super();
		/* window size */
		//setSize(WIDTH, HEIGHT);
		JFrame frame = new JFrame("Playing Minesweeper...");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /* default is HIDE ON CLOSE */
		//getContentPane().setBackground(Color.BLUE);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBackground(Color.WHITE);
		
		JPanel firstPanel = new JPanel();
		firstPanel.setLayout(new GridLayout(10, 10));
		firstPanel.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		firstPanel.setBackground(Color.RED);
		JButton btn;
		
		
		Icon tile = new ImageIcon("tile.gif");
		Icon mine = new ImageIcon("mine.gif");
		Icon flag = new ImageIcon("flag.gif");
		Icon tile1 = new ImageIcon("1.gif");
		Icon tile2 = new ImageIcon("2.gif");
		Icon tile3 = new ImageIcon("3.gif");
		
		/* BUTTON ID (0-100) maps to 2-D array which simulates the GUI. Sort of like a bit vector
		 * randomly assigns 10 random numbers, 0-100. These are the mine locations.
		 */
		int i, j;
		int[] button_ID_map = new int[100];
		for(i=0; i<100; i++){
			button_ID_map[i] = 0;
		}
	
		
		Random rn = new Random();
		int r;
		for(i=0; i<10; i++){
			r  = rn.nextInt(99); /* generate random number 0..99 */
			//System.out.print(i);
			//System.out.print("th random number is: ");
			//System.out.print(r);
			//System.out.println();
			if(button_ID_map[r] == 1){
				//collision! do again
				i--;
			} else {
				/* set the value to 1, indicating a mine */
				button_ID_map[r] = 1;
			}
			
		}
		
		/* print out the button ID bit vector (relevant bits only) */
		for(i=0; i<100; i++){
			if(button_ID_map[i]==1){
				System.out.print(i);
				System.out.print(": ");
				System.out.println(button_ID_map[i]);
			}

		}
		
		
		/* happens when one of 100 buttons is pressed */
		ButtonHandler handler = new ButtonHandler();

		/* TODO: Map btns to some sort of array to they can be referenced later */
		
		int bc = 0;
		
		/* create 10x10 grid */
		for(i=0; i<10; i++){
			for(j=0; j<10; j++){
				
				btn=new JButton( tile);
				
				if(button_ID_map[bc] == 1){
					btn.setIcon(mine);
					
				}
				btn.setPreferredSize(new Dimension(10, 10));
				firstPanel.add(btn);
				btn.addActionListener(handler);
				bc++;

			}
			
		}
		System.out.println( bc);

		
	    mainPanel.add(firstPanel);
	    frame.setContentPane(mainPanel);
	    frame.setBackground(Color.BLUE);

	    frame.setSize(WIDTH+60, HEIGHT+60);
	    frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
	    
		
		frame.setVisible(true); /* for buttons */	
	}
	
	private class ButtonHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			JOptionPane.showMessageDialog(ButtonTest.this, "you pressed: " + event.getActionCommand());
			
			
			/* if this button was one of the 10 chosen above that contains a mine... */
			//setVisible(false);
	
		}
		
	}
	
	
}
