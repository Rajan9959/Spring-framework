package org.jsp.watchManagement;

import java.util.Scanner; 

import org.jsp.watchManagement.service.WatchService;
import org.jsp.watchManagement.service.WatchServiceImpl;

public class WatchManagementSystem {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		WatchService service = new WatchServiceImpl();

		System.out.println("🙌🙌🙌🙌🙌🙌🙌🙌🙌🙌🙌🙌🙌🙌🙌🙌🙌🙌🙌🙌🙌🙌🙌🙌🙌🙌🙌🙌");
		System.out.println("-------------------------------------------------");
		System.out.println("                         ");
		String welcome = ("-- ❤️❤️❤️ WELCOME TO WATCH STORE ❤️❤️❤️ --\n");
		for (int i = 0; i < welcome.length(); i++) {
			System.out.print(welcome.charAt(i));
			Thread.sleep(100);
		}
		System.out.println("                ");
		System.out.println("--------------------------------------------------\n");
		System.out.println("___________________________________________________");
		
		
		while (true) {
			System.out.println("Enter 1 to : ADD WATCH");
			System.out.println("Enter 2 to : DISPLAY WATCH DETAILS");
			System.out.println("Enter 3 to : UPDATE NAME BY WATCH BRAND");
			System.out.println("Enter 4 to : DELETE WATCH BY WATCH BRAND");
			System.out.println("Enter 5 to : UPDATE MODEL BY WATCH BRAND");
			System.out.println("Enter 6 to : PRINT WATCH PRICE BY WATCH BRAND");
			System.out.println("Enter 7 to : ALTER WATCH MODEL BY WATCH BRAND AND NAME");
			System.out.println("Enter 8 to : DISPLAY WATCH BY WATCH BRAND");

			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				service.addWatch();
				break;

			case 2:
				service.displayWatch();
				break;

			case 3:
				service.changeNameOfWatch();
				break;

			case 4:
				service.deleteWatches();
				break;
				
			case 5:
				service.updateModelByBrand();
				break;

			case 8:
				System.out.println("Enter your Brand");
				service.displayWatchByBrand(sc.next());
				break;

			}

			System.out.println("😍😍😍 DO YOU WANT TO CONTINUE 😍😍😍");
			System.out.println("⏮️⏮️⏮️ Enter 'YES' (OR) 'NO' ⏭️⏭️⏭️");
			System.out.println("----------------------------------------");
			String choice1 = sc.next();
			if (choice1.equalsIgnoreCase("yes"))
				continue;
			else if (choice1.equalsIgnoreCase("no")) {
				System.out.println("👍👍😎😎 THANK YOU VISIT AGAIN 👍👍😎😎");
				break;
			} else {
				System.out.println("👍👍👍 GET LOST 👍👍👍");
				break;
			}

		}

	}
}
