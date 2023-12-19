// CheckingAccount.java
public class CheckingAccount extends BankAccount
{
    //private interest rate method.
    private double interestRate;

    public CheckingAccount(String firstName, String lastName, int accountID, double balance, double interestRate) {
        super(firstName, lastName, accountID, balance);
        this.interestRate = interestRate;
    }

    // if there is no balance and person withdraws amount, $30 is charged and the same is displayed to user.
    public void processWithdrawal(double amount) {
        if (amount > this.getBalance()) {
            System.out.println("Insufficient funds. A $30 overdraft fee has been charged.");
            this.withdrawal(30);
            this.withdrawal(amount);
        } else {
            this.withdrawal(amount);
        }
    }

    // displays all parent members information along with interest rates.
    public void displayAccount() {
        System.out.println("Checking Account Information:");
        System.out.println("First Name: " + this.getFirstName());
        System.out.println("Last Name: " + this.getLastName());
        System.out.println("Account ID: " + this.getAccountID());
        System.out.println("Balance: " + this.getBalance());
        System.out.println("Interest Rate: " + interestRate);
    }

    //getter and setter for interest rate.
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
