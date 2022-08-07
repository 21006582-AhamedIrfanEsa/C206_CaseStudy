
public class User extends Item {


	public User(String name, String role, String email, String password, String status) {
		super(name,role,email,password ,status);
		
	}


	public String toString() {
		
		// Write your codes here
		String output = super.toString();
		output = String.format("%-63s %-20s", output);
		return output;
	}
}
