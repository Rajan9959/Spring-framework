package org.jsp.watchManagement.service;

public interface WatchService {
	
	// 1. ADD WATCH 
	void addWatch() throws Exception;
	
	// 2. DISPLAY ALL WATCH DETAILS 
	void displayWatch() throws Exception;
	
	// 8. DISPLAY WATCH BY BRAND
	void displayWatchByBrand(String brand);
	
	
	
	
	// CHANGE
	void changeNameOfWatch() throws Exception;
	
	String checkBrand() throws Exception;

	void deleteWatches() throws Exception;

	// 5. UPDATE MODEL BY BRAND
	void updateModelByBrand() throws Exception;
	
	
}
