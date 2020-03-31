package ver05;

import java.sql.SQLException;
import java.util.Scanner;

public class Account extends ConnectImpl  {
	
	Scanner scanner = new Scanner(System.in);
	
	public Account(String id, String pass) {
		super(id, pass);
	}
	
	public void test() {
		
		try {
			String query = "select count(*) from all_tables where table_name = upper('banking_tb')";
			
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
		try {
		String query = "INSERT INTO banking_tb VALUES (?, ?, ?)";
		
		psmt = con.prepareStatement(query);
		
		System.out.println("데이터 입력을 시작합니다..");
		System.out.print("계좌번호 : ");
		String accountNumber = scanner.nextLine();
		System.out.print("이름 : ");
		String name = scanner.nextLine();
		System.out.print("잔고 : ");
		String balance = scanner.nextLine();
		
		psmt.setString(1, accountNumber);
		psmt.setString(2, name);
		psmt.setString(3, balance);
		System.out.println(psmt.executeUpdate() + "행이 입력되었습니다.");
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void depositMoney() {
		System.out.println("\n***입금***\n");
		
		System.out.print("계좌 번호 : ");
		String acountN = scanner.nextLine();
		System.out.print("입금할 금액 : ");
		int money = scanner.nextInt();
		scanner.nextLine();
		
		String sql = "UPDATE banking_tb SET balance = balance + ? WHERE accountNumber = ?";
		try {
			psmt = con.prepareStatement(sql);
			
				psmt.setInt(1, money);
				psmt.setString(2, acountN);

				int affected = psmt.executeUpdate();
				System.out.println(affected +"행이 업데이트 되었습니다.");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void withdrawMoney() {
		System.out.println("\n***출금***\n");
		
		System.out.print("계좌 번호 : ");
		String acountN = scanner.nextLine();
		System.out.print("출금할 금액 : ");
		int money = scanner.nextInt();
		scanner.nextLine();
		
		String sql = "UPDATE banking_tb SET balance = balance - ? WHERE accountNumber = ?";
		try {
			psmt = con.prepareStatement(sql);
			
				psmt.setInt(1, money);
				psmt.setString(2, acountN);

				int affected = psmt.executeUpdate();
				System.out.println(affected +"행이 업데이트 되었습니다.");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	public void showAccInfo() {
		try {
			stmt = con.createStatement();
			
			String query = "SELECT * FROM banking_tb";
				
			rs = stmt.executeQuery(query);
			System.out.println("-계좌번호-    -이름-   -잔고-");
			while(rs.next()) {
				String accountNumber = rs.getString("accountNumber");
				String name = rs.getString("name");
				String balance = rs.getString("balance");
				System.out.printf("%-5s %-10s %-10s\n", accountNumber, name, balance);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
