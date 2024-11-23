package com.jsp.jpa.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dob;
	@Column(unique = true,nullable = false)
	private String email;
	@Column(name = "firstName", unique = true,nullable = false)
	private String firstName;
	@Column(name = "lastName", unique = true,nullable = false)
	private String lastName;
	@Column(unique = true,nullable = false)
	private String mobile;
	@Id
	@Column(unique = true,nullable = false)
	private String password;

	public User() {
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date d) {
		this.dob = d;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [dob=" + dob + ", email=" + email + ", first_Name=" + firstName + ", last_Name=" + lastName
				+ ", mobile=" + mobile + ", password=" + password + "]";
	}

}