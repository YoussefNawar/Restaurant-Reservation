package Logic;

import java.util.Objects;

/**
 * @author Youssef
 *
 */
public abstract class User {
	private String name;
	private String role;
	private String username;
	private String password;

	@Override
	public String toString() {
		return "Name=" + name + ", Role=" + role + ", Username=" + username + ",Password=" + password ;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(name, user.name) &&
				Objects.equals(role, user.role) &&
				Objects.equals(username, user.username) &&
				Objects.equals(password, user.password);
	}
}
