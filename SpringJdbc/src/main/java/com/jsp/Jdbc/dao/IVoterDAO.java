package com.jsp.Jdbc.dao;

import com.jsp.Jdbc.entity.Voter;

public interface IVoterDAO 
{

	void addVoter(Voter vtr);

	void updateNameById(int id, String name);
	
	void updateAgeByNameandId(int id,String name,int age);

	void updateGenderById(int id, String gender);
	
	void updateMobileByIdandName(int id, String name, String mobile);
	
	void updateAddressByIdnandMobile(int id, String mobile, String address);
	
	
	
	
	void deleteById(int id);
	
	void deleteByMobileandId(String mobile, int id);
	
	void deleteByNameandAddress(String name, String address);
	
	
	
	
	
	
	
	void displayVoterById(int id);

	

	void selectVoterByAge(int age);

	void selectVoterByAddress(String address);

	void selectAllVoters();

	

	

	

	

	
	

}
