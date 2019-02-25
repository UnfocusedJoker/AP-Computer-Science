
import java.util.Scanner;

public class Bank2 {
	private BankAccount[] banks = new BankAccount[5];
	private int numBank = 0, count, choice, keyInt;
	private Scanner scan = new Scanner(System.in);

	public static void main(String args[]) {
		Bank2 myBank = new Bank2();
		myBank.openBank();
	}

	public Bank2() {

	}

	public void openBank() {
		String userString;
		System.out.println("Hello, welcome to Dank Bank! Would you like to access the menu?");
		while (true) {
			userString = scan.nextLine();
			if (userString.equalsIgnoreCase("yes")) {
				while (true) {
					menu();
					if (choice == 4) {
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
		System.out.println("Banking Options\n1. Login\n2. Create Account\n3. Display All Accounts\n4. Exit\nChoose an option!");
		choice = scanNextInt();
		scan.nextLine();
		if (choice == 1) {
			login();
		} else if (choice == 2) {
			openAccount();
		} else if (choice == 3) {
			// System.out.println("Under maintenance, check back later!\n");
			dispAcc();
		} else if (choice == 4) {
			System.out.println("Thanks for using our system!");
		} else if ((choice < 1 || choice > 4) && count == 0){
			System.out.println("Please enter a valid option!\n");
		}
	}
	
	public void dispAcc() {
		for (BankAccount x: banks) {
			System.out.println(x);
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
					int secChoice = scanNextInt();
					scan.nextLine();
					if (secChoice == 1) {
						closeAccount();
						break;
					} else if (secChoice == 2) {
						deposit();
					} else if (secChoice == 3) {
						withdraw();
					} else if (secChoice == 4) {
						balance();
					} else if (secChoice == 5) {
						logOut();
						break;
					} else if ((secChoice < 1 || secChoice > 5) && count == 0){
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
		int dep = scanNextInt();
		scan.nextLine();
		if (count == 0 && dep >= 0) {
			banks[keyInt].deposit(dep);
			System.out.println("$" + dep + " deposited!\n");
		} else if (count != 1) {
			System.out.println("You can only deposit nonnegative ammounts!");
		}
	}

	public void withdraw() {
		System.out.println("How much would you like to withdraw? (USD)");
		int with = scanNextInt();
		scan.nextLine();
		if (with <= banks[keyInt].getBal() && with > 0) {
			banks[keyInt].withdraw(with);
			System.out.println("$" + with + " withdrawed!\n");
		} else if (with > banks[keyInt].getBal()) {
			System.out.println("You will be charged an overdraft fee!!!\n");
			banks[keyInt].withdraw(with);
		} else if (with < 0 && count == 0) {
			System.out.println("Please enter only nonnegative values.");
		}
	}

	public void logOut() {
		System.out.println("You have logged out!\n");
	}
	
	public void balance() {
		if (banks[keyInt].getBal() >= 0) {
			System.out.println(banks[keyInt].getName() + "'s Balance: $" + banks[keyInt].getBal() + "\n");
		} else {
			System.out
					.println(banks[keyInt].getName() + "'s Balance: ($" + Math.abs(banks[keyInt].getBal()) + ")\n");
		}
	}

	public int scanNextInt() {
		try {
			count = 0;
			return scan.nextInt();
		} catch (Exception e) {
			System.out.println("Please enter a number!\n");
			count = 1;
			return -1;
		}
	}
}
