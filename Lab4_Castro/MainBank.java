package Lab4_Castro;

public class MainBank {

    public String accountNumber;
    public String accountHolder;
    public String accountType;
    public double balance;

    public MainBank(String accountNumber, String accountHolder, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.accountType = accountType;
        this.balance = balance;
    }

    public void deposit(double amount) {}

    public void withdraw(double amount) {}

    public double checkBalance() {
        System.out.println("Current Balance: $" + balance);
        return balance;
    }

    public void closeAccount() {
        if (balance == 0) {
            System.out.println("Account " + accountNumber + " successfully closed.");
        } else {
            System.out.println("Account cannot be closed. Remaining balance: $" + balance);
        }
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }
}
