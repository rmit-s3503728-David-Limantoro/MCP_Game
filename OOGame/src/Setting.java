
public class Setting {
	private  boolean isPlayerSkipping; //setting options
	private static boolean isPlayerTrapping;
	private static boolean isPlayerTunnelling;
	private static boolean isMonsterInvisible;
	private static boolean isMonsterLeaping;
	private static boolean isMonsterReproducing;
	private static int timeticklength;
	private static int gameDuration;
	private static String maptype;

	public void updatePlayerAbilities(boolean skip, boolean trap, boolean tun) {
		isPlayerSkipping = skip;
		isPlayerTrapping = trap;
		isPlayerTunnelling = tun;
	}

	public void updateMonsterAbilities(boolean invis, boolean leap, boolean repro) {
		isMonsterInvisible = invis;
		isMonsterLeaping = leap;
		isMonsterReproducing = repro;

	}
	
	public void updateOtherSettings(int time, int gd, String map) {
		timeticklength = time;
		gameDuration = gd;
		maptype = map;
	}

	public boolean isPlayerSkipping() {
		return isPlayerSkipping;
	}

	public boolean isPlayerTrapping() {
		return isPlayerTrapping;
	}

	public boolean isPlayerTunnelling() {
		return isPlayerTunnelling;
	}

	public static boolean isMonsterInvisible() {
		return isMonsterInvisible;
	}

	public static boolean isMonsterLeaping() {
		return isMonsterLeaping;
	}

	public static boolean isMonsterReproducing() {
		return isMonsterReproducing;
	}

	public int getTimeticklength() {
		return timeticklength;
	}

	public int getGameDuration() {
		return gameDuration;
	}

	public String getMaptype() {
		return maptype;
	}
}
