package ver03;

public class HighCreditAccount extends NormalAccount implements CustomSpecialRate  {
	
	char credit;//추가이자

	public HighCreditAccount(String accountNumber, String name, int balance, int interestRate, char credit) {
		super(accountNumber, name, balance, interestRate);
		this.credit = credit;
	}
	
	@Override
	public void showAccount() {
		super.showAccount();
		System.out.println("신용등급> " + credit);
	}

}
