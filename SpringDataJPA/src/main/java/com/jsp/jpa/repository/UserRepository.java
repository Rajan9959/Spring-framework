package com.jsp.jpa.repository;

import java.sql.Date; 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.jpa.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, String> 
{
	// select * from User where first_Name=?
	public User findByfirstName(String fname);
	
	// select * from User where mobile=?
	public User findByMobile(String mobile);
	
	// select * from User where (dob=? and dob=?)
	public List<User> findBydobBetween(String startDate,String endDate);
	
	
	
	//public void deleteUserByemailandpassword(String mail,String password);
	
	

}
