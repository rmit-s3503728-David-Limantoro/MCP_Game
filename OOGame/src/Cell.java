/* This class represents the individual cell in the grid.
 */

public class Cell {
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
}
