package bankingProject;

public class AccountDetails {
	private String accountNumber = "1234567890123456";
	private String pin = "1234";
	private String username = "abc1234";
	private String password = "xyz4567";
	private String name = "User1";
	private double balance = 5431.24;
	String verId = "";
	String verPass = "";
	

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		if (pin.length() == 4) {
			this.pin = pin;
		} else if (pin.length() < 4) {
			System.out.println("The new PIN cannot be less than 4 digits");
		} else {
			System.out.println("The new PIN cannot be more than 4 digits");
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password.contains("&") || password.contains("@") || password.contains("$")) {
			System.out.println("Password cannot contain the characters &, @ or $");
			System.out.println("Password cannot be set");
		} else {
			System.out.println("Your password has been set");
			this.password = password;
		}
	}

}
