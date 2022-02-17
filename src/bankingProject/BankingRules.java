package bankingProject;

public abstract class BankingRules {
	
	AccountDetails accountDetails = new AccountDetails();
	double newBalance;
	
	public boolean withdrawalLimit(int withdrawAmount) {
		if(withdrawAmount<=500) {
			return true;
		}
		return false;
		
	}
	
	public void noOfTransAllowed() {
		
	}
	
	public void pinChange() {
		
	}
	
	public abstract boolean userIdentification(String verID, String passOrPin);
	
	public void depositMoney(int depositMade) {
		newBalance = depositMade+accountDetails.getBalance();
		accountDetails.setBalance(newBalance);
		System.out.println("Hello "+accountDetails.getName()+" The new balance on the account is "+ accountDetails.getBalance());
	}

}
