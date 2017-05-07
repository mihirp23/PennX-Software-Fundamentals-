public class BankAccount {

    double balance;
    String owner;

    // deposit 
    public void deposit(double amount) {
        balance += amount;
    }

    // withdraw 
    public void withdraw(double amount) {
        balance -= amount;
    }

    // get balance
    public double getBalance() {
        return balance;
    }

    public static void main (String [] args) {
        BankAccount myAccount = new BankAccount();
        myAccount.deposit(1000.00);
        System.out.println(myAccount.getBalance());
    
    }
} 
