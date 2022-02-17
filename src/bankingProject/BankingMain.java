package bankingProject;

import java.util.Scanner;

public class BankingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String userID = "";
		String passOrPin = "";
		int serviceChoice = 0;
		Scanner sc = new Scanner(System.in);
		BankingRules bankingRules;
		StandardProcess standardProcess;
		AccountDetails accountDetails = new AccountDetails();
		System.out.println("Please enter the type of service that you want to use.");
		System.out.println("Press 1 for ATM and Press 2 for Online Banking");
		int modeChoice = sc.nextInt();
		if (modeChoice == 1) {
			bankingRules = new Atm();
			standardProcess = new Atm();
			for (int i = 0; i < 3; i++) {
				System.out.println("Please enter your Account Number");
				userID = sc.next();
				System.out.println("Please enter your PIN Number");
				passOrPin = sc.next();
				if (bankingRules.userIdentification(userID, passOrPin)) {
					System.out.println("Please enter the service that you want to perform");
					System.out
							.println("Press 1 for deposit, 2 for withdrawal, 3 for fundTransfer and 4 for investment");
					serviceChoice = sc.nextInt();
					switch (serviceChoice) {
					case 1:
						System.out.println("Please enter the amount that you want to deposit: ");
						int depositMade = sc.nextInt();
						bankingRules.depositMoney(depositMade);
						break;
					case 2:
						System.out.println("Please enter the amount that you want to withdraw");
						int withdrawaAmount = sc.nextInt();
						standardProcess.withdraw(withdrawaAmount);
						
						break;
					}
				} else {
					System.out.println("The username or password is incorrect. Please enter again.");
				}
			}
		}

	}

}
