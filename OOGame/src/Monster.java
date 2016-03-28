/* This class encapsulates Monster position and direction
 * It also keeps a reference to the player it is tracking
 * The canView attribute can be used to limit monster visibility
 */

public abstract class Monster extends Moveable {
	private Player player;
	private boolean isVisible;
	private int monsterspeed;
	protected int countdown;
	private int skilltimer;
	private boolean isTrapped;
	private int visibleCountdown;
	
	public Monster(Grid g, Player p, int row, int col, int speed) throws Exception
	{
	   super(g);
	   player = p;
	   setCell(grid.getCell(row,col));
	   monsterspeed = speed;
	}
	
	@Override
	public void move(Cell nextCell)
	{
		super.setCell(nextCell);
		destinationCell = null;
	}
	
	public boolean viewable()  // can be used for hiding
	{
		return isVisible;
	}
	
	public boolean getifTrapped() {
		return isTrapped;
	}
	
	public void setTrapped() {
		isTrapped = true;
	}
	
	public int getMonsterSpeed() {
		return monsterspeed;
	}
	
	public void setMonsterSpeed(int newspeed) {
		monsterspeed = newspeed;
	}
	
	public Cell calculateDistance(Cell currentCell, Cell finaldestination)
	{ 
		skillCheck(); //checking if the skills are available for use
		if (destinationCell != null) { //if the leaping method has been used, destinationCell has now been set to a valid Cell and so the rest of the calculation is not necessary. If it hasn't been set, then the targetCell hasn't been found yet.
			//calculate the next cell the object will move into
		}
		return destinationCell;
		}
	
	public void skillCheck() {
		if (skilltimer == 0) {
			Cell dCell = leaping();
			if (dCell != null) {
				destinationCell = dCell;
			}
		}
		if (skilltimer == 0) { //and if monster is an adult)
			//call the reproduce method from MonsterAdult 
			skilltimer = 10;
			}
		if (skilltimer == 0) {
			invisible();
			skilltimer = 10;
		}
	}
	
	public Cell leaping() {
		if (player.getCell().row == this.getCell().row) {
			if (player.getCell().row % 5 == 0) {
				if (player.getCell().col <= (this.getCell().col + 3)
						&& player.getCell().col >= (this.getCell().col - 3)) {
					skilltimer = 10;
					return player.getCell();
				}
			}
		} else if (player.getCell().col == this.getCell().col) {
			if (player.getCell().col % 5 == 0) {
				if (player.getCell().row <= (this.getCell().row + 3)
						&& player.getCell().row >= (this.getCell().row - 3)) {
					skilltimer = 10;
					return player.getCell();
				}
			}
		}
		Cell destinationCell = null;
		return destinationCell;

	}
	
	public void invisible () {
		isVisible = false;
		countdown = 5;
		skilltimer = 10;
		while (countdown > 0) {
			countdown -= 1;
		}
	}
	
	public abstract int checktime();
}