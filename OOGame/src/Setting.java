
public class Setting {
	private boolean isPlayerSkipping;
	private boolean isPlayerTrapping;
	private boolean isPlayerTunnelling;
	private boolean isMonsterInvisible;
	private boolean isMonsterLeaping;
	private boolean isMonsterReproducing;
	private int timeticklength;
	private int gameDuration;
	private String maptype;

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

	public boolean isMonsterInvisible() {
		return isMonsterInvisible;
	}

	public boolean isMonsterLeaping() {
		return isMonsterLeaping;
	}

	public boolean isMonsterReproducing() {
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
