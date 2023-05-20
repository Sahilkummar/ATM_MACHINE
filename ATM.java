import java.util.Scanner;

public class ATM {
    private int balance;
    private int transactionCount;
    private String userId;
    private String userPin;

    public ATM(String userId, String userPin) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = 0;
        this.transactionCount = 0;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the ATM!");
        System.out.print("User ID: ");
        String enteredId = scanner.nextLine();
        System.out.print("User PIN: ");
        String enteredPin = scanner.nextLine();
        if (!enteredId.equals(userId) || !enteredPin.equals(userPin)) {
            System.out.println("Invalid user ID or PIN");
            return;
        }
        System.out.println("Welcome " + userId);
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. View Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    viewTransactionsHistory();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private void viewTransactionsHistory() {
        System.out.println("Transaction history:");
        System.out.println("Balance: " + balance);
        System.out.println("Transactions count: " + transactionCount);
    }

    private void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: ");
        int amount = scanner.nextInt();
        if (amount <= balance) {
            balance -= amount;
            transactionCount++;
            System.out.println("Withdrawal successful");
        } else {
            System.out.println("Insufficient balance");
        }
    }

    private void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to deposit: ");
        int amount = scanner.nextInt();
        balance += amount;
        transactionCount++;
        System.out.println("Deposit successful");
    }

    private void transfer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to transfer: ");
        int amount = scanner.nextInt();
        if (amount <= balance) {
            System.out.print("Enter the recipient's user ID: ");
            String recipientId = scanner.next();
            balance -= amount;
            transactionCount++;
            System.out.println("Transfer to " + recipientId + " successful");
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM("123456", "7890");
        atm.start();
    }
}
