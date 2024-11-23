package org.jsp.watchManagement.dao;

import java.util.List; 

import org.jsp.watchManagement.entity.Watch;

public interface WatchDao 
{
	void insertWatch(Watch watch) throws Exception;
	
	List<Watch> displayWatchDetails() throws Exception;
	
	List<Watch> updateNameByBrand(String brand);
	
	List<Watch> displayWatchByBrand(String brand);
	
	
	
	
	boolean findBrand(String brand) throws Exception;

	void updateNameByBrand(String oldBrand, String brand) throws Exception;
	
	
	List<Watch> takeOld() throws Exception;

	void storeWatches(List<Watch> list) throws Exception;
	
	boolean removeBrand(String brand) throws Exception;

	void updateModelByBrand(String oldBrand, String model) throws Exception;

	
	
	
}
