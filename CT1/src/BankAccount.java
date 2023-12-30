// BankAccount.java
public class BankAccount
{
    //private member variables.
    private String firstName;
    private String lastName;
    private int accountID;
    private double balance;

    //default constructor initializes balance to zero
    public BankAccount() {
        this.balance = 0;
    }

    //parameterised constructor to set all private member variables.
    public BankAccount(String firstName, String lastName, int accountID, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountID = accountID;
        this.balance = balance;
    }

    //will accept a single value double parameter; the parameter value is added to the existing balance
    public void deposit(double amount) {
        this.balance += amount;
    }

    //accepts a single value double dollar amount; the parameter value is subtracted from the existing balance
    public void withdrawal(double amount) {
        this.balance -= amount;
    }

    //getters and setters.
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public double getBalance() {
        return balance;
    }

    // prints all account information
    public void accountSummary() {
        System.out.println("Account Information:");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Account ID: " + accountID);
        System.out.println("Balance: " + balance);
    }
}
