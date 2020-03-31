package ver04;

public class NormalAccount extends Account {
	
	int interestRate;//기본이자
	

	public NormalAccount(String accountNumber, String name, int balance, int interestRate) {
		super(accountNumber, name, balance);
		this.interestRate = interestRate;
	}
	
	@Override
	public void showAccount() {
		super.showAccount();
		System.out.println("기본이자> " + interestRate + "%");
	}

}
