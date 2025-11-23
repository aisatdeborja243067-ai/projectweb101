package Lab4_Castro;

//Initialization of class Inheritance
public class BankA extends MainBank {

    //Initialization of inherited members
    BankA(String accountNumber, String accountHolder, String accountType, double balance) {
        super(accountNumber, accountHolder, accountType, balance);
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than 0.");
            return;
        }
        if (amount > 10000) {
            System.out.println("Deposit failed! The limit is $10000");
        } else {
            balance += amount;
            System.out.println("Deposited: $" + amount);
            System.out.println("New Balance: $" + balance);
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdraw amount must be greater than 0.");
            return;
        }
        if (amount > 10000) {
            System.out.println("Withdrawal failed! The limit is $10000");
        } else {
            balance += amount;
            System.out.println("Withdrew: $" + amount);
            System.out.println("New Balance: $" + balance);
        }
    }
}
