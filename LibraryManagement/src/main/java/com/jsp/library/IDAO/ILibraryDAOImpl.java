package com.jsp.library.IDAO;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Repository;

import com.jsp.library.entity.Librarymanagement;
import com.jsp.library.repository.UserRepository;
@Repository("libraryDao")
public class ILibraryDAOImpl implements ILibraryDAO 
{
	@Autowired
	UserRepository repo;
	@Override
	public void addBooks(Librarymanagement lib) 
	{
		repo.save(lib);
		System.out.println("Data stored");
	}
}


