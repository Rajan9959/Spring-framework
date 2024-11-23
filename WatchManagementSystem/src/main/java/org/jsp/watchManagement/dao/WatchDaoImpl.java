package org.jsp.watchManagement.dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import org.jsp.watchManagement.entity.Watch;

public class WatchDaoImpl implements WatchDao {
	Scanner sc = new Scanner(System.in);

	List<Watch> database = new ArrayList<Watch>();

	@Override
	public List<Watch> takeOld() throws Exception {
		File f = new File("watchmanagement.txt");
		if (!f.exists()) {
			f.createNewFile();
		}
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);

		return (List<Watch>) ois.readObject();
	}

	@Override // 1. TO ADD WATCH
	public void insertWatch(Watch watch) throws Exception {
		List<Watch> prs;
		try {
			prs = takeOld();
		} catch (EOFException e) {
			prs = new ArrayList<Watch>();
		}
		prs.add(watch);

		FileOutputStream fos = new FileOutputStream("watchmanagement.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(prs);
		oos.flush();
		oos.close();
		fos.close();

//		database.add(watch);
		System.out.println("***********************************************");
		System.out.println("👍👍👍 WATCH IS ADDED 👍👍👍");
		System.out.println("***********************************************\n");

	}

	@Override // 2. DISPLAY ALL WATCHES DETAILS
	public List<Watch> displayWatchDetails() throws Exception {
		List<Watch> ls = new ArrayList<Watch>();
		try {
			File f = new File("watchmanagement.txt");
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ls = (List<Watch>) ois.readObject();
			return ls;
		} catch (EOFException e) {
			System.out.println("***********************************************");
			System.out.println("NO WATCHES FOUND");
			System.out.println("***********************************************\n");
			return null;
		}

	}

	@Override // 3.UPDATE BRAND BY USING WATCH BRAND
	public List<Watch> updateNameByBrand(String brand) {
		return database;

	}

	@Override // 8.DISPLAY WATCH DETAILS BY WATCH BRAND
	public List<Watch> displayWatchByBrand(String brand) {
		return database;

	}

	@Override
	public void updateNameByBrand(String oldBrand, String brand) throws Exception {
		List<Watch> ls = displayWatchDetails();
		for (Watch w : ls) 
		{
			if (w.getBrand().equalsIgnoreCase(oldBrand )) 
			{
				w.setBrand(brand);
			}
		}
		storeWatches(ls);
		System.out.println("---$$$ BRAND UPDATED $$$---");
	}

	@Override
	public boolean findBrand(String brand) throws Exception {
		List<Watch> ls = displayWatchDetails();

		for (Watch watch : ls) {
			if (watch.getBrand().equalsIgnoreCase(brand)) {
				return true;
			}
		}
		return false;
	}

	public void storeWatches(List<Watch> list) throws Exception {
		File f = new File("watchmanagement.txt");
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(list);
		oos.flush();
		oos.close();
		fos.close();

	}
//	

	@Override
	public boolean removeBrand(String brand) throws Exception {
		List<Watch> ls = displayWatchDetails();
		ListIterator<Watch> it = ls.listIterator();
		boolean isFound = false;
		while (it.hasNext()) {
			Watch w = it.next();
			if (w.getBrand().equalsIgnoreCase(brand)) {
				it.remove();
				isFound = true;
			}
		}
		if (isFound) {
			storeWatches(ls);
		}
		return isFound;

	}

	@Override
	public void updateModelByBrand(String oldBrand, String model) throws Exception 
	{
		List<Watch> ls = displayWatchDetails();
		for (Watch w : ls) 
		{
			if (w.getBrand().equalsIgnoreCase(oldBrand )) 
			{
				w.setModel(model);
			}
		}
		storeWatches(ls);
		System.out.println("---$$$ WATCH MODEL UPDATED $$$---");
		
	}

}
