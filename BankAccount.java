
import java.util.Scanner;

public class BankAccount {

    private String accountNumber;
    private String accountHolder;
    private String accountType;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.accountType = accountType;
        this.balance = balance;
    }

    public void deposit(double amount) {
        double limit = 0;
        String accType = getAccountType();
        switch (accType) {
            case "Checking":
                limit += 20000;
            case "Savings":
                limit += 8000;
            case "Current":
                limit += 30000;
            default:
                break;
        }

        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than 0.");
            return;
        }
        if (amount > limit) {
            System.out.println("Deposit failed! The limit for " + accountType + " account is $" + limit);
        } else {
            balance += amount;
            System.out.println("Deposited: $" + amount);
            System.out.println("New Balance: $" + balance);
        }
    }

    public void withdraw(double amount) {
        double limit = 0;
        String accType = getAccountType();
        switch (accType) {
            case "Checking":
                limit += 15000;
            case "Savings":
                limit += 5000;
            case "Current":
                limit += 20000;
            default:
                break;
        }

        if (amount <= 0) {
            System.out.println("Withdraw amount must be greater than 0.");
            return;
        }
        if (amount > limit) {
            System.out.println("Withdrawal failed! The limit for " + accountType + " account is $" + limit);
        } else {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
            System.out.println("Remaining Balance: $" + balance);
        }
    }

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

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        BankAccount account1 = new BankAccount("201514026", "Josie Rizal", "Savings", 5000);
        BankAccount account2 = new BankAccount("202015472", "John Dela Cruz", "Checking", 50000);
        BankAccount account3 = new BankAccount("202451635", "Gabriella Silang", "Current", 1000000);

        BankAccount[] accounts = {account1, account2, account3};

        System.out.println("Welcome to ABC Bank ATM!");
        System.out.print("Please Enter your Account Number: ");
        String enterAccountNumber = scan.next();

        if (enterAccountNumber.equalsIgnoreCase("CANCEL")) {
            System.out.println("Proccess stopped by user.");
            System.exit(0);
        }

        BankAccount activeAccount = null;
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(enterAccountNumber)) {
                activeAccount = acc;
                break;
            }
        }

        if (activeAccount != null) {
            String choice;
            do {
                System.out.println("\nWelcome, " + activeAccount.getAccountHolder());
                System.out.println("--------------------");
                
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Close Account");
                System.out.println("5. Exit");
                System.out.println("Enter a task: ");
                choice = scan.next();

                switch (choice) {
                    case "1":
                        System.out.println("Enter amount to Deposit: ");
                        double deposit = scan.nextDouble();
                        activeAccount.deposit(deposit);
                        break;
                    case "2":
                        System.out.println("Enter amount to Withdraw: ");
                        double withdraw = scan.nextDouble();
                        activeAccount.withdraw(withdraw);
                        break;
                    case "3":
                        activeAccount.checkBalance();
                        break;
                    case "4":
                        activeAccount.closeAccount();
                        break;
                    case "5":
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } while (!choice.equals("5"));

            scan.close();
        }
        else {
            System.out.println("Invalid account number!");
        }
    }
}
