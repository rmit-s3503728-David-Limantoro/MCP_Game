import java.util.ArrayList;

public class MonsterAdult extends Monster {

	private static int adultmovetime = 2;

	public MonsterAdult(Grid g, Player p, int row, int col, ArrayList<Monster> monsterArray, Setting sett) throws Exception {
		super(g, p, row, col, adultmovetime, monsterArray, sett);
	}

	@Override
	public int checktime() {
		return adultmovetime;
	}

	public void reproduce()  throws Exception {
		for (int x = 0; x < monsterArray.size(); x++) { //checking if there is already an infant or a child
			if (monsterArray.get(x) instanceof MonsterInfant || monsterArray.get(x) instanceof MonsterChild) {
				break;
			}
		}
		monsterArray.add(new MonsterInfant(grid, findPlayer(), this.getCell().row, this.getCell().col, super.monsterArray, super.getGameSettings())); //creates a new child
	}

	public void skillCheck() {
		if (getSkillTimer() == 0) { // if the skill timer is 0, the most important priority for the monster is to
									// try to leap and eat the player.
			//destinationCell = leaping(); // the destinationcell is set to the player's location
		}
		if (getSkillTimer() == 0 
				&& super.getGameSettings().isMonsterReproducing() == true) { // and if no other monster exists)
			try { 
				reproduce();
				setSkillTimer(10);
			}
			catch (Exception e){
				 //TODO whatever I want it to do 
			}
		}
		if (getSkillTimer() == 0 && super.getGameSettings().isMonsterInvisible() == true) { // if neither of the other options is
									// available, monster will turn invisible
			invisible();
			setSkillTimer(10);
		}
	}

}
