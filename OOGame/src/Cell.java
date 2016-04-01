/* This class represents the individual cell in the grid.
 */

public class Cell {
	protected int row;
	protected int col;
	private int energyUsed = 2;
	boolean gotGold = true;

	public Cell(int i, int j, int eU) {
		row = i;
		col = j;
		setEnergyUsed(eU);
	}

	public Cell(int i, int j) {
		row = i;
		col = j;
		setEnergyUsed(2);
	}

	public int getEnergyUsed() {
		return energyUsed;
	}

	public void setEnergyUsed(int energyUsed) {
		this.energyUsed = energyUsed;
	}
}
