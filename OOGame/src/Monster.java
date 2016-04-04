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
	private Setting settings;

	public Monster(Grid g, Player p, int row, int col, int speed, ArrayList<Monster> monsterArray, Setting set) throws Exception {
		super(g);
		player = p;
		setCell(grid.getCell(row, col));
		monsterspeed = speed;
		settings = set;
		this.monsterArray = monsterArray;
	}
	
	public Player findPlayer() {
		return player;
	}
	
	public Setting getGameSettings() {
		return settings;
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
		if (destinationCell != currentCell) { // if the leaping method has been used, destinationCell has now been set to a
										// valid Cell and so the rest of the calculation is not necessary. If it
										// hasn't been set, then the destinationCell hasn't been found yet.
			// TODO calculate the next cell the object will move into. YOU IDIOT! FINISH YOUR CODE!!!!
			
			//the new Cell class is necessary because there is no link to the parent Cell in the original Cell class
			ArrayList<Cell> openList = new ArrayList<Cell>();
			ArrayList<Cell> closedList = new ArrayList<Cell>();
			openList.add(currentCell);
			Cell currentcell = currentCell; //set to currentCell to ensure there is some initialization
			while (openList.isEmpty() == false) {
				double lowestscore = 100.0;
				//setting the currentcell to whichever member of the openList has the lowestCost()
				for (int x = 0; x < openList.size(); x++) {
						if (openList.get(x).getScore() < lowestscore){
							lowestscore = openList.get(x).getScore();
							currentcell = openList.get(x);
						}
				}
				if (currentcell == finaldestination) {
					Cell neighbour = currentcell;
					//trace back along path to find what the neighbouring cell is
					do {
						currentcell = neighbour;
						neighbour = currentcell.getParentCell();
					} while (neighbour != this.currentCell);
					return currentcell;
				}
				else {
					closedList.add(currentcell);
					openList.remove(currentcell);
					//iterate through the adjacent cells
					for (int x = -1; x < 2; x ++) {
						for (int y = -1; y < 2; y++) {
							if ((currentcell.row + x) >= 0
									&& (currentcell.row + x) < 11 
									&& (currentcell.col + y) >= 0 
									&& (currentcell.col + y) < 11) {
								Cell cellbeingchecked = grid.cells2D[currentcell.row + x][currentcell.col + y];
								if (cellbeingchecked.isitValid() == true) {
									// open list does not contain cellbeingchecked
									if (openList.contains(cellbeingchecked)) {
										// move to end of loop to begin again
										//check if new score is less than old score, if so change the parent cell
										int cost = currentcell.getCalculatedCost()
												+ cellbeingchecked.getMonsterCost();
										int length = Math.abs(finaldestination.row - cellbeingchecked.row);
										int height = Math.abs(finaldestination.col - cellbeingchecked.col);
										//hypotoneuse calculated through square root of the difference between x and y 2
										double h = Math.sqrt((length * length) + (height * height));
										if ((cost + h) < cellbeingchecked.getScore()) {
											cellbeingchecked.setParentCell(currentcell);
											cellbeingchecked.setCalculatedCost(cost);
											cellbeingchecked.setHeuristicvalue(h);
											cellbeingchecked.setScore(cost + h);
										}
										continue;
									} 
									else {
										// closed list does not contain
										// cellbeingchecked
										if (closedList.contains(cellbeingchecked)) {
											// move to end of while loop to
											// begin again
											continue;
										} 
										else {
											//cost is the cost from the monster's current location to the cellbeingchecked
											cellbeingchecked.setParentCell(currentcell);
											int cost = currentcell.getCalculatedCost()
													+ cellbeingchecked.getMonsterCost();
											int length = Math.abs(finaldestination.row - cellbeingchecked.row);
											int height = Math.abs(finaldestination.col - cellbeingchecked.col);
											//hypotoneuse calculated through square root of the difference between x and y 2
											double h = Math.sqrt((length * length) + (height * height));
											//score is the cost of movement and the predicted distance to the target
											double score = cost + h; 
											//added heuristic value to this
											cellbeingchecked.setCalculatedCost(cost);
											cellbeingchecked.setHeuristicvalue(h);
											cellbeingchecked.setScore(score);
											openList.add(cellbeingchecked);											
										}
									}
								} else {
									closedList.add(cellbeingchecked);
								}
							}
						}
					}
				}
			}
			return currentCell;
		}
		return currentCell;
	}

	public void skillCheck() {
		// if the skill timer is 0, the most important priority for the monster is to try to leap and eat the player.
		if (skilltimer == 0 && settings.isMonsterLeaping() == true) { 
			destinationCell = leaping(); // the destinationcell is set to the
											// player's location
		}
		if (skilltimer == 0 && settings.isMonsterInvisible() == true) { // if
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
	}

	public abstract int checktime();
}