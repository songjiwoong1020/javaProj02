package ver05;

import java.util.Scanner;

public class Account extends ConnectImpl  {
	
	Scanner scanner = new Scanner(System.in);
	
	public Account(String id, String pass) {
		super(id, pass);
	}
	
	public void login() {
		
//		System.out.println("test진입");
		try {
			String query = "select count(*) from all_tables where banking_tb = upper('phonebook_tb')";
			
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(query);
			rs.next();
			
			int a = rs.getInt("count(*)");
			
			if(a == 0) {
				System.out.println("banking_tb 테이블이 없어서 종료합니다ㅠ.ㅠ");
				System.exit(0);
			} else if (a == 1) {
				System.out.println("테이블 존재");
			} else {
				System.out.println("나도 모르겟다.");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
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
	}
	public void depositMoney() {
		System.out.println("\n***입금***\n");
	}
	public void withdrawMoney() {
		System.out.println("\n***출금***\n");
	}
	public void showAccInfo() {
	}
}
