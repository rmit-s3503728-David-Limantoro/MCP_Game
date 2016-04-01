import java.util.ArrayList;

/* This class encapsulates Monster position and direction
 * It also keeps a reference to the player it is tracking
 * The canView attribute can be used to limit monster visibility
 */

public abstract class Monster extends Moveable {
	protected ArrayList<Monster> monsterArray;
	private Player player;
	private boolean isVisible = true;
	private int monsterspeed;
	protected int countdown;
	private int skilltimer;
	private boolean isTrapped;
	private int visibleCountdown;

	public Monster(Grid g, Player p, int row, int col, int speed, ArrayList<Monster> monsterArray) throws Exception {
		super(g);
		player = p;
		setCell(grid.getCell(row, col));
		monsterspeed = speed;
		this.monsterArray = monsterArray;
	}
	
	public Player findPlayer() {
		return player;
	}

	@Override
	public void move() { // called every 'tick'/'round'
		if (countdown > 0) { // if the countdown is greater than 0 (because the Monster is stuck somewhere, reduce the countdown by the monster's speed
			countdown -= monsterspeed;
			return;
		}
		if (skilltimer > 0) { // if the skilltimer is greater than 0 because a skill has been used recently, reduce it by 1
			skilltimer -= 1;
		}
		setCell(calculateDistance(this.currentCell, player.currentCell)); // 'Set Cell'moves the monster to the 'next location', which
																			// is provided by the calculateDistance function, which takes
																			// the current location and the final
																			// location
																			// to
																			// determined
																			// the
																			// 'next
																			// location'
		//destinationCell = null;
		if (visibleCountdown > 0) { // if the monster is invisible, reduce the
									// timer by 1
			visibleCountdown -= 1;
		}
		if (visibleCountdown == 0) { // if the visiblecountdown has reached 0,
										// set the monster to be visible again
			isVisible = true;
		}
	}

	public boolean viewable() // can be used for hiding
	{
		return isVisible;
	}

	public boolean getifTrapped() {
		return isTrapped;
	}

	public void setTrapped() {
		isTrapped = true;
		countdown += 10;
	}

	public int getSkillTimer() {
		return skilltimer;
	}

	public void setSkillTimer(int sk) {
		skilltimer += sk;
	}

	public int getMonsterSpeed() {
		return monsterspeed;
	}

	public void setMonsterSpeed(int newspeed) {
		monsterspeed = newspeed;
	}

	public Cell calculateDistance(Cell currentCell, Cell finaldestination) {
		skillCheck(); // checking if the skills are available for use
		if (destinationCell != null) { // if the leaping method has been used, destinationCell has now been set to a
										// valid Cell and so the rest of the calculation is not necessary. If it
										// hasn't been set, then the destinationCell hasn't been found yet.
			// calculate the next cell the object will move into. YOU IDIOT! FINISH YOUR CODE!!!!
			// 
			return currentCell;
		}
		return currentCell;
	}

	public void skillCheck() {
		if (skilltimer == 0 && Setting.isMonsterLeaping() == true) { // if the
																		// skill
																		// timer
																		// is 0,
																		// the
																		// most
																		// important
																		// priority
																		// for
																		// the
																		// monster
																		// is to
																		// try
																		// to
																		// leap
																		// and
																		// eat
																		// the
																		// player.
			destinationCell = leaping(); // the destinationcell is set to the
											// player's location
		}
		if (skilltimer == 0 && Setting.isMonsterInvisible() == true) { // if
																		// neither
																		// of
																		// the
																		// other
																		// options
																		// is
																		// available,
																		// monster
																		// will
																		// turn
																		// invisible
			invisible();
			skilltimer = 10;
		}
	}

	public Cell leaping() {
		if (player.getCell().row == this.getCell().row) { // if the monster and player are on the same row
			if (player.getCell().row % 5 == 0) { // if the player is on one of
													//the cross-rows (ie. jumping is not blocked by a swamp)
				if (player.getCell().col <= (this.getCell().col + 3) // if the player is within 3 cells of the monster
						&& player.getCell().col >= (this.getCell().col - 3)) {
					skilltimer = 10; // increase the skill timer so that the
										// ability can't be used too frequently
					return player.getCell(); // return the player's cell as that
												// is where the monster will
												// jump to
				}
				return this.currentCell;
			}
			return this.currentCell;
		} 
		else if (player.getCell().col == this.getCell().col) { // if the
																	// monster
																	// and
																	// player
																	// are in
																	// the same
																	// column
			if (player.getCell().col % 5 == 0) {
				if (player.getCell().row <= (this.getCell().row + 3)
						&& player.getCell().row >= (this.getCell().row - 3)) {
					skilltimer = 10;
					return player.getCell();
				}
				return this.currentCell;
			}
			return this.currentCell;
		}
		else {
			return this.currentCell;
		}

	}

	public void invisible() {
		isVisible = false;
		visibleCountdown = 5;
		skilltimer = 10;
		isVisible = true;
	}

	public abstract int checktime();
}