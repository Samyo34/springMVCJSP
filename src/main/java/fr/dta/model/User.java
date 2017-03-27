package fr.dta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="userr")
public class User extends AbstractEntity{

	@Min(0)
	@Id	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@NotNull
	@Size(max=30)
	@Column(name="firstname")
	private String firstName;
	@NotNull
	@Size(max=30)
	@Column(name="name")
	private String name;
	@NotNull
	@Size(max=30)
	@Column(name="lastname")
	private String lastName;
	@Email
	@Column(name="email")
	private String email;
	@Length(min=8)
	@Column(name="password")
	@NotBlank
	private String password;
	@NotBlank
	@Pattern(regexp = "[0-9a-z]{4,}")
	@Column(name="login")
	private String login;
	
	@Override
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", login=" + login + "]";
	}
	
}
