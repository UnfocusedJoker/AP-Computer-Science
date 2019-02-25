
public class BankAccount {
	private String name;
	private double balance;
	
	public BankAccount() {
		
	}
	
	public BankAccount(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}
	
	public double deposit(double x) {
		balance += x;
		return balance;
	}
	
	public double withdraw(double x) {
		balance -= x;
		return balance;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getBal() {
		return this.balance;
	}
	
	public String toString() {
		return "Bank Account Name: " + name + "\nBank Account Balance: " + balance;
	}
}
