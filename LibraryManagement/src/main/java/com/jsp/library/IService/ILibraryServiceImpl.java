package com.jsp.library.IService;

import java.sql.Date;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.library.IDAO.ILibraryDAO;
import com.jsp.library.entity.Librarymanagement;
@Service("libraryService")
public class ILibraryServiceImpl implements ILibraryService 
{
	Scanner sc = new Scanner(System.in);
	@Autowired
	private ILibraryDAO dao;
	
	@Override
	public void addBook() {
		Librarymanagement lib = new Librarymanagement();
		
		System.out.print("Enter Book Id : ");
		lib.setBook_Id(sc.nextInt());
		System.out.print("Enter Book Name : ");
		lib.setBook_Name(sc.next());
		System.out.print("Enter Book Author : ");
		lib.setBook_Author(sc.next());
		System.out.print("Enter published Date : ");
		Date d = Date.valueOf(sc.next());
		lib.setPublished_Date(d);
		System.out.print("Enter No - Of Books : ");
		lib.setNo_of_Books(sc.nextInt());
		System.out.print("Enter Libarary Name : ");
		lib.setLibrary_Name(sc.next());
		
		dao.addBooks(lib);
		
		
	}

}
