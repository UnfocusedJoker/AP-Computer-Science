
import java.util.Scanner;

public class Bank {
	private BankAccount[] banks = new BankAccount[5];
	private int numBank = 0, choice, keyInt;
	private Scanner scan = new Scanner(System.in);

	public static void main(String args[]) {
		Bank myBank = new Bank();
		myBank.openBank();
	}

	public Bank() {

	}

	public void openBank() {
		String userString;
		System.out.println("Hello, welcome to Dank Bank! Would you like to access the menu?");
		while (true) {
			userString = scan.nextLine();
			if (userString.equalsIgnoreCase("yes")) {
				while (true) {
					menu();
					if (choice == 3) {
						break;
					}
				}
				break;
			} else if (userString.equalsIgnoreCase("no")) {
				System.out.println("Okay!");
				break;
			} else {
				System.out.println("Please enter either yes or no.");
			}
		}
	}

	public void menu() {
		System.out.println("Banking Options\n1. Login\n2. Create Account\n3. Exit\nChoose an option!");
		choice = scan.nextInt();
		scan.nextLine();
		if (choice == 1) {
			login();
		} else if (choice == 2) {
			openAccount();
		} else if (choice == 3) {
			System.out.println("Thanks for using our system!");
		} else {
			System.out.println("Please enter a valid option!\n");
		}
	}

	public void login() {
		System.out.println("Please enter your name to access your account!");
		String enter1 = scan.nextLine();
		for (int i = 0; i < banks.length; i++) {
			if (banks[i] == null) {
				if (i == banks.length - 1) {
					System.out.println("This account does not exist!\n");
					break;
				}
				continue;
			} else if ((i == banks.length - 1) && !(enter1.equals(banks[i].getName()))) {
				System.out.println("This account does not exist!\n");
				break;
			} else if (!(enter1.equals(banks[i].getName()))) {
				continue;
			} else if (enter1.equals(banks[i].getName())) {
				keyInt = i;
				for (int z = 0; true; z++) {
					if (z == 0) {
						System.out.println("Welcome " + banks[i].getName() + "!");
					}
					System.out.println(
							"1. Close Account\n2. Deposit\n3. Withdraw\n4. Bank Balance\n5. Logout\nChoose an option!");
					int secChoice = scan.nextInt();
					scan.nextLine();
					if (secChoice == 1) {
						closeAccount();
						break;
					} else if (secChoice == 2) {
						deposit();
					} else if (secChoice == 3) {
						withdraw();
					} else if (secChoice == 4) {
						System.out.println(banks[i].getName() + "'s Balance: $" + banks[i].getBal());
					} else if (secChoice == 5) {
						logOut();
						break;
					} else {
						System.out.println("Please enter a valid option!\n");
					}
				}
				break;
			}
		}
	}

	public void openAccount() {
		System.out.println("What is your name?");
		String enter2 = scan.nextLine();
		boolean goAhead = false;
		for (int i = 0; i < banks.length; i++) {
			if (banks[i] == null && i != banks.length - 1) {
				continue;
			} else if ((banks[i] == null && i == banks.length - 1)
					|| !(banks[i].getName().equalsIgnoreCase(enter2)) && i == banks.length - 1) {
				goAhead = true;
			} else if (banks[i].getName().equalsIgnoreCase(enter2)) {
				System.out.println("An account with this name already exists!\n");
				break;
			}
		}
		if (goAhead == true) {
			for (int i = 0; i < banks.length; i++) {
				if (banks[i] == null) {
					banks[i] = new BankAccount(enter2, 0);
					System.out.println("Account created!\n");
					numBank++;
					break;
				} else if (i == banks.length - 1) {
					System.out.println("Banking system is full, you cannot create a new account.\n");
				}
			}
		}
	}

	public void closeAccount() {
		System.out.println("Are you sure you want to close your account?");
		String userString = scan.nextLine();
		while (true) {
			if (userString.equalsIgnoreCase("yes")) {
				banks[keyInt] = null;
				System.out.println("Account closed!\n");
				numBank--;
				break;
			} else if (userString.equalsIgnoreCase("no")) {
				System.out.println("Okay!\n");
				break;
			} else {
				System.out.println("Please only enter either yes or no.");
			}
		}
	}

	public void deposit() {
		System.out.println("How much would you like to deposit? (USD)");
		int dep = scan.nextInt();
		scan.nextLine();
		banks[keyInt].deposit(dep);
		System.out.println("$" + dep + " deposited!\n");
	}

	public void withdraw() {
		System.out.println("How much would you like to withdraw? (USD)");
		int with = scan.nextInt();
		scan.nextLine();
		if (with <= banks[keyInt].getBal() && with > 0) {
			banks[keyInt].withdraw(with);
			System.out.println("$" + with + " withdrawed!\n");
		} else if (with > banks[keyInt].getBal()) {
			System.out.println("Balance in account not sufficient!\n");
		} else {
			System.out.println("Please enter only positive values.");
		}
	}

	public void logOut() {
		System.out.println("You have logged out!\n");
	}
}
