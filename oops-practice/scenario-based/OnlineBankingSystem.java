package scenario_based;
import java.util.*;

class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException(String message){
		super(message);	
	}
}

interface BankService{
	
	void createAccount(Account acc);
 	double BalanceCheck(String AccNumber);
	void FundTransfer(String from , String to , double balance) throws InsufficientBalanceException;
}

abstract class Account{
	private String name;
	private double balance;
	private String accountNo;
	LinkedList<String> history =new LinkedList<>();
	
	Account(String name, double balance, String accountNo) {
		this.name = name;
		setBalance(balance);
		this.accountNo = accountNo;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public String getAcc() {
		return accountNo;
	}
	
	public void setBalance( double balance){
		if(balance>0) {
			this.balance=balance;
		}else {
			System.out.println("Invalid");
		}
	}
	
	void addTransaction(String msg) {
		history.add(msg);
	}
	
	public abstract double CalculateInterest();
	
	public void Deposit(double amount){
		balance=balance+amount;
		System.out.println("Money Deposited");
	}
	
	public synchronized void withdraw(double amount) throws InsufficientBalanceException{
		if(amount>balance){
			throw new InsufficientBalanceException("Insufficinet Balance");	
		}else {
			balance=balance-amount;
			System.out.println("Balance Withdrawn");
	        addTransaction("Withdrawn: " + amount);
		}
	}
}

class CurrentAccount extends Account{
	
	CurrentAccount(String name, double balance, String accountNo) {
		super(name, balance, accountNo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double CalculateInterest() {
		// TODO Auto-generated method stub
		return getBalance()*0.01;
	}
}

class SavingAccount extends Account{

	SavingAccount(String name, double balance, String accountNo) {
		super(name, balance, accountNo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double CalculateInterest() {
		// TODO Auto-generated method stub
		return getBalance()*0.05;
	}
}

class Bank implements BankService{
	HashMap<String, Account> h=new HashMap<>();
	
	@Override
	public void createAccount(Account acc) {
		// TODO Auto-generated method stub
		h.put(acc.getAcc(),acc);
	}

	@Override
	public double BalanceCheck(String AccNumber){
		// TODO Auto-generated method stub
		return h.get(AccNumber).getBalance();
	}

	@Override
	public void FundTransfer(String from, String to, double balance) throws InsufficientBalanceException {
		// TODO Auto-generated method stub
		Account account1=h.get(to);
		Account account2=h.get(from);
		synchronized(this) {
			try {
				account2.withdraw(balance);
				account1.Deposit(balance);
				 System.out.println("Transfer Successful: " + balance);
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}	
	}
}

public class OnlineBankingSystem {
	public static void main(String[] args) {
        Bank bank = new Bank();
        Account account1 = new SavingAccount("Harshita", 20000, "101");
        Account account2 = new CurrentAccount("Aman", 7000, "102");
        bank.createAccount(account1);
        bank.createAccount(account2);

        Thread t1 = new Thread(() -> {
            try {
				bank.FundTransfer("101", "102", 3000);
			} catch (InsufficientBalanceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });

        Thread t2 = new Thread(() -> {
            try {
				bank.FundTransfer("101", "102", 4000);
			} catch (InsufficientBalanceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        });
        t1.start();
        t2.start();
        System.out.println("Harshita's Balance: " + bank.BalanceCheck("101"));
        System.out.println("Aman's Balance: " + bank.BalanceCheck("102"));
    }

}