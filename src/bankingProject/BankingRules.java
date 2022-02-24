package bankingProject;

public abstract class BankingRules extends AccountDetails implements StandardProcess{

	
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

	public boolean verPassChange(String newPin1, String newPin2) {
		if (newPin1.equals(newPin2)) {
			return true;
		}
		return false;
	}

	public abstract boolean userIdentification(String verID, String passOrPin);



}
