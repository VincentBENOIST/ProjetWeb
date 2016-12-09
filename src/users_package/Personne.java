package users_package;

public abstract class Personne {
	private String login;
	private String password;

	public Personne(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	
	
}
