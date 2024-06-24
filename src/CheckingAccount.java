import java.util.Scanner;

public class CheckingAccount extends BankAccount {

    public static double interestRate = 0; // interest rate field
    public static double overdraftFee = 0;

    public CheckingAccount(String firstName, String lastName, int accountID, Double balance) {
        super(firstName, lastName, accountID, balance);
    }

    // Process withdrawal with overdraft fee
    public static void processWithdrawal() {
        overdraftFee = 30;
        balance -= overdraftFee;
        System.out.println("$30 Overdraft Fee has been assessed.");
        BankAccount.getBalance();
    }

    // Interest rate method
    public static void displayInterest() {
        interestRate = 3.5;
        System.out.println("Interest Rate: " + interestRate + "%");
    }

    public static void displayAccount() {
        BankAccount.accountSummary();
        displayInterest();
    }

    public static void main(String[] args) {
        BankAccount.setFirstName("Michael");
        BankAccount.setLastName("Scott");
        BankAccount.setAccountID(345678);

        System.out.println();
        System.out.println("Welcome " + BankAccount.getFirstName() + " " + BankAccount.getLastName() + "!");
        System.out.println();

        try {
            while (true) { //create while loop to ask for user input and execute desired task
                System.out.println("What would you like to do?");
                System.out.println("Enter one of the following options: 'Deposit', 'Withdraw', 'Info'; to end: 'Done'"); //Asks for user input to perform action
                Scanner scan = new Scanner(System.in);
                String userCommand = scan.nextLine();

                if (userCommand.equalsIgnoreCase("Deposit")) { //executes deposit method
                    BankAccount.Deposit();
                } else if (userCommand.equalsIgnoreCase("Withdraw")) { //executes Withdrawak method
                    BankAccount.Withdrawal();
                    if (BankAccount.balance < 0) {
                        CheckingAccount.processWithdrawal();
                    } else if (BankAccount.balance >= 0) {
                        BankAccount.getBalance();
                    } else {
                        System.out.println("Invalid amount.");
                    }
                } else if (userCommand.equalsIgnoreCase("Info")) { //executes accountSummary method and prints account info
                    CheckingAccount.displayAccount();
                } else if (userCommand.equalsIgnoreCase("Done")) { //end the program if Done is input by the user
                    System.out.print("Have a Great Day!");
                    break;
                } else {
                    System.out.println("Please enter a valid input.");
                }
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}