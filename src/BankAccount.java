import java.util.ArrayList;
import java.util.Scanner;

//default constructor

public class BankAccount {
    //fields
    public static String firstName;
    public static String lastName;
    public static int accountID;
    public static double balance;

    //parameterized Constructor

    public BankAccount(String firstName, String lastName, int accountID, Double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountID = accountID;
        this.balance = 0.00; // initialize balance to zero
    }

    static ArrayList<Object> clientRecords = new ArrayList<>();

    static BankAccount client = new BankAccount(firstName, lastName, accountID, balance);

    static Scanner scn = new Scanner(System.in);

    // Deposit method will accept a single value double parameter; the parameter value is added to the existing balance

    public static void Deposit() {
        System.out.println("How much would you like to deposit today?");
        System.out.print("$");
        double newDeposit = scn.nextDouble();
        if (newDeposit > 0) {
            balance += newDeposit;
            System.out.println("You deposited: $" + newDeposit);
            System.out.println("Your current balance is $" + balance);
        } else {
            System.out.println("Deposit amount must be higher than $0.");
        }
    }

    // the withdrawal method accepts a single value double dollar amount; the parameter value is subtracted from the existing balance

    public static void Withdrawal(){
        System.out.println("How much would you like to withdraw from your account?");
        System.out.print("$");
        Double newWithdrawal = scn.nextDouble();
        balance -= newWithdrawal;
        System.out.println("You withdrew: $" + newWithdrawal);
    }

    // setters and getters
    public static void setFirstName(String newFirstName)  {
        firstName = newFirstName;
    }
    public static void setLastName(String newLastName)  {
        lastName = newLastName;
    }
    public static void setAccountID(int newAccountID)  {
        accountID = newAccountID;
    }
    public static String getFirstName()  {
        return firstName;
    }
    public static String getLastName()  {
        return lastName;
    }
    public static int getAccountID()  {
        return accountID;
    }
    public static void getBalance()  {
        System.out.println("Your Current Balance is: $" + balance);
    }

    public static void accountSummary(){
        System.out.println("Account Summary");
        System.out.println("Account Name: " + getFirstName() + " " + getLastName());
        System.out.println("Account ID: " + getAccountID());
        System.out.println("Current Balance: " + balance);
    }
}