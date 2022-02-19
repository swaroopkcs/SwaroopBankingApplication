package bankingProject;

public abstract class BankingRules {

	AccountDetails accountDetails = new AccountDetails();
	double newBalance;

	public boolean withdrawalLimit(int withdrawAmount) {
		if (withdrawAmount <= 500) {
			return true;
		}
		return false;

	}

	public boolean fundTransferAllowed(int transferRequested) {
		if (transferRequested <= 500) {
			return true;
		}
		return false;
	}

	public boolean pinChange(String newPin1, String newPin2) {
		if (newPin1.equals(newPin2)) {
			return true;
		}
		return false;
	}

	public abstract boolean userIdentification(String verID, String passOrPin);



}
