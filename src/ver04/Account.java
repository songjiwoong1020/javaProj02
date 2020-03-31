package ver04;

import java.io.Serializable;

abstract class Account implements Serializable{
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Account account = (Account)obj;
		
		if(this.accountNumber.equals(account.accountNumber)) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
	
}
