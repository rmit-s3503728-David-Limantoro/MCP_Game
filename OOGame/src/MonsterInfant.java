import java.util.ArrayList;

public class MonsterInfant extends Monster {
	
	private int timeasinfant = 10;
	private int deathpoints = 10;

	public MonsterInfant(Grid g, Player p, int row, int col, ArrayList<Monster> monsterArray) throws Exception {
		super(g, p, row, col, 0, monsterArray);
		
	}
	public void reducecountdownToChild () { //counts down the time the infant has before turning into a child
		timeasinfant -= 1;
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
