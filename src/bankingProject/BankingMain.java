package bankingProject;

import java.util.Scanner;

public class BankingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String userID = "";
		String passOrPin = "";
		int serviceChoice = 0;
		Scanner sc = new Scanner(System.in);
		BankingRules bankingRules = null;
		StandardProcess standardProcess = null;
		AccountDetails accountDetails = new AccountDetails();
		String choiceToContinue = "";
		System.out.println("Please enter the type of service that you want to use.");
		System.out.println("Press 1 for ATM and Press 2 for Online Banking");
		int modeChoice = sc.nextInt();
		if (modeChoice == 1) {
			bankingRules = new Atm();
			standardProcess = new Atm();
		} else if (modeChoice == 2) {
			bankingRules = new OnlineBanking();
			standardProcess = new OnlineBanking();
		} else {
			System.out.println("Please enter a valid choice");
		}
		for (int i = 0; i < 3; i++) {
			System.out.println("Please enter your Account Number or Username");
			userID = sc.next();
			System.out.println("Please enter your PIN Number");
			passOrPin = sc.next();
			if (bankingRules.userIdentification(userID, passOrPin)) {
				do {
					System.out.println("Please enter the service that you want to perform");
					System.out.println("Press 1 for deposit, 2 for withdrawal, 3 for fundTransfer and 4 for pinChange");
					serviceChoice = sc.nextInt();
					switch (serviceChoice) {
					case 1:
						System.out.println("Please enter the amount that you want to deposit: ");
						int depositMade = sc.nextInt();
						standardProcess.deposit(depositMade);
						break;
					case 2:
						standardProcess.withdraw();
						break;
					case 3:
						System.out.println("Please enter the ampunt that you want to transfer");
						int transferAmount = sc.nextInt();
						standardProcess.fundTransfer(transferAmount);
						break;
					case 4:
						String choice = "";
						do {
							System.out.println("Please enter new PIN");
							String newPin1 = sc.next();
							System.out.println("Please re-enter the new PIN");
							String newPin2 = sc.next();
							if (bankingRules.pinChange(newPin1, newPin2)) {
								accountDetails.setPin(newPin2);
								System.out.println("Your PIN has been set.");
								break;
							} else {
								System.out.println(
										"The PIN numbers entered does not match. Please press y if you want to try again.");
								choice = sc.next();
							}
						} while (choice.equals("y") || choice.equals("Y"));
						break;
					default:
						System.out.println("Please enter a valid choice.");
					}
					System.out.println("Please press Y if you want to complete another operation. "
							+ "Press anything else to exit.");
					choiceToContinue = sc.next();
				} while (choiceToContinue.equals("y") || choiceToContinue.equals("Y"));
				break;
			} else if (i == 2) {
				System.out.println("Account locked");
			} else {
				System.out.println("The Account Number or PIN is incorrect. Please enter again.");
			}

		}
		System.out.println("Thank you for using the application");
	}

}
