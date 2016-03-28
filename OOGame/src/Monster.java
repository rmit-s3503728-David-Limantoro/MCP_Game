/* This class encapsulates Monster position and direction
 * It also keeps a reference to the player it is tracking
 * The canView attribute can be used to limit monster visibility
 */

public abstract class Monster extends Moveable {
	private boolean isVisible = true; //checks if currently invisible
	private int monsterspeed = 1;
	protected int countdown = 0;
	private int visibleCountdown = 0;
	private int skilltimer = 10;
	private boolean isTrapped = false; //checks if currently trapped

	private Player player;
	
	public Monster(Grid g, Player p, int row, int col, int ms) throws Exception
	{
	   super(g);
	   player = p;
	   setCell(grid.getCell(row,col));
	   monsterspeed = ms;
	}
	
	@Override
	public void move(Cell nextCell) //monster actually moving
	{
		if (countdown == 0) {
			super.setCell(nextCell);
			countdown += nextCell.getEnergyUsed();
			countdown -= monsterspeed;
		}
		else
			countdown -= monsterspeed;
//		currentDirection = grid.getBestDirection(currentCell, player.getCell());
//        currentCell = (grid.getCell(getCell(),getDirection()));
//        return currentCell;
	}
	
	public boolean viewable() {
		return isVisible;
	}
	
	public boolean getifTrapped() {
		return isTrapped;
	}
	
	public void setTrapped() {
		isTrapped = true;
		countdown = 10;
	}
	
	public int getMonsterSpeed() {
		return monsterspeed;
	}
	
	public void setMonsterSpeed(int newspeed) {
		monsterspeed = newspeed;
	}
	
	public Cell calculateDistance(Cell currentCell, Cell finaldestination)
		{
		Cell nextdestinationCell = null;
		//calculate the path to the finaldestinationcell
		//if leaping, call leaping function
		//set nextdestinationcell to the next immediate cell
		return nextdestinationCell;
		}
	
	public void skillCheck(String skillname) {
		//check if skill can be used
	}
	
	public Cell leaping() {
		Cell nextleapedCell = null;
		//calculate 3 cells along the path to the final destinationcell
		return nextleapedCell;
	}
	
	public void invisible() {
		isVisible = false;
		visibleCountdown = 5;
	}
	
	public abstract int checktime();
	
}