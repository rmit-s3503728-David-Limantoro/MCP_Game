
public class MonsterInfant extends Monster {
	
	private int timeasinfant = 10;
	private int deathpoints = 10;

	public MonsterInfant(Grid g, Player p, int row, int col) throws Exception {
		super(g, p, row, col, 0);
		
	}
	public void countdownToChild () {
		while (timeasinfant > 0) {
			timeasinfant -= 1;
		}
	}
	
	public double die (Player player) {
		//kill infant monster
		return deathpoints;
	}
	@Override
	public int checktime() {
		return timeasinfant;
	}

}
