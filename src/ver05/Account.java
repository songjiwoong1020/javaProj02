package ver05;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
잔고에 음수가 들어가는 경우를 처리하지 못했습니다...
시간 날 때 천천히 해보겠습니다.
테이블 생성시 시퀀스도 같이 생성해주고 싶었는데 영상만드는게 우선이라 못했습니다..
 */
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
				System.out.println("banking_tb 테이블이 존재하지 않습니다.\n새로 만드시겠습니까?(Yes/No)\n>");
				while(true) {
					try {
						String tableSet = scanner.nextLine();
						if(tableSet.equalsIgnoreCase("YES")) {
							
							stmt = con.createStatement();
							String createTable = "create table banking_tb(\r\n" + 
									"    num number(30),\r\n" + 
									"    accountnumber varchar2(30) primary key,\r\n" + 
									"    name varchar2(30) not null,\r\n" + 
									"    balance number(30) not null\r\n" + 
									")";
							
							rs = stmt.executeQuery(createTable);
							System.out.println("테이블생성 완료");
							
							break;
						} else if(tableSet.equalsIgnoreCase("NO")) {
							System.out.println("banking_tb테이블이 없으면 실행 할 수없습니다.");
							System.out.println("프로그램을 종료합니다.");
							System.exit(0);
						} else {
							System.out.println("Yes or No\n>");
						}
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
				
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
		while(true) {
			try {
			String query = "INSERT INTO banking_tb VALUES (seq_banking.nextval, ?, ?, ?)";
			
			psmt = con.prepareStatement(query);
			
			System.out.println("데이터 입력을 시작합니다..");
			System.out.print("계좌번호 : ");
			String accountNumber = scanner.nextLine();
			System.out.print("이름 : ");
			String name = scanner.nextLine();
			System.out.print("잔고 : ");
			int balance = scanner.nextInt();
			scanner.nextLine();
			
			psmt.setString(1, accountNumber);
			psmt.setString(2, name);
			psmt.setInt(3, balance);
			System.out.println(psmt.executeUpdate() + "행이 입력되었습니다.");
			break;
			}
			catch(InputMismatchException e) {
				scanner.nextLine();
				System.out.println("잔고는 정수만 입력 가능");
			}
			catch(SQLIntegrityConstraintViolationException e) {
				System.out.println("계좌번호 중복 혹은 모든 항목 null값 저장 불가능.");
			}
			catch(Exception e) {
				System.out.println("모르겠다");
				e.printStackTrace();
			}
		}
	}
	public void depositMoney() {
		System.out.println("\n***입금***\n");
		
		
		while(true) {
			try {
				System.out.print("계좌 번호 : ");
				String accountN = scanner.nextLine();
				System.out.print("입금할 금액 : ");
				int money = scanner.nextInt();
				scanner.nextLine();
				
				String sql = "UPDATE banking_tb SET balance = balance + ? WHERE accountnumber = ?";
				psmt = con.prepareStatement(sql);
				
					psmt.setInt(1, money);
					psmt.setString(2, accountN);
	
					int affected = psmt.executeUpdate();
					if(affected == 0) {
						System.out.println("계좌번호가 잘못 되었습니다.");
						break;
					} else if(affected == 1) {
						System.out.println(money + "원이 " + accountN + "계좌로 입금되었습니다.");
						break;
					} else {
						System.out.println("?");
						break;
					}
			}
			catch(InputMismatchException e) {
				System.out.println("금액은 정수만 입력 가능합니다.");
				scanner.nextLine();
			}
			catch(Exception e) {
				System.out.println("그 외 오류 ㅠ.ㅠ");
				e.printStackTrace();
			}
		}
		
		
	}
	
	public void withdrawMoney() {
		System.out.println("\n***출금***\n");
		
		while(true) {
			try {
				System.out.print("계좌 번호 : ");
				String accountN = scanner.nextLine();
				System.out.print("출금할 금액 : ");
				int money = scanner.nextInt();
				scanner.nextLine();
				
				String sql = "UPDATE banking_tb SET balance = balance - ? WHERE accountnumber = ?";
				psmt = con.prepareStatement(sql);
				
					psmt.setInt(1, money);
					psmt.setString(2, accountN);
	
					int affected = psmt.executeUpdate();
					if(affected == 0) {
						System.out.println("계좌번호가 잘못 되었습니다.");
						break;
					} else if(affected == 1) {
						System.out.println(money + "원이 " + accountN + "계좌로 출금되었습니다.");
						break;
					} else {
						System.out.println("?");
						break;
					}
			}
			catch(InputMismatchException e) {
				System.out.println("금액은 정수만 입력 가능합니다.");
				scanner.nextLine();
			}
			catch(Exception e) {
				System.out.println("그 외 오류 ㅠ.ㅠ");
				e.printStackTrace();
			}
		}
		
		
	}
	public void showAccInfo() {
		try {
			stmt = con.createStatement();
			
			String query = "SELECT * FROM banking_tb";
				
			rs = stmt.executeQuery(query);
			if(rs.next()) {//next()값이 존재하면 true...
				String accountNumber = rs.getString(2);
				String name = rs.getString(3);
				int balance = rs.getInt(4);
				System.out.println("-------------------");
				System.out.println("계좌 번호 : " + accountNumber);
				System.out.println("이름 : " + name);
				System.out.println("잔고 : " + balance);//첫번째 행을 보여 준 후
				while(rs.next()) {//나머지 행은 while문을 통해서 보여준다.
					accountNumber = rs.getString(2);
					name = rs.getString(3);
					balance = rs.getInt(4);
					System.out.println("-------------------");
					System.out.println("계좌 번호 : " + accountNumber);
					System.out.println("이름 : " + name);
					System.out.println("잔고 : " + balance);
				} 
			} else {//next()값이 첫 행부터 없다면 false값 반환
				System.out.println("입력된 정보가 없습니다.");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
