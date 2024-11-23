package com.jsp.jpa;

import java.util.Arrays;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jsp.jpa.configuration.JpaConfig;
import com.jsp.jpa.service.IUserService;

public class UserManagement 
{
    public static void main( String[] args ) throws Exception
    {
    	Scanner sc=new Scanner(System.in);
    	
        ApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        IUserService service = context.getBean("userService",IUserService.class);
        
		System.out.println("\n-*-- 🌸🌸🌸🌸🌸🌸🌸🌸🌸🌸🌸🌸🌸🌸🌸🌸🌸🌸🌸🌸🌸🌸 -*--");
		System.out.println("-------------------------------------------------------");
		System.out.print("          ");
		String welcome = "💐💐WELCOME TO User SHOP💐💐";
		for (int i = 0; i < welcome.length(); i++) {
			System.out.print(welcome.charAt(i));
			Thread.sleep(100);
		}
		System.out.println();
		System.out.println("-------------------------------------------------------\n");
		System.out.println("_______________________________________________________");

		while (true) {
			System.out.println("✌️✌️✌️ Press 1 to : Registation ->>");
			System.out.println("✌️✌️✌️ Press 2 to : DisplayAll ->>");
			System.out.println("✌️✌️✌️ Press 3 to : update User Last Name By Id [ PASSWORD ]  ->>");
			System.out.println("✌️✌️✌️ Press 4 to : delete User by id [ PASSWORD ] ->>");
			System.out.println("✌️✌️✌️ Press 5 to : Display User By firstName ->>");
			System.out.println("✌️✌️✌️ Press 6 to : Display Users BETWEEN DATES ->>");
			System.out.println("✌️✌️✌️ Press 7 to : Display User By Mobile Number ->>");
			System.out.println("✌️✌️✌️ Press 8 to : Display User By email and password ->>");
			
			int choice = sc.nextInt();			
			switch (choice) {
			case 1:
				service.register();
				break;
			case 2:
				service.displayAll();
				break;
			case 3:
				service.changeLastNameById();
				break;
			case 4:
				service.removeUserById();
				break;
			case 5:
				service.displayByFirstName();
				break;	
			case 6:
				service.displayUserBetweenDOB();
				break;
			case 7:
				service.displayByMobile();
				break;
			case 8:
				//service.removeUserByEmailAndPassword();
				break;	
			}
			System.out.println("\n 🤔🤔🤔 DO YOU WANT TO CONTINUE 🤔🤔🤔");
			System.out.println("** Say 'YES' (OR) 'NO' **");
			String choice1 = sc.next();
			if (choice1.equalsIgnoreCase("yes"))
				continue;
			else if (choice1.equalsIgnoreCase("no")) {
				System.out.println("\n 🙏🙏🙏THANK YOU VISIT AGAIN🙏🙏🙏");
				break;
			} else {
				System.out.println("\n GET LOST👉👉👉");
				break;
			}
		}

        
        
        
        //service.displayByMobile();
        //service.displayUserBetweenDOB();
        //service.deleteByEmailAndPassword();
    }
}
