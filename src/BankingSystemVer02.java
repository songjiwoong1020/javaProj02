import java.util.Scanner;

import ver02.Account;
import ver02.AccountManager;
import ver02.MenuChoice;

public class BankingSystemVer02  implements MenuChoice {

	public static void main(String[] args) {
		
		AccountManager accountManager = new AccountManager();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			accountManager.showMenu();
			int user = scanner.nextInt();
			scanner.nextLine();
			
			switch(user) {
			case make:
				accountManager.makeAccount();
				break;
			case deposit:
				accountManager.depositMoney();
				break;
			case withdraw:
				accountManager.withdrawMoney();
				break;
			case inquire:
				accountManager.showAccInfo();
				break;
			case exit:
				System.out.println("\n***종료합니다***\n");
				System.exit(0);
			}
			
			
		}
		
	}

}
