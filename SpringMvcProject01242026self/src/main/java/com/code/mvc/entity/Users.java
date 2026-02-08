package com.code.mvc.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	// member Variable
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;
	@Column(name="first_name",length=50,nullable=false)
	private String firstName;
	@Column(name="last_name",length=50,nullable=false)
	private String lastName;
	@Column(name="gender",length=10,nullable=false)
	private String gender;
	@Column(name="languages",length=50,nullable=false)
	private String[] languages;
	@Column(name="email_id",length=50,nullable=false,unique=true)
	private String emailId;
	@Lob
	@Column(name="image_data")
	private byte[] imageData;
	@Column(name="country",length=50,nullable=false)
	private String country;
	@Column(name="password",length=20,nullable=false)
	private String password;
	@Column(name="role",length=20,nullable=false)
	private String role="Customer";
	
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getLanguages() {
		return languages;
	}
	public void setLanguages(String[] languages) {
		this.languages = languages;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getLanguagesToString() {
		return Arrays.toString(languages);
	}
	public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	@Override
	public String toString() {
		return "Users [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", languages="
				+ Arrays.toString(languages) + ", emailId=" + emailId + ", country=" + country + ", password="
				+ password + "]";
	}
	

}
