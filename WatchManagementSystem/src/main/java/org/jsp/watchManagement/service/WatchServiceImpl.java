package org.jsp.watchManagement.service;

import java.util.List; 
import java.util.ListIterator;
import java.util.Scanner;

import org.jsp.watchManagement.dao.WatchDao;
import org.jsp.watchManagement.dao.WatchDaoImpl;
import org.jsp.watchManagement.entity.Watch;

public class WatchServiceImpl implements WatchService
{
	WatchDao dao = new WatchDaoImpl();
	
	Scanner sc = new Scanner(System.in);

	@Override
	public void addWatch() throws Exception 
	{			
		System.out.println("Enter WATCH BRAND");
		String brand = sc.next();
		System.out.println("Enter WATCH TYPE");
		String type = sc.next();
		System.out.println("Enter WATCH PRICE");
		double price = sc.nextDouble();
		System.out.println("Enter WATCH COLOR");
		String color = sc.next();
		System.out.println("Enter WATCH MODEL");
		String model = sc.next();
		
		Watch watch = new Watch();
		watch.setBrand(brand);
		watch.setType(type);
		watch.setPrice(price);
		watch.setColor(color);
		watch.setModel(model);
		
		dao.insertWatch(watch);

	}

	@Override
	public void displayWatch() throws Exception
	{
		List<Watch> list = dao.displayWatchDetails();
		if(list!=null)
		{
			ListIterator<Watch> iterator = list.listIterator();
			while (iterator.hasNext())
			{
				Watch watch = iterator.next();
				System.out.println("---+++++++++++++++++++++++++++++++++++++---");
				System.out.println("       $$$   WATCH DETAILS  $$$");
				System.out.println("---+++++++++++++++++++++++++++++++++++++---");
				System.out.println("Brand Name : "+watch.getBrand());
				System.out.println("Brand Type : "+watch.getType());
				System.out.println("Color : "+watch.getColor());
				System.out.println("Price : "+watch.getPrice());
				System.out.println("Model : "+watch.getModel());
				System.out.println("---+++++++++++++++++++++++++++++++++++++---");
				
			}
		}
	}

	@Override
	public void displayWatchByBrand(String brand)
	{
		List<Watch> list = dao.displayWatchByBrand(brand);
		ListIterator<Watch> iterator = list.listIterator();
		if (list.isEmpty()) 
		{
			System.out.println("NoWatch Found");
		} 
		else 
		{
			while(iterator.hasNext())
			{
				Watch watch = iterator.next();
				if (watch.getBrand().equalsIgnoreCase(brand))
				{
					System.out.println("Brand : "+watch.getBrand());
					System.out.println("Type : "+watch.getType());
					System.out.println("color : "+watch.getColor());
					System.out.println("price : "+watch.getPrice());
					System.out.println("model : "+watch.getModel());
				} 
				
				
			}
		}	
	}
	
	// DELETE WATCH PRODUCT BY BRAND.
	@Override
	public void deleteWatches() throws Exception
	{
		System.out.println("Enter WATCH BRAND");
		String brand = sc.next();
		if(dao.removeBrand(brand))
		{
			System.out.println("------------------------------------------------");
			System.out.println("👍👍👍👍 WATCH PRODUCT DELETED 👍👍👍👍");
		}
		else
		{
			System.out.println("---*** WATCH NOT FOUND ***---");
		}
		
	}	
	
	@Override
	public void changeNameOfWatch() throws Exception 
	{
		String oldBrand = checkBrand();
		if(oldBrand!=null)
		{
			System.out.println("$$$  Enter the new WATCH BRAND   $$$");
			String brand = sc.next();
			dao.updateNameByBrand(oldBrand,brand);
		}
		else
		{
			System.out.println("---*** WATCH BRAND NOT FOUND ***---");
		}
		
	}

	@Override
	public String checkBrand() throws Exception
	{
		System.out.println("$$$  Enter Your WATCH BRAND  $$$");
		String brand = sc.next();
		if(dao.findBrand(brand))
		{
			return brand;
		}
		else
		{
			return null;	
		}
	}

	@Override
	public void updateModelByBrand() throws Exception 
	{
		String oldBrand = checkBrand();
		if(oldBrand!=null)
		{
			System.out.println("$$$  Enter the NEW WATCH MODEL   $$$");
			String model = sc.next();
			dao.updateModelByBrand(oldBrand,model);
		}
		else
		{
			System.out.println("---*** WATCH BRAND NOT FOUND ***---");
		}
	}

	

}
