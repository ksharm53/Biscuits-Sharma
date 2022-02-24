
package com.biscuit.models;
import java.util.Objects;

/**
 * @author ksharm53
 *
 */
public class RegisterTaiga{	

	public boolean accepted_terms;

	public String email;

	public String full_name;

	public String password;

	public String type;

	private String username;

	public RegisterTaiga() {
		super();
	}

	public RegisterTaiga(boolean accepted_terms, String email, String full_name, String password, String type,
			String username) {
		super();
		this.accepted_terms = accepted_terms;
		this.email = email;
		this.full_name = full_name;
		this.password = password;
		this.type = type;
		this.username = username;
	}



	public boolean getAcceptedTerms() {
		return accepted_terms;
	}

	public void setAcceptedTerms(boolean accepted_terms) {
		this.accepted_terms = accepted_terms;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return full_name;
	}
	public void setFullName(String full_name) {
		this.full_name = full_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accepted_terms, email, full_name, password, type, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegisterTaiga other = (RegisterTaiga) obj;
		return Objects.equals(accepted_terms, other.accepted_terms) && Objects.equals(email, other.email)
				&& Objects.equals(full_name, other.full_name) && Objects.equals(password, other.password)
				&& Objects.equals(type, other.type) && Objects.equals(username, other.username);
	}

}
