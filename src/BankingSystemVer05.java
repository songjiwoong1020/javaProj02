import java.util.Scanner;

import ver05.Account;
import ver05.MenuChoice;

public class BankingSystemVer05  implements MenuChoice {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("id : ");
		String id = scanner.nextLine();
		System.out.print("pass : ");
		String pass = scanner.nextLine();
		
		Account account = new Account(id, pass);
		
		account.test();
		
		while(true) {
			
			account.showMenu();
			int user = scanner.nextInt();
			scanner.nextLine();
			
			switch(user) {
			case make:
				account.makeAccount();
				break;
			case deposit:
				account.depositMoney();
				break;
			case withdraw:
				account.withdrawMoney();
				break;
			case inquire:
				account.showAccInfo();
				break;
			case exit:
				account.close();
				System.out.println("\n***종료합니다***\n");
				scanner.close();
				System.exit(0);
			}
			
			
		}
		
	}

}
