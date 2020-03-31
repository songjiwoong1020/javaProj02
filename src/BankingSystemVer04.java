import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import ver04.AccountManager;
import ver04.MenuChoice;
import ver04.MenuSelectException;

public class BankingSystemVer04  implements MenuChoice {

	public static void main(String[] args) throws IOException{
		
		AccountManager accountManager = new AccountManager();
		Scanner scanner = new Scanner(System.in);
		
		accountManager.load();
		
		while(true) {
			try {
					
				accountManager.showMenu();
				int user = accountManager.userNum(scanner.nextInt());
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
					accountManager.save();
					System.exit(0);
				}
					
			}
			catch(MenuSelectException e) {
				System.out.println(e.getMessage());
			}
			catch(InputMismatchException e) {
				System.out.println("main에서 InputMismatchException 발생");
				scanner = new Scanner(System.in);
			}
		}
	}

}
