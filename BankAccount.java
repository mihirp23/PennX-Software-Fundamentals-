public class BankAccount {

    double balance = 0;
    String accountOwner;

    public void setOwner(String owner) {
        accountOwner = owner;
    }
    
    public void deposit(double amount) {
        balance += amount;
    }

    public void displayInfo() {
        System.out.println(  "Owner : " + accountOwner);
        System.out.println("Balance : " + Double.toString(balance));
    }

    public static void main (String [] args) {
        BankAccount myAccount = new BankAccount();
        myAccount.setOwner("John Doe");
        myAccount.deposit(1000.00);
        myAccount.displayInfo();
    
    }
} 
