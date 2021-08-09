package users;

public abstract class UserAbstractClass implements User {

	private String password;
	private String email;
	
	protected void setEmail(String email){
		this.email = email;
	}
	
	protected void setPassword(String password){
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

}
