package bankingProject;

public class Atm extends BankingRules implements StandardProcess{
	
	boolean verifyCredentials;

	AccountDetails accountDetails = new AccountDetails();
	@Override
	public void deposit(int depositMade) {
		System.out.println("Hello "+accountDetails.getName()+" The new balance on the account is "+ accountDetails.getBalance());
	}

	@Override
	public void withdraw(int withdrawAmount) {
		if (withdrawalLimit(withdrawAmount)) {
			double newBalance = accountDetails.getBalance()-withdrawAmount;
			accountDetails.setBalance(newBalance);
			System.out.println("Hello "+accountDetails.getName()+" The new balance on the account is "
					+ accountDetails.getBalance());
		}else {
			System.out.println("The maximum limit of withdrawal is 500");
		}
		
	}

	@Override
	public void fundTransfer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void investment(double deposit) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userIdentification(String verId, String passOrPin) {
		if (verId.equals(accountDetails.getAccountNumber())&&passOrPin.equals(accountDetails.getPin())) {
			return true;
		}
		return false;
	}



}
