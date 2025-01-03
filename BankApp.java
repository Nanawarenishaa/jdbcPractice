
import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankOperations bankOps = new BankOperations();

        System.out.println("Welcome to the Bank App!");

        // Example operations for user ID 101 (Jay)
        int userId = 101;  // Replace with your logged-in user ID

        // Viewing Balance
        double balance = bankOps.viewBalance(userId);
        System.out.println("Your current balance: $" + balance);

        // Withdrawing Money
        System.out.print("Enter amount to withdraw: $");
        double withdrawAmount = scanner.nextDouble();
        bankOps.withdraw(userId, withdrawAmount);

        // Viewing Balance Again
        balance = bankOps.viewBalance(userId);
        System.out.println("Your new balance: $" + balance);

        // Depositing Money
        System.out.print("Enter amount to deposit: $");
        double depositAmount = scanner.nextDouble();
        bankOps.deposit(userId, depositAmount);

        // Viewing Balance Again
        balance = bankOps.viewBalance(userId);
        System.out.println("Your new balance: $" + balance);

        // Transferring Money
        System.out.print("Enter recipient user ID for transfer: ");
        int toUserId = scanner.nextInt();
        System.out.print("Enter amount to transfer: $");
        double transferAmount = scanner.nextDouble();
        bankOps.transfer(userId, toUserId, transferAmount);

        scanner.close();
    }
}
