package com.jsp.Jdbc.entity;


public class Voter 
{
	
	private int voter_Id;
	private String voter_Name;
	private int voter_Age;
	private String voter_Address;
	private String voter_Gender;
	private String voter_Mobile;
	
	public Voter() 
	{
		
	}

	public void setVoter_Id(int voter_Id) {
		this.voter_Id = voter_Id;
	}

	public void setVoter_Name(String voter_Name) {
		this.voter_Name = voter_Name;
	}

	public void setVoter_Age(int voter_Age) {
		this.voter_Age = voter_Age;
	}

	public void setVoter_Address(String voter_Address) {
		this.voter_Address = voter_Address;
	}

	public void setVoter_Gender(String voter_Gender) {
		this.voter_Gender = voter_Gender;
	}

	public void setVoter_Mobile(String voter_Mobile) {
		this.voter_Mobile = voter_Mobile;
	}

	public int getVoter_Id() {
		return voter_Id;
	}

	public String getVoter_Name() {
		return voter_Name;
	}

	public int getVoter_Age() {
		return voter_Age;
	}

	public String getVoter_Address() {
		return voter_Address;
	}

	public String getVoter_Gender() {
		return voter_Gender;
	}

	public String getVoter_Mobile() {
		return voter_Mobile;
	}

	@Override
	public String toString() {
		return "Voter [voter_Id=" + voter_Id + ", voter_Name=" + voter_Name + ", voter_Age=" + voter_Age
				+ ", voter_Address=" + voter_Address + ", voter_Gender=" + voter_Gender + ", voter_Mobile="
				+ voter_Mobile + "]";
	}
	
	
	
	
	
}
