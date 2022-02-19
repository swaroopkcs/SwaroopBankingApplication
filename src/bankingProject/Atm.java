package bankingProject;

import java.util.Scanner;

public class Atm extends BankingRules implements StandardProcess {

	boolean verifyCredentials;
	Scanner sc = new Scanner(System.in);

	AccountDetails accountDetails = new AccountDetails();

	@Override
	public void deposit(int depositMade) {
		newBalance = depositMade+accountDetails.getBalance();
		accountDetails.setBalance(newBalance);
		System.out.println("Hello " + accountDetails.getName() + " The new balance on the account is "
				+ accountDetails.getBalance());
	}

	@Override
	public void withdraw() {
		String choiceToTryAgain = "";
		int deposit;
		do {
			System.out.println("Please enter the amount that you want to withdraw");
			int withdrawAmount = sc.nextInt();
			if (withdrawAmount <= accountDetails.getBalance()) {
				if (withdrawalLimit(withdrawAmount)) {
					double newBalance = accountDetails.getBalance() - withdrawAmount;
					accountDetails.setBalance(newBalance);
					System.out.println("Hello " + accountDetails.getName() + " The new balance on the account is "
							+ accountDetails.getBalance());
					break;
				} else {
					System.out.println("The maximum limit of withdrawal is 500");
					System.out.println("Press y if you want to try another amount.");
					choiceToTryAgain = sc.next();
				}
			} else {
				System.out.println("You don't have enough funds available. Please deposit funds.");
				System.out.println("Please enter the amount that you want to deposit.");
				deposit = sc.nextInt();
				deposit(deposit);
			}
		} while (choiceToTryAgain.equals("y") || choiceToTryAgain.equals("Y"));

	}

	@Override
	public void fundTransfer() {
		String choiceToTryAgain = "";
		int deposit;
		do {
			System.out.println("Please enter the amount that you want to transfer");
			int transferAmount = sc.nextInt();
			if (transferAmount <= accountDetails.getBalance()) {
				if (fundTransferAllowed(transferAmount)) {
					double newBalance = accountDetails.getBalance() - transferAmount;
					accountDetails.setBalance(newBalance);
					System.out.println("Hello " + accountDetails.getName() + " The new balance on the account is "
							+ accountDetails.getBalance());
					break;
				} else {
					System.out.println("The maximum limit of fund transfer is 500");
					System.out.println("Press y if you want to try another amount.");
					choiceToTryAgain = sc.next();
				}
			} else {
				System.out.println("You don't have enough funds available. Please deposit funds.");
				System.out.println("Please enter the amount that you want to deposit.");
				deposit = sc.nextInt();
				deposit(deposit);
			}
		} while (choiceToTryAgain.equals("y") || choiceToTryAgain.equals("Y"));

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
