import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*  This class encapsulates player position and direction  
 */
public class Player extends Moveable implements KeyListener {
	private boolean readyToStart = false;
	private int energy = 0;

	public Player(Grid g, int row, int col) throws Exception {
		super(g);
		currentCell = grid.getCell(row, col);
		destinationCell = grid.getCell(row, col);

	}

	public Player(Grid g, int row, int col, int initEnergy) throws Exception {
		super(g);
		currentCell = grid.getCell(row, col);
		setEnergy(initEnergy);
	}

	public void move() {
		currentCell = destinationCell;
	}

	public void setDestination(char direction) {
		if (direction == 'U') {
			destinationCell = new Cell(currentCell.row - 1, currentCell.col);
		} else if (direction == 'D') {
			destinationCell = new Cell(currentCell.row + 1, currentCell.col);
		} else if (direction == 'L') {
			destinationCell = new Cell(currentCell.row, currentCell.col - 1);
		} else if (direction == 'R') {
			destinationCell = new Cell(currentCell.row, currentCell.col + 1);
		}
	}

	public Cell move(Cell destCell) {
		try {
			currentCell = grid.getCell(destCell.col, destCell.row);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setEnergy(getEnergy() - currentCell.getEnergyUsed());
		return currentCell;
	}

	public void setReady(boolean val) {
		readyToStart = val;
	}

	public boolean isReady() {
		return readyToStart;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			destinationCell = new Cell(currentCell.row - 1, currentCell.col);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			destinationCell = new Cell(currentCell.row + 1, currentCell.col);
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			destinationCell = new Cell(currentCell.row, currentCell.col - 1);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			destinationCell = new Cell(currentCell.row, currentCell.col - 1);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}