
public class MonsterAdult extends Monster {
	
	private static int adultmovetime = 2;

	public MonsterAdult(Grid g, Player p, int row, int col) throws Exception {
		super(g, p, row, col, adultmovetime);
	}

	@Override
	public int checktime() {
		return adultmovetime;
	}
	
	public void reproduce () {
	};
	
	public void skillCheck() {
		if (getSkillTimer() == 0) { //if the skill timer is 0, the most important priority for the monster is to try to leap and eat the player.
			destinationCell = leaping(); //the destinationcell is set to the player's location
			}
		if (getSkillTimer() == 0 && Setting.isMonsterReproducing() == true) { //and if no other monster exists)
			reproduce();
			setSkillTimer(10);
			}
		if (getSkillTimer() == 0) { //if neither of the other options is available, monster will turn invisible
			invisible();
			setSkillTimer(10);
		}
	}

}
