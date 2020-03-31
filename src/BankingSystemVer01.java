import java.util.Scanner;

import ver01.Account;
import ver01.MenuChoice;

public class BankingSystemVer01  implements MenuChoice {

	public static void main(String[] args) {
		
		Account account = new Account();
		Scanner scanner = new Scanner(System.in);
		
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
				System.out.println("\n***종료합니다***\n");
				System.exit(0);
			}
			
			
		}
		
	}

}
