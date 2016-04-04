/* This class represents the individual cell in the grid.
 */

public class Cell implements java.io.Serializable {
	protected int row;
	protected int col;
	private int energyUsed = 2;
	private int monsterCost = 1;
	private boolean isValid = false;
	private Cell parentCell;
	private int calculatedCost; //cost of moving here from the monster's current location
	private double heuristicvalue; //distance between cell and the player's current location
	private double score;
	
	public Cell(int i, int j, int eU) {
		row = i;
		col = j;
		setEnergyUsed(eU);
	}

	public Cell(int i, int j, int eU, boolean valid) {
		row = i;
		col = j;
		setEnergyUsed(eU);
		isValid = valid;
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
	
	public int getMonsterCost() {
		return monsterCost;
	}
	
	public boolean isitValid() {
		return isValid;
	}
	
	public Cell getParentCell() {
		return parentCell;
	}
	
	public void setParentCell(Cell pc) {
		parentCell = pc;
	}
	
	public int getCalculatedCost() {
		return calculatedCost;
	}
	
	public void setCalculatedCost(int cc) {
		calculatedCost = cc;
	}
	
	public double getHeuristicValue() {
		return heuristicvalue;
	}
	
	public void setHeuristicvalue(double hv) {
		heuristicvalue = hv;
	}
	
	public double getScore() {
		return score;
	}
	
	public void setScore(double s) {
		score = s;
	}
}
