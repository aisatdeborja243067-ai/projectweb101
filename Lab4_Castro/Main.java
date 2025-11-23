package Lab4_Castro;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Initiates all the bank account from Bank A and Bank B
        MainBank account1 = new BankA("201514026", "Josie Rizal", "Savings", 5000);
        MainBank account2 = new BankA("202015472", "John Dela Cruz", "Checking", 50000);
        MainBank account3 = new BankB("202451635", "Gabriella Silang", "Checking", 1000000);
        MainBank account4 = new BankB("202502209", "James Citro", "Current", 10000000);
        
        //Makes an array for all bank account
        MainBank[] accounts = {account1, account2, account3, account4};

        System.out.println("Welcome to ABC Bank ATM!");
        System.out.print("Please Enter your Account Number: ");
        String enterAccountNumber = scan.next();

        //Conditional statement for stopping the program
        if (enterAccountNumber.equalsIgnoreCase("CANCEL")) {
            System.out.println("Proccess stopped by user.");
            System.exit(0);
        }

        //Initiates activeAccount
        MainBank activeAccount = null;
        
        /*Loop to individually check the bank if the accounts from 
        the array match the entered account number*/
        for (MainBank acc : accounts) {
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
        } else {
            System.out.println("Invalid account number!");
        }
    }
}
