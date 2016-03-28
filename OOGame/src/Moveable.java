/* The abstract base class for Moster and Player
 * The abstract method move() must be overridden by Player and Monster classes
 */

public abstract class Moveable {
//	protected char currentDirection;
	protected Cell currentCell;
	protected Grid grid;
	protected Cell destinationCell;

	public Moveable(Grid g) {
		grid = g;
	}
	
	public abstract void move();

////	public void setDirection(char d) {
//		currentDirection = d;
//	}
//
////	public char getDirection() {
//		return currentDirection;
//	}

	public void setCell(Cell c) {
		currentCell = c;
	}

	public Cell getCell() {
		return currentCell;
	}
}