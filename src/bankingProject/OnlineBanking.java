package bankingProject;

public class OnlineBanking extends BankingRules implements StandardProcess{

	AccountDetails accountDetails = new AccountDetails();
	@Override
	public void deposit(int depositMade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdraw(int withdrawAmount) {
		// TODO Auto-generated method stub
		
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
		if (verId.equals(accountDetails.getUsername())&&passOrPin.equals(accountDetails.getPassword())) {
			return true;
		}
		return false;
	}



}
