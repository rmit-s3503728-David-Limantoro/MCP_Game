
public class NewUserException extends Exception {
	private String invalidUserName;

	public NewUserException(String invalidUserName) {
		this.setInvalidUserName(invalidUserName);
	}

	public String getInvalidUserName() {
		return invalidUserName;
	}

	public void setInvalidUserName(String invalidUserName) {
		this.invalidUserName = invalidUserName;
	}
}
