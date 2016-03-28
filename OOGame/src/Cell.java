/* This class represents the individual cell in the grid.
 */

public class Cell {
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
}
