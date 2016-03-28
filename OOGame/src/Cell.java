/* This class represents the individual cell in the grid.
 */

public class Cell {
<<<<<<< HEAD
   protected int row;
   protected int col;
   boolean gotGold = true;
   private int energyUsed = 1;
   
   public Cell(int i, int j)
   {
	  row = i;
	  col = j;
   }
   
   public int getEnergyUsed () {
	   return energyUsed;
   }
=======
	protected int row;
	protected int col;
	private int energyUsed;
	boolean gotGold = true;

	public Cell(int i, int j, int eU) {
		row = i;
		col = j;
		energyUsed = eU;
	}

	public Cell(int i, int j) {
		row = i;
		col = j;
		energyUsed = 2;
	}
>>>>>>> origin/Nicole
}
