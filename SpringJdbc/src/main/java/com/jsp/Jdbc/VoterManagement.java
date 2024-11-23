package com.jsp.Jdbc;

import java.util.Arrays;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jsp.Jdbc.configuration.VoterConfig;
import com.jsp.Jdbc.service.IVoterService;

public class VoterManagement 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
        ApplicationContext context = new AnnotationConfigApplicationContext(VoterConfig.class);
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        IVoterService service = context.getBean("voterService", IVoterService.class);
        
        
        while(true)
        {
        	System.out.println("Enter 1 to : Registration -->>");
        	System.out.println("Enter 2 to : Update -->>");
        	System.out.println("Enter 3 to : Delete -->>");
        	System.out.println("Enter 4 to : Display -->>");
        	
        	switch(sc.nextInt())
        	{
        		case 1 : service.register(); 
        				 break;
        		case 2 : 
        		{
        			System.out.println("Press 1 to : Update Name By Id -->>");
        			System.out.println("Press 2 to : Update Age By Name and Id -->>");
        			System.out.println("Press 3 to : Update Gender By Id -->>");
        			System.out.println("Press 4 to : Update Mobile By Id and Name -->>");
        			System.out.println("Press 5 to : Update Address By Id and mobile -->>");
        			switch(sc.nextInt())
        			{
	        			case 1 : service.updateNameById();
	   				 			 break;
	        			case 2 : service.updateAgeByNameandId();
				 			 	 break;
	        			case 3 : service.updateGenderById();
				 			 	 break;
	        			case 4 : service.updateMobileByIdandName();
				 			 	 break;
	        			case 5 : service.updateAddressByIdnadMobile();
				 			 	 break;
	        			default : System.out.println("<<-- INVALID OPTION -->>");
			 		}
        			
        		}
        		break;
        			    			
        		case 3 : 
        			{
        				System.out.println("Press 1 to : Delete By Id -->>");
            			System.out.println("Press 2 to : Delete By Mobile and Id -->>");
            			System.out.println("Press 3 to : Delete By Name and Address -->>");
            			switch(sc.nextInt())
            			{
            				case 1 : service.deleteById();
            						 break;
            				case 2 : service.deleteByMobileandId();
            						 break;
            				case 3 : service.deleteByNameandAddress();
            						 break;
            				default : System.out.println("<<-- INVALID OPTION -->>");
            			}
        			}
        			break;
         
        		case 4 : 
        		{
        			System.out.println("Press 1 to : Display Voters By ID -->>");
        			System.out.println("Press 2 to : Display Voters By Age -->>");
        			System.out.println("Press 3 to : Display Voters By Address -->>");
        			System.out.println("Press 4 to : Display All Voters -->>");
        			switch(sc.nextInt())
        			{
	        			case 1 : service.displayVoterById();
				 			 	 break;
				 			 	 
	        			case 2 : service.displayVoterByAge();
		 			 	 		 break;
		 			 	 
	        			case 3 : service.displayVoterByAddress();
		 			 	 		 break;
		 			 	 		 
	        			case 4 : service.displayAllVoters();
        						 break;
			 			 
        				default : System.out.println("<<-- INVALID OPTION -->>");
        			}
        			
        		}
        		break;
        			
        				 
        		default : System.out.println("<<-- INVALID OPTION -->>");
        		
        	}
        	System.out.println("\n Do you want to Conitnue \n 'YES' (or) 'NO' ");
        	String value = sc.next();
        	if(value.equalsIgnoreCase("yes")) continue;
        	else if(value.equalsIgnoreCase("no")) 
        	{
        		System.out.println("~~ Thank you visit again ~~");
        		break;
        	}
        	else
        	{
        		System.out.println("\n :( Get lost ):");
        		break;
        	}
        }
        
        
        
    }
}
