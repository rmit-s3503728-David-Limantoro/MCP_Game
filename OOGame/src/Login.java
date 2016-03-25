import java.util.ArrayList;

public class Login {

	private User[] loggedInUser;
	private ArrayList<User> userList;

	public Login() {
		userList = new ArrayList<User>();
		loggedInUser = new User[2];
	}

	public void createNewUser(String userName, String password) {
		userList.add(new User(userName, password, "Address", "Name"));
	}

	public void loginUser(String userName, String password) {
		// TODO check username and password
	}

	public void logoutUser(int playerNumber) {
		loggedInUser[playerNumber - 1] = null;
	}

	public User[] getLoggedInUser() {
		return loggedInUser;
	}

}
