
public class MonsterAdult extends Monster {
	
	private static int adultmovetime = 2;

	public MonsterAdult(Grid g, Player p, int row, int col) throws Exception {
		super(g, p, row, col, adultmovetime);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int checktime() {
		return adultmovetime;
	}
	
	public void reproduce () {
	};

}
