package ver01;

import java.util.Scanner;

public class Account{
	
	String accountNumber;
	String name;
	int balance;
	int arrNum = 0;
	
	Scanner scanner = new Scanner(System.in);
	Account[] accountArr = new Account[50];
	

	public Account(String accountNumber, String name, int balance) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}
	
	public Account() {
		
	}
	
	public void showAccount() {
		System.out.println("----------");
		System.out.println("계좌번호 : " + accountNumber);
		System.out.println("고객이름 : " + name);
		System.out.println("잔고 : " + balance);
	}
	
	public void showMenu() {
		System.out.println("-----Menu-----");
		System.out.println("1. 계좌계설");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 전체계좌정보출력");
		System.out.print("5. 프로그램종료\n선택: ");
	}
	
	public void makeAccount() {
		System.out.println("\n***신규계좌개설***\n");
		while(true) {
			boolean a = true;
			System.out.print("계좌번호 : ");
			String makeAccountNumber = scanner.nextLine();
			for(int i=0; i<arrNum; i++) {
				if(accountArr[i].accountNumber.equals(makeAccountNumber)) {
					System.out.println("\n계좌 번호는 중복될 수 없습니다\n");
					a = false;
					break;
				} 
			}
			if(a) {
				System.out.print("고객이름 : ");
				String makeName = scanner.nextLine();
				System.out.print("잔고 : ");
				int makeBalance = scanner.nextInt();
				scanner.nextLine();
				accountArr[arrNum] = new Account(makeAccountNumber, makeName, makeBalance);
				arrNum++;
				System.out.println("\n계좌계설이 완료 되었습니다\n");
				break;
			}
		}
	}
	public void depositMoney() {
		
		System.out.println("\n***입금***\n");
		System.out.print("\n계좌번호를 입력하세요\n입력: ");
		String depositAccountNumber = scanner.nextLine();
			boolean a = true;
			for(int i=0; i<arrNum; i++) {
				if(accountArr[i].accountNumber.equals(depositAccountNumber)) {
					System.out.print("입금할 금액을 입력하세요\n입력: ");
					int in = scanner.nextInt();
					scanner.nextLine();
					accountArr[i].balance += in;
					System.out.println(in + "원이 입금 되었습니다\n");
					a = false;
					break;
				}
			}
			if(a) {
				System.out.println("\n일치하는 계좌번호가 없습니다.\n");
			}
	}
	public void withdrawMoney() {
		
		System.out.println("\n***출금***\n");
		System.out.print("\n계좌번호를 입력하세요\n입력: ");
		String depositAccountNumber = scanner.nextLine();
		boolean a = true;
		for(int i=0; i<arrNum; i++) {
			if(accountArr[i].accountNumber.equals(depositAccountNumber)) {
				System.out.print("출금할 금액을 입력하세요\n입력: ");
				int out = scanner.nextInt();
				scanner.nextLine();
				accountArr[i].balance -= out;
				System.out.println(out + "원이 출금 되었습니다\n");
				a = false;
				break;
			}
		}
		if(a) {
			System.out.println("\n일치하는 계좌번호가 없습니다.\n");
		}
	}
	public void showAccInfo() {
		System.out.println("\n***계좌정보출력***\n");
		for(int i=0; i<arrNum; i++) {
			accountArr[i].showAccount();
		}
		System.out.println("\n전체계좌정보 출력이 완료되었습니다\n");
	}
}
