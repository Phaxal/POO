package users;

public class ClientClass extends UserAbstractClass implements Client {
	
	public ClientClass (String email, String password){
		super.setEmail(email);
		super.setPassword(password);
	}

}
