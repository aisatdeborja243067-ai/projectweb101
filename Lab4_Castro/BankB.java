package Lab4_Castro;

//Initialization of class Inheritance
public class BankB extends MainBank {

    //Initialization of inherited members
    BankB(String accountNumber, String accountHolder, String accountType, double balance) {
        super(accountNumber, accountHolder, accountType, balance);
    }

    @Override
    public void deposit(double amount) {
        double limit = 0;
        String accType = getAccountType();
        switch (accType) {
            case "Checking":
                limit += 15000;
            case "Savings":
                limit += 10000;
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

    @Override
    public void withdraw(double amount) {
        double limit = 0;
        String accType = getAccountType();
        switch (accType) {
            case "Checking":
                limit += 20000;
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
}
