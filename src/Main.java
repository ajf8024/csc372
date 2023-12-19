// Main class to text bankaccount and checking account classes.

public class Main {
    public static void main(String[] args)
    {
        CheckingAccount checkAcc = new CheckingAccount("John", "Doe", 123, 500.0, 0.05);

        System.out.println("Account Summary: ");
        System.out.println("First Name: " + checkAcc.getFirstName());
        System.out.println("Last Name: " + checkAcc.getLastName());
        System.out.println("Account ID: " + checkAcc.getAccountID());
        System.out.println("Balance: $" + checkAcc.getBalance());
        System.out.println("Interest Rate: " + checkAcc.getInterestRate());

        System.out.println("\nMaking a deposit of $100...");
        checkAcc.deposit(100);
        System.out.println("Balance: $" + checkAcc.getBalance());

        System.out.println("\nMaking a withdrawal of $600...");
        checkAcc.processWithdrawal(600);
        System.out.println("Balance: $" + checkAcc.getBalance());

        System.out.println("\nDisplaying account information...");
        checkAcc.displayAccount();
    }
}