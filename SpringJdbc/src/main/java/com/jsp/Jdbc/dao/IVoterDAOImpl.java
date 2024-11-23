package com.jsp.Jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jsp.Jdbc.entity.Voter;

@Repository("voterDao")
public class IVoterDAOImpl implements IVoterDAO 
{
	@Autowired
	private JdbcTemplate template;
	//@Autowired
	private RowMapper<Voter> rm = new BeanPropertyRowMapper<Voter>(Voter.class);

	@Override
	public void addVoter(Voter vtr) 
	{
		String query = "insert into voters(voter_Id, voter_Name, voter_Age, voter_Address, voter_Gender, voter_Mobile) values(?,?,?,?,?,?)";
		template.update(query, vtr.getVoter_Id(), vtr.getVoter_Name(), vtr.getVoter_Age(), vtr.getVoter_Address(),
				vtr.getVoter_Gender(), vtr.getVoter_Mobile());

		System.out.println("\n%% VOTER ADDED ...!!!  %%");

	}

	@Override
	public void updateNameById(int id, String name) 
	{
		String update = "update voters set voter_Name=? where voter_Id=?";
		int result = template.update(update, name, id);
		if (result > 0) {
			System.out.println("\n <<-- VOTER NAME UPDATED -->>");
		} else {
			System.out.println("\n <<-- INVLID VOTER -->>");
		}
	}

	@Override
	public void updateAgeByNameandId(int id, String name, int age) 
	{
		String update = "update voters set voter_Age=? where voter_Name=? and voter_Id=?";
		int result = template.update(update, age, name, id);
		if (result > 0) {
			System.out.println("\n <<-- VOTER AGE UPDATED -->>");
		} else {
			System.out.println("\n <<-- INVLID VOTER -->>");
		}

	}

	@Override
	public void updateGenderById(int id, String gender)
	{
		String update = "update voters set voter_Gender=? where voter_Id=?";
		int result = template.update(update, gender, id);
		if (result > 0) {
			System.out.println("\n <<-- VOTER GENDER UPDATED -->>");
		} else {
			System.out.println("\n <<-- INVLID VOTER -->>");
		}

	}

	@Override
	public void updateMobileByIdandName(int id, String name, String mobile)
	{
		String update = "update voters set voter_Mobile=? where voter_Id=? and voter_Name=?";
		int result = template.update(update, mobile, id, name);
		if (result > 0) {
			System.out.println("\n <<-- VOTER MOBILE NUMBER UPDATED -->>");
		} else {
			System.out.println("\n <<-- INVLID VOTER -->>");
		}

	}

	@Override
	public void updateAddressByIdnandMobile(int id, String mobile, String address) 
	{
		String update = "update voters set voter_Address=? where voter_Id=? and voter_Mobile=?";
		int result = template.update(update, address, id, mobile);
		if (result > 0) {
			System.out.println("\n <<-- VOTER ADDRESS UPDATED -->>");
		} else {
			System.out.println("\n <<-- INVLID VOTER -->>");
		}
	}

	@Override
	public void deleteById(int id) 
	{
		String delete = "delete from voters where voter_Id=?";
		int result = template.update(delete, id);
		if (result > 0) {
			System.out.println("\n %%  ~~  VOTER DELETED SUCCESSFULLY ~~  %%");
		} else {
			System.out.println("\n INVALID CREDENTIALS ");
		}
	}

	@Override
	public void deleteByMobileandId(String mobile, int id) 
	{
		String delete = "delete from voters where voter_Mobile=? and voter_id=?";
		int result = template.update(delete, mobile, id);
		if (result > 0) {
			System.out.println("\n %%  ~~  VOTER DELETED SUCCESSFULLY ~~  %%");
		} else {
			System.out.println("\n INVALID CREDENTIALS ");
		}

	}

	@Override
	public void deleteByNameandAddress(String name, String address)
	{
		String delete = "delete from voters where voter_Name=? and voter_Address=?";
		int result = template.update(delete, name, address);
		if (result > 0) {
			System.out.println("\n %%  ~~  VOTER DELETED SUCCESSFULLY ~~  %%");
		} else {
			System.out.println("\n INVALID CREDENTIALS ");
		}

	}

	@Override
	public void displayVoterById(int id)
	{
		String select = "select * from voters where voter_Id=?";
		
		try
		{
			Voter v = template.queryForObject(select, rm,id);
			System.out.println(v);
			System.out.println("**********************************************");
		}
		catch(Exception e)
		{
			System.out.println("$$$$$$   VOTER NOT FOUND   $$$$$$");
		}
	}
	
	@Override
	public void selectVoterByAge(int age)
	{
		String select = "select * from voters where voter_Age=?";
		List<Voter> list = template.query(select, rm, age);
		list.forEach(System.out::println);
		System.out.println("---------------------------------");
		
	}
	
	@Override
	public void selectVoterByAddress(String address)
	{
		String select = "select * from voters where voter_Address=?";
		List<Voter> list = template.query(select, rm, address);
		if(!list.isEmpty())
		list.forEach(System.out::println);
		else
		System.out.println("###  NO VOTERS FOUND  ###");
		System.out.println("---------------------------------");
		
	}
	
	@Override
	public void selectAllVoters() {
		String select = "select * from voters";
		List<Voter> list = template.query(select, rm);
		list.forEach(System.out::println);
		System.out.println("**************------------------******************");
		
	}
	
	
	
	
	
	
	
	
	
}
