
public class Setting implements java.io.Serializable {
	private boolean isPlayerSkipping = false; //setting options
	private boolean isPlayerTrapping = false;
	private boolean isPlayerTunnelling = false;
	private boolean isMonsterInvisible = false;
	private boolean isMonsterLeaping = false;
	private boolean isMonsterReproducing = false;
	private int timeticklength;
	private int gameDuration;
	private String maptype;
	
	public Setting() {
		
	}

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
