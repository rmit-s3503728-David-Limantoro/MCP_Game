import java.util.ArrayList;

public class MonsterChild extends Monster {

	private static int childmovetime = 1;
	
	public MonsterChild(Grid g, Player p, int row, int col, ArrayList<Monster> monsterArray, Setting sett) throws Exception {
		super(g, p, row, col, childmovetime, monsterArray, sett);
	}

	@Override
	public int checktime() {
		return childmovetime;
	}

}
