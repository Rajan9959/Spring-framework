package com.jsp.Jdbc.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.Jdbc.dao.IVoterDAO;
import com.jsp.Jdbc.entity.Voter;

@Service("voterService")
public class IVoterServiceImpl implements IVoterService

{
	Scanner sc = new Scanner(System.in);
	
	@Autowired
	private IVoterDAO dao;
	
	@Override
	public void register() 
	{
		Voter vtr = new Voter();
		System.out.print("Enter Voter Id--> ");
		
		int id = sc.nextInt();
		vtr.setVoter_Id(id);
//		if(id>999 && id<=9999)
//		{
//			vtr.setVoter_Id(id);
//		}
//		else
//		{
//			System.out.println("Enter Valid Id ( BETWEEN 100 TO 999)");
//		}
			
		
		System.out.print("Enter Voter Name --> ");
		sc.nextLine();
		vtr.setVoter_Name(sc.nextLine());
		System.out.print("Enter Voter Age --> ");
		
		int age = sc.nextInt();
		if(age >= 18)
		{
			vtr.setVoter_Age(age);
		}
		else
		{
			System.out.println("Sorry... Not Eligible for Voter");
		}
		
		
		System.out.print("Enter Voter Address --> ");
		sc.nextLine();
		vtr.setVoter_Address(sc.nextLine());
		System.out.print("Enter Voter Gender --> ");
		vtr.setVoter_Gender(sc.next());
		System.out.print("Enter Voter Mobile --> ");
		String mobile = sc.next();
		if(mobile.length()==10)
		{
			vtr.setVoter_Mobile(mobile);
		}
		else
		{
			
		}
		
		dao.addVoter(vtr);
	}

	@Override
	public void updateNameById()
	{
				
		System.out.println("Enter your Id : ");
		int id = sc.nextInt();
		System.out.println("Enter your Name : ");
		sc.nextLine();
		String name = sc.nextLine();
		dao.updateNameById(id,name);
		
	}

	@Override
	public void updateAgeByNameandId()
	{
		System.out.println("Enter Voter Id : ");
		int id = sc.nextInt();
		System.out.println("Enter Voter Name : ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.println("Enter Age : ");
		int age = sc.nextInt();
		dao.updateAgeByNameandId(id,name,age);
		
	}
	
	@Override
	public void updateGenderById()
	{
		System.out.println("Enter Voter Id ");
		int id = sc.nextInt();
		System.out.println("Enter Voter Gender ");
		String gender = sc.next();
		dao.updateGenderById(id,gender);
		
		
		
	}

	@Override
	public void updateMobileByIdandName() 
	{
		System.out.println("Enter Voter Id");
		int id = sc.nextInt();
		System.out.println("Enter Voter name");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.println("Enter New Mobile Number");
		String mobile = sc.next();
		dao.updateMobileByIdandName(id,name,mobile);
		
	}

	@Override
	public void updateAddressByIdnadMobile()
	{
		System.out.println("Enter Voter Id");
		int id = sc.nextInt();
		System.out.println("Enter Voter Mobile Number");
		String mobile = sc.next();
		System.out.println("Enter Voter New Address");
		sc.nextLine();
		String address = sc.nextLine();
		dao.updateAddressByIdnandMobile(id,mobile,address);
		
	}
	
	@Override
	public void deleteById()
	{
		System.out.println("Enter Voter id : ");
		int id = sc.nextInt();
		dao.deleteById(id);
	}

	@Override
	public void deleteByMobileandId() 
	{
		System.out.println("Enter voter Mobile ");
		String mobile = sc.next();
		System.out.println("Enter voter Id");
		int id = sc.nextInt();
		dao.deleteByMobileandId(mobile,id);
		
	}

	@Override
	public void deleteByNameandAddress() 
	{
		System.out.println("Enter voter Name");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.println("Enter voter Address");
		sc.nextLine();
		String address = sc.nextLine();
		dao.deleteByNameandAddress(name,address);
		
	}
	
	@Override
	public void displayVoterById() 
	{
		System.out.println("Enter Voter Id : ");
		int id = sc.nextInt();
		dao.displayVoterById(id);
	}
	
	@Override
	public void displayVoterByAge() 
	{
		System.out.println("Enter Voter Age : ");
		int age = sc.nextInt();
		dao.selectVoterByAge(age);
		
	}
	
	@Override
	public void displayVoterByAddress() 
	{
		System.out.println("Enter Voter Address : ");
		String address = sc.nextLine();
		dao.selectVoterByAddress(address);
		
	}
	
	@Override
	public void displayAllVoters() {
		dao.selectAllVoters();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
