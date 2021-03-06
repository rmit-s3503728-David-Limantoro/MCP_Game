
public class User {
	private String username;
	private String password;
	private String address;
	private String name;
	private int[] lastscores;
	private int losses;
	private int wins;

	public User(String un, String p, String add, String n) {
		username = un;
		password = p;
		address = add;
		name = n;
	}

	public String getUserName() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}

	public int[] getLastScores() {
		return lastscores;
	}

	public int getLosses() {
		return losses;
	}

	public int getWins() {
		return wins;
	}

	public void addWin() {
		wins++;
	}

	public void addLose() {
		losses++;
	}
}
