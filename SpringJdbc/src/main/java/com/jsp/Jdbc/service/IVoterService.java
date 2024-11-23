package com.jsp.Jdbc.service;

public interface IVoterService 
{
	// Insertion Operation
	void register();
	
	// Updation Operation
	void updateNameById();
	void updateAgeByNameandId();
	void updateGenderById();
	void updateMobileByIdandName();
	void updateAddressByIdnadMobile();
	
	// Deletion Operation
	void deleteById();
	void deleteByMobileandId();
	void deleteByNameandAddress();
	
	
	void displayVoterById();

	void displayVoterByAge();
	void displayVoterByAddress();
	
	void displayAllVoters();

	


	
}
