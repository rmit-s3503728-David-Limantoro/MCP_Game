/*  This class encapsulates player position and direction  
 */
public class Player extends Moveable {
	private boolean readyToStart = false;
	private int energy = 0;
	private int energyUsed = 0;

	public Player(Grid g, int row, int col) throws Exception {
		super(g);
		currentCell = grid.getCell(row, col);
		currentDirection = ' ';
	}

	public Cell move() {
		currentCell = grid.getCell(currentCell, currentDirection);
		return currentCell;
	}

	public Cell move(Cell destCell) {
		try {
			currentCell = grid.getCell(destCell.col, destCell.row);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		energyUsed -= currentCell.getEnergyUsed();
		return currentCell;
	}

	public void setReady(boolean val) {
		readyToStart = val;
	}

	public boolean isReady() {
		return readyToStart;
	}
}