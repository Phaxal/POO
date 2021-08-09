package users;

public class AdminClass extends UserAbstractClass implements Admin {
	
	public AdminClass (String email, String password){
		super.setEmail(email);
		super.setPassword(password);
	}

}
