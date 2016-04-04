
public class CellTrap extends Cell {

	private int monsterCost = 5;
	
	public CellTrap(int i, int j) {
		super(i, j, 2);
		// TODO Auto-generated constructor stub
	}
	
	public int getEnergyUsed () {
		return monsterCost;
	}

}
