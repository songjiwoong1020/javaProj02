package ver03;


abstract class Account{
	
	String accountNumber;
	String name;
	int balance;
	
	public Account() {
		
	}

	public Account(String accountNumber, String name, int balance) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}
	
	public void showAccount() {
		System.out.println("----------");
		System.out.println("계좌번호> " + accountNumber);
		System.out.println("고객이름> " + name);
		System.out.println("잔고> " + balance);
	}
	
}
