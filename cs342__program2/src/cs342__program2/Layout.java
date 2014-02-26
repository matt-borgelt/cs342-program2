package cs342__program2;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.util.Random;


public class Layout extends JFrame{
	
	
	
	    public Layout()
	    {
	        frame = new JFrame("Minesweeper");
	        frame.setLayout( new GridLayout(rows,cols) );
	        
	        grid = new JButton[rows][cols];
	        tiles = new Tile[rows][cols];
	        
	        //MouseClickHandler handler = new MouseClickHandler();
	        
	        
	        for(int x = 0; x < rows; x++)
	        {
	            for(int y = 0; y < rows; y++)
	            {
	                grid[x][y] = new JButton();
	                grid[x][y].setBackground(Color.BLUE);
	                grid[x][y].addMouseListener( new MouseClickHandler() ); 
	                frame.add(grid[x][y]);
	            }
	        }
	        
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(400,400);
	        frame.setVisible(true);
	        
	        /* representation of grid */
	        int i, j;
			int[][] tile_map = new int[10][10];
			for(i=0; i<10; i++){
				for(j=0; j<10; j++){
					tile_map[i][j] = 0;
				}
			}
		
			
			/* random mine placement */
			Random rn = new Random();
			int r1, r2 = 0;
			for(i=0; i<10; i++){
			
				r1  = rn.nextInt(9); /* generate random number 0..99 */
				r2  = rn.nextInt(9);
				
				if(tile_map[r1][r2] == 1){
					//collision! do again
					i--;
				} else {
					/* set the value to 1, indicating a mine */
					tile_map[r1][r2] = 1;
				}
			}
			
			/* temporary code, sets mine icon */
			for(i=0; i<9; i++){
				for(j=0; j<9; j++){
					if(tile_map[i][j]==1){
						grid[i][j].setIcon(mine);
					}
				}
			}
			
			
			
	    }
	    
	    private JFrame frame;
	    private Tile[][] tiles;
	    private JButton[][] grid;
	    private final int rows = 10;
	    private final int cols = 10;
	    
	    private final Icon one = new ImageIcon( (new ImageIcon("1.png").getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH)));
	    private final Icon two = new ImageIcon( (new ImageIcon("2.png").getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH)));
	    private final Icon three = new ImageIcon( (new ImageIcon("3.png").getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH)));
	    private final Icon four = new ImageIcon( (new ImageIcon("4.png").getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH)));
	    private final Icon flag = new ImageIcon( (new ImageIcon("flag.png").getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH)));
	    private final Icon mine = new ImageIcon( (new ImageIcon("mine.png").getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH)));
	    private final Icon empty = new ImageIcon( (new ImageIcon("empty.png").getImage().getScaledInstance(35,35,Image.SCALE_SMOOTH)));

	    private int mouse_arg = 0;
	    
	    private class MouseClickHandler extends MouseAdapter {

	        // handle mouse click event and determine which button was pressed
	        public void mouseClicked( MouseEvent event )
	        {

	           /* Right mouse click */
	           if ( event.isMetaDown() ) {
	        	   JOptionPane.showMessageDialog(Layout.this, "Rmouse");
	        	   mouse_arg = 1;
	           }
	           else if (event.isAltDown()){
	        	   ;
	           }
	           /* left mouse click */
	           else {
	        	   JOptionPane.showMessageDialog(Layout.this, "Lmouse");
	        	   mouse_arg=0;
	           }
	        }
	     }
	    
}


