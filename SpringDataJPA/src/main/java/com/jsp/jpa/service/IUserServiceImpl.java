package com.jsp.jpa.service;

import java.sql.Date; 
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.jpa.DAO.IUserDao;
import com.jsp.jpa.entity.User;

@Service("userService")
public class IUserServiceImpl implements IUserService
{
	Scanner sc = new Scanner(System.in);
	@Autowired
	private IUserDao dao;
	@Override
	public void register()
	{
		User u = new User();
		System.out.print("Enter First Name : ");
		u.setFirstName(sc.next());
		System.out.print("Enter Last Name : ");
		u.setLastName(sc.next());
		System.out.print("Enter User Mobile : ");
		u.setMobile(sc.next());
		System.out.print("Enter User Password : ");
		u.setPassword(sc.next());
		System.out.print("Enter User Email : ");
		u.setEmail(sc.next());
		System.out.print("Enter DOB(yyyy-mm-dd) : ");
		Date d = Date.valueOf(sc.next());
		u.setDob(d);
		
		dao.add(u);
		
	}
	
	@Override
	public void displayAll() {
		
		List<User> ls=dao.fetchAll();
		if(!ls.isEmpty())
		{
			System.out.println("__________________________________________");
			System.out.println("--- ***  ALL USER DETAILS  *** ---");
			System.out.println("__________________________________________");
			
			ListIterator<User> it = ls.listIterator();
			while(it.hasNext())
			{
				User u=it.next();
				Date d=u.getDob();
				//System.out.println(u.getFirstName()+"|"+u.getLastName()+"|"+u.getEmail()+"|"+u.getMobile()+"|"+u.getDob()+"|"+"|"+u.getPassword());
				System.out.println(" ");
				System.out.println(u);
				System.out.println("__________________________________________");
			}
		}
		else {
			System.out.println("__________________________________________");
			System.out.println(" 😓😓😓 SORRY NO USER FOUND 😓😓😓");
			System.out.println("__________________________________________");
		}
	}
	
	@Override
	public void changeLastNameById() {
		System.out.println("Enter User Password");
		String pwd=sc.next();
		System.out.println("Enter New User Last Name ");
		String lname=sc.next();
		
		User u=dao.updateLastNameById(pwd,lname);
		System.out.println(u);
		if(u!=null) {
			System.out.println("____________________________");
			System.out.println(" USER Last Name updated ");
			System.out.println("____________________________");
		}
		else {
			System.out.println("____________________________");
			System.out.println("NO USER FOUND ");
			System.out.println("____________________________");
		}
	}
	
	@Override
	public void removeUserById() {
		
		System.out.println("Enter User Password");
		String pwd=sc.next();
		
		if(dao.removeById(pwd))
		{	System.out.println("____________________________");
				System.out.println(" USER REMOVED ");
				System.out.println("____________________________");
		}
		else {
			System.out.println("____________________________");
			System.out.println("NO USER FOUND ");
			System.out.println("____________________________");
		}
		
	}
	
	@Override
	public void displayByFirstName()
	{
		System.out.print("Enter First Name : ");
		String fname = sc.next();
		User user = dao.fetchByFirstName(fname);
		if (user!=null)
		{
			System.out.println("----------------------------------------------");
			System.out.println(user);
			System.out.println("----------------------------------------------");
			
		} 
		else
		{
			System.out.println("----------------------------------------------");
			System.out.println("NO USER FOUND WITH GIVEN FIRST NAME");
			System.out.println("----------------------------------------------");
		}
		
	}
	
	@Override
	public void displayUserBetweenDOB()
	{
		System.out.println("Enter starting DOB");
		String d1 = sc.next();
		System.out.println("Enter Ending DOB");
		String d2 = sc.next();
		List<User> user = dao.fetchByDOB(d1,d2);
		if (user!=null)
		{
			System.out.println("----------------------------------------------");
			System.out.println(user);
			System.out.println("----------------------------------------------");
			
		} 
		else
		{
			System.out.println("----------------------------------------------");
			System.out.println("NO USER FOUND BETWEEN GIVEN DOB");
			System.out.println("----------------------------------------------");
		}
		
	}
	
	@Override
	public void displayByMobile() 
	{
		System.out.print("Enter User Mobile : ");
		String mobile = sc.next();
		User u = dao.fetchByMobile(mobile);
		if (u!=null)
		{
			System.out.println("----------------------------------------------");
			System.out.println(u);
			System.out.println("----------------------------------------------");
			
		} 
		else
		{
			System.out.println("----------------------------------------------");
			System.out.println("NO USER FOUND WITH GIVEN MOBILE NUMBER");
			System.out.println("----------------------------------------------");
		}
	}
	
	
	
//	@Override
//	public void deleteByEmailAndPassword() 
//	{
//		System.out.print("Enter User Email id : ");
//		String email = sc.next();
//		System.out.print("Enter User Email : ");
//		String pwd = sc.next();
//		dao.deleteByEmailAndPassword(email,pwd);
//		
//	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
