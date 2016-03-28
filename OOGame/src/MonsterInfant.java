
public class MonsterInfant extends Monster {
	
	private int timeasinfant = 10;
	private int deathpoints = 10;

	public MonsterInfant(Grid g, Player p, int row, int col) throws Exception {
		super(g, p, row, col, 0);
	}

	@Override
	public int checktime() {
		// not actually used in this class. Perhaps use Composition instead.
		return 0;
	}
	
	public void countdownToChild () {
		while (timeasinfant > 0) {
			timeasinfant -= 1;
		}
		//count down the time until the infant turns into a child
	}
	
	public double die (Player player) {
		//kill the infant and give points to the player
		return 10.0;
	}
}
