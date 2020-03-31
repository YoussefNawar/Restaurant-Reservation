/**
 * @author Youssef
 *
 */
public class User {
	private String name;
	private String role;
	private String username;
	private String password;
	
	
	
	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", role=" + role + ", username=" + username + ", password=" + password + "]";
	}

	public User(String name, String role, String username, String password) {
		this.name = name;
		this.role = role;
		this.username = username;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
