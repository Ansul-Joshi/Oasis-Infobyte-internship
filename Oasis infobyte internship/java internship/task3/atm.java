import java.util.ArrayList;
import java.util.Scanner;

public class atm {
    private static final int PIN = 1973;
    private static double balance = 1000.00;
    private static int userID;
    private static int recipientID;
    private static ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM!");
        System.out.println("Enter your user ID:");
        userID = scanner.nextInt();

        System.out.println("Enter your PIN:");
        int userPin = scanner.nextInt();

        if (userPin != PIN) {
            System.out.println("Incorrect PIN. Please try again.");
            scanner.close();
            return;
        }

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Check balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Transaction History");
            System.out.println("6. Quit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdraw(scanner);
                    break;
                case 3:
                    deposit(scanner);
                    break;
                case 4:
                    transfer(scanner);
                    break;
                case 5:
                    displayTransactionHistory();
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
        transactionHistory.add("Checked balance: $" + balance);
    }

    private static void withdraw(Scanner scanner) {
        System.out.println("Enter the amount you want to withdraw:");
        double amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient funds.");
            transactionHistory.add("Failed withdrawal attempt: Insufficient funds");
        } else {
            balance -= amount;
            System.out.println("You have withdrawn: $" + amount);
            System.out.println("Your new balance is: $" + balance);
            transactionHistory.add("Withdrawal: $" + amount);
        }
    }

    private static void deposit(Scanner scanner) {
        System.out.println("Enter the amount you want to deposit:");
        double amount = scanner.nextDouble();

        balance += amount;
        System.out.println("You have deposited: $" + amount);
        System.out.println("Your new balance is: $" + balance);
        transactionHistory.add("Deposit: $" + amount);
    }

    private static void transfer(Scanner scanner) {
        System.out.println("Enter the recipient's user ID:");
        recipientID = scanner.nextInt();
        System.out.println("Enter the amount to transfer:");
        double amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient funds.");
            transactionHistory.add("Failed transfer attempt: Insufficient funds");
        } else {
            balance -= amount;
            System.out.println("You have transferred: $" + amount + " to user ID " + recipientID);
            System.out.println("Your new balance is: $" + balance);
            transactionHistory.add("Transfer: $" + amount + " to user ID " + recipientID);
        }
    }

    private static void displayTransactionHistory() {
        System.out.println("\nTransaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}
