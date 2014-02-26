package cs342__program2;

public class Tile {
	 private int row;
	    private int col;
	    private int ID;
	    
	    public Tile()
	    {
	        ID = 0;
	        row = 0;
	        col = 0;
	    }
	    
	    public Tile(int r, int c, int n)
	    {
	        row = r;
	        col = c;
	        ID = n;
	    }
	    
	    public int getID()
	    {
	        return ID;
	    }
	    
	    public void setID(int n)
	    {
	        ID = n;
	    }
	    
	    public int getRow()
	    {
	        return row;
	    }
	    
	    public int getCol()
	    {
	        return col;
	    }
}
