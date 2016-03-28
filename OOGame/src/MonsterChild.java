
public class MonsterChild extends Monster {

	private static int childmovetime = 1;
	
	public MonsterChild(Grid g, Player p, int row, int col) throws Exception {
		super(g, p, row, col, childmovetime);
	}

	@Override
	public int checktime() {
		return childmovetime;
	}

}
