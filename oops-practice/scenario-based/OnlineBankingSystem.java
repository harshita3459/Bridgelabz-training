package scenario_based;
import java.util.ArrayList;

//Exception
class InsufficientBalanceException extends Exception {
	InsufficientBalanceException(String msg) {
     super(msg);
	}
}

// Abstraction 
interface BankService {
	void deposit(double amount);
    void withdraw(double amount) throws InsufficientBalanceException;
    void showBalance();
}

//OOP Base Class
abstract class Account implements BankService {
	int accountNumber;
    String holderName;
    double balance;
    ArrayList<String> transactions = new ArrayList<>();
    
    Account(int accountNumber, String holderName, double balance) {
     this.accountNumber = accountNumber;
     this.holderName = holderName;
     this.balance = balance;
    }

    abstract double calculateInterest();

     // synchronized for multithreading 
     public synchronized void deposit(double amount) {
    	 balance += amount;
         transactions.add("Deposited: " + amount);
     }

     public synchronized void withdraw(double amount) throws InsufficientBalanceException {
    	 if(amount>balance) {
         throw new InsufficientBalanceException("Insufficient Balance!");
     }
     balance -= amount;
     transactions.add("Withdrawn: ₹" + amount);
     }

     public void showBalance() {
    	 System.out.println("Balance: ₹" + balance);
     }

     void showTransactions() {
    	 System.out.println("Transaction History:");
         for (String t : transactions) {
        	 System.out.println(t);
         }
     }
}

// Inheritance
class SavingsAccount extends Account {
	SavingsAccount(int accNo, String name, double balance) {
		super(accNo, name, balance);
	}

    double calculateInterest() {
    	return balance * 0.04;
    }
}

class CurrentAccount extends Account {
	CurrentAccount(int accNo, String name, double balance) {
		super(accNo, name, balance);
	}

    double calculateInterest() {
    	return balance * 0.02;	
    }
}

// Service Class (CRUD)
class Bank {
	ArrayList<Account> accounts = new ArrayList<>();
	
    // CREATE
    void createAccount(Account acc) {
    	accounts.add(acc);
        System.out.println("Account created for " + acc.holderName);
    }

    // READ
    Account findAccount(int accNo) {
    	for(Account a : accounts) {
    		if(a.accountNumber == accNo) {
    			return a;
    		}
    	}
        return null;
    }

    // UPDATE (Transfer)
    void transfer(int fromAcc, int toAcc, double amount)
         throws InsufficientBalanceException {

         Account sender = findAccount(fromAcc);
         Account receiver = findAccount(toAcc);
         if(sender!=null && receiver!=null) {
        	 synchronized (this) {
             sender.withdraw(amount);
             receiver.deposit(amount);
             sender.transactions.add("Transferred ₹" + amount + " to " + toAcc);
             receiver.transactions.add("Received ₹" + amount + " from " + fromAcc);
         }
     }
 }
}

// Multithreading
class TransactionThread extends Thread {
 Account account;
 boolean deposit;
 double amount;

 TransactionThread(Account account, boolean deposit, double amount) {
     this.account = account;
     this.deposit = deposit;
     this.amount = amount;
 }

 public void run() {
     try {
         if (deposit) {
             account.deposit(amount);
         } else {
             account.withdraw(amount);
         }
     } catch (Exception e) {
         System.out.println(e.getMessage());
     }
 }
}

public class OnlineBankingSystem {
 public static void main(String[] args) {
     Bank bank = new Bank();
     Account account1 = new SavingsAccount(101, "Harshita", 5000);
     Account account2 = new CurrentAccount(102, "Amit", 3000);
     bank.createAccount(account1);
     bank.createAccount(account2);
     Thread t1 = new TransactionThread(account1, true, 2000);
     Thread t2 = new TransactionThread(account1, false, 1000);
     t1.start();
     t2.start();
     try {
         t1.join();
         t2.join();
     } catch (InterruptedException e) {}
     try {
         bank.transfer(101, 102, 1500);
     } catch (InsufficientBalanceException e) {
         System.out.println(e.getMessage());
     }
     System.out.println("\n--- Account Details ---");
     System.out.println("Savings Account Interest: ₹" + account1.calculateInterest());
     account1.showBalance();
     account1.showTransactions();
     System.out.println("\nCurrent Account Interest: ₹" + account2.calculateInterest());
     account2.showBalance();
     account2.showTransactions();
 }
}
