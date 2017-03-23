package fr.dta.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;


public class User {
	
	@NotNull
	@Min(0)
	private int id;
	@NotNull
	@Size(max=30)
	private String firstName;
	@NotNull
	@Size(max=30)
	private String lastName;
	@Email
	private String email;
	@Length(min=8)
	private String password;
	@Pattern(regexp = "[0-9a-z]{4,}")
	private String login;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	@Override
	public boolean equals(Object u){
		if(u instanceof User){
			return ((User)u).getId() == this.getId();
		}
		else{
			return false;
		}
		
	}
	
}
