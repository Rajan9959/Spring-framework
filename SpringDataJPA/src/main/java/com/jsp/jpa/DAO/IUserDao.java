package com.jsp.jpa.DAO;

import java.util.List;

import com.jsp.jpa.entity.User;

public interface IUserDao {

	void add(User u);
	
	List<User> fetchAll();
	
	User updateLastNameById(String pwd, String lname);
	
	boolean removeById(String pwd);
	
	User fetchByFirstName(String fname);
	
	List<User> fetchByDOB(String d1, String d2);
	
	User fetchByMobile(String mobile);

	//void deleteByEmailAndPassword(String email, String password);


}
