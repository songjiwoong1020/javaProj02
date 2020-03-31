package ver03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountManager implements CustomSpecialRate{
	
	Account[] accountArr = new Account[50];
	int arrNum = 0;
	Scanner scanner = new Scanner(System.in);

	public void showMenu() {
		System.out.println("arrNum = " + arrNum);
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
			try {
				System.out.println("----계좌선택----");
				System.out.println("1. 보통계좌");
				System.out.println("2. 신용 신뢰계좌");
				System.out.print("3. 뒤로가기\n선택: ");
				int select = scanner.nextInt();
				int makeBalance;
				int makeInterestRate;
				char makeCredit;
				scanner.nextLine();
				if(select == 1) {
					System.out.println("\n***보통계좌개설***\n");
					System.out.print("계좌번호 : ");
					String makeAccountNumber = scanner.nextLine();
					System.out.print("고객이름 : ");
					String makeName = scanner.nextLine();
					System.out.print("잔고 : ");
					makeBalance = make(scanner.nextInt());
					scanner.nextLine();
					System.out.print("기본이자%(정수형태로 입력) : ");
					makeInterestRate = make(scanner.nextInt());
					scanner.nextLine();
					accountArr[arrNum] = new NormalAccount(makeAccountNumber, makeName, makeBalance, makeInterestRate);
					arrNum++;
					System.out.println("\n보통계좌계설이 완료 되었습니다\n");
				} else if(select == 2) {
					System.out.println("\n***신용 신뢰계좌개설***\n");
					System.out.print("계좌번호 : ");
					String makeAccountNumber = scanner.nextLine();
					System.out.print("고객이름 : ");
					String makeName = scanner.nextLine();
					System.out.print("잔고 : ");
					makeBalance = make(scanner.nextInt());
					scanner.nextLine();
					System.out.print("기본이자%(정수형태로 입력) : ");
					makeInterestRate = make(scanner.nextInt());
					scanner.nextLine();
					System.out.print("신용등급(A,B,C등급) : ");
					makeCredit = make(scanner.next().charAt(0));
					accountArr[arrNum] = new HighCreditAccount(makeAccountNumber, makeName, makeBalance, makeInterestRate, makeCredit);
					arrNum++;
					System.out.println("\n신용 신뢰계좌계설이 완료 되었습니다\n");
				} else if(select == 3) break;
				else System.out.println("다시 입력하세요");
			}
			catch(MenuSelectException e) {
				System.out.println(e.getMessage());
			}
			catch(InputMismatchException e) {
				System.out.println("계좌 계설 부분에서 InputMismatchException 발생");
				scanner = new Scanner(System.in);
			}
		}
	}
	
	public void depositMoney() {
		
		try {
			System.out.println("\n***입금***\n");
			System.out.print("\n계좌번호를 입력하세요\n입력: ");
			String depositAccountNumber = scanner.nextLine();
			boolean a = true;
			for(int i=0; i<arrNum; i++) {
				//계좌번호와 일치하는지 확인
				if(accountArr[i].accountNumber.equals(depositAccountNumber)) {
					System.out.println("\n일치하는 계좌 존재\n");
					if(accountArr[i] instanceof HighCreditAccount) {
						System.out.println("\nHighCreditAccount 타입의 객체\n");
						double normal = (((HighCreditAccount)accountArr[i]).interestRate)*0.01;//기본이자
						char credit = (((HighCreditAccount)accountArr[i]).credit);
						double check;
						System.out.print("입금할 금액을 입력하세요(500원 단위만 가능)\n입력: ");
						int in = in(scanner.nextInt());
						scanner.nextLine();
						
						if(credit == 'A') {
							check = A;
							accountArr[i].balance = (int)((accountArr[i].balance*normal)
									+ (accountArr[i].balance*check) + in + accountArr[i].balance);
						} else if(credit == 'B') {
							check = B;
							accountArr[i].balance = (int)((accountArr[i].balance*normal)
									+ (accountArr[i].balance*check) + in + accountArr[i].balance);
						} else if(credit == 'C') {
							check = C;
							accountArr[i].balance = (int)((accountArr[i].balance*normal)
									+ (accountArr[i].balance*check) + in + accountArr[i].balance);
						}
						System.out.println(in + "원이 입금 되었습니다\n");
						a = false;
						break;
						
					} else if(accountArr[i] instanceof NormalAccount) {
						System.out.println("\nNormalAccount 타입의 객체\n");
						double normal = (((NormalAccount)accountArr[i]).interestRate)*0.01;
						
						System.out.print("입금할 금액을 입력하세요\n입력: ");
						int in = in(scanner.nextInt());
						scanner.nextLine();
						accountArr[i].balance = (int)((accountArr[i].balance*normal)+in+accountArr[i].balance);
						System.out.println(in + "원이 입금 되었습니다\n");
						a = false;
						break;
					}
				}
			}
			if(a) {
				System.out.println("\n일치하는 계좌번호가 없습니다.\n");
			}
		}catch(MenuSelectException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void withdrawMoney() {
		
		try {
			System.out.println("\n***출금***\n");
			System.out.print("\n계좌번호를 입력하세요\n입력: ");
			String depositAccountNumber = scanner.nextLine();
			boolean a = true;
			for(int i=0; i<arrNum; i++) {
				if(accountArr[i].accountNumber.equals(depositAccountNumber)) {
					System.out.print("출금할 금액을 입력하세요(1,000원 단위만 가능)\n입력: ");
					int out = out(scanner.nextInt());
					System.out.println("에러 미 발생시 진입");
					scanner.nextLine();
					if(accountArr[i].balance < out) {
						System.out.print("잔고가 부족합니다. 금액전체를 출금할까요?YES/NO\n> ");
						String lack;
						while(true) {
							lack = scanner.nextLine();
							if(lack.equalsIgnoreCase("YES")) {
								System.out.println(accountArr[i].balance + "원을 출금합니다.");
								accountArr[i].balance = 0;
								break;
							} else if(lack.equalsIgnoreCase("NO")) {
								System.out.println("넵");
								break;
							} else {
								System.out.println("yes, no 둘중 하나만 입력해주세요.\n> ");
							}
						}
						a = false;
					} else {
					accountArr[i].balance -= out;
					System.out.println(out + "원이 출금 되었습니다\n");
					a = false;
					break;
					}
				}
			}
			if(a) {
				System.out.println("\n일치하는 계좌번호가 없습니다.\n");
			}
		}
		catch(MenuSelectException e) {
			scanner.nextLine();
			System.out.println(e.getMessage());
		}
		catch(InputMismatchException e) {
			scanner.nextLine();
			System.out.println("출금에서 InputMismatchException발생");
		}
	}
	
	public void showAccInfo() {
		System.out.println("\n***계좌정보출력***\n");
		for(int i=0; i<arrNum; i++) {
			accountArr[i].showAccount();
		}
		System.out.println("\n전체계좌정보 출력이 완료되었습니다\n");
	}
	
	public int userNum(int user) throws MenuSelectException{
		
		if(user<1 || user>5) {
			MenuSelectException ex = new MenuSelectException();
			System.out.println("1~5범위 벗어남");
			throw ex;
		}
		
		return user;
		
	}
	
	public int make(int a) throws MenuSelectException{
		
		if(a<0) {
			MenuSelectException ex = new MenuSelectException();
			System.out.println("잔고와 이자는 음수를 입력 할 수 없습니다.");
			throw ex;
		}
		
		return a;
		
	}
	
	public char make(char a) throws MenuSelectException{
		
		if(!(a == 'A' || a == 'B' || a == 'C')) {
			MenuSelectException ex = new MenuSelectException();
			System.out.println("신용 등급은 A, B, C만 입력 가능합니다.(대문자만 ㅠㅠ)");
			throw ex;
		}
		
		return a;
		
	}
	
	public int in(int a) throws MenuSelectException{
		
		if(a<0) {
			MenuSelectException ex = new MenuSelectException();
			System.out.println("음수를 입금 할 수 없습니다.");
			throw ex;
		}

		if(!(a%500 == 0)) {
			MenuSelectException ex = new MenuSelectException();
			System.out.println("입금은 500원 단위로 가능합니다.");
			throw ex;
		}
		
		
		return a;
		
	}
	
	public int out(int a) throws MenuSelectException{
		
		if(a<0) {
			MenuSelectException ex = new MenuSelectException();
			System.out.println("음수를 출금 할 수 없습니다.");
			throw ex;
		}

		if(!(a%1000 == 0)) {
			MenuSelectException ex = new MenuSelectException();
			System.out.println("출금은 1000원 단위로 가능합니다.");
			throw ex;
		}
		
		
		return a;
		
	}
	
}
