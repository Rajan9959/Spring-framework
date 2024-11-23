package com.jsp.jpa.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.jpa.entity.User;
import com.jsp.jpa.repository.UserRepository;
@Repository("userDao")
public class IUserDaoImpl implements IUserDao
{
	@Autowired
	UserRepository repo;
	@Override
	public void add(User u) {
		repo.save(u);
		System.out.println("👉👉👉👉👉👉👉👉👉👉👉👉👉👉👉👉👉👉👉👉👉👉👉👉👉");
		System.out.println("$$$  DATA STORED SUCCESSFULLY 😍😍😍  $$$");
		System.out.println("👉👉👉👉👉👉👉👉👉👉👉👉👉👉👉👉👉👉👉👉👉👉👉👉👉");
		
	}
	
	@Override
	public List<User> fetchAll() {
		List<User> all = repo.findAll();
		//System.out.println(all);
		return all;
	}
	
	@Override
	public User updateLastNameById(String pwd, String lname) {
		// repo.getById(mobile);
		  Optional<User> opt = repo.findById(pwd);
		  if(opt.isPresent())
		  {
			  User u = opt.get();
			  u.setLastName(lname);
			  return repo.save(u);
			  
		  }
		  
		return null;
	}
	
	@Override
	public boolean removeById(String pwd) {
		
		if(repo.findById(pwd).isPresent())
		{
		repo.deleteById(pwd);
		return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public User fetchByFirstName(String fname) 
	{
		return repo.findByfirstName(fname);
	}
	
	@Override
	public List<User> fetchByDOB(String d1, String d2) {
		
		List<User> ls = (List<User>)repo.findBydobBetween(d1, d2);
		return ls;
	}
	
	@Override
	public User fetchByMobile(String mobile) 
	{
		return repo.findByMobile(mobile);
	}
	
	
	
//	@Override
//	public void deleteByEmailAndPassword(String email, String pwd) {
//		repo.deleteUserByemailandpassword(email, pwd);
//		System.out.println("DELETED");
//		
//	}
	
	
	
	

	

	

	



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


