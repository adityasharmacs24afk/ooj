import java.util.Scanner;


class Account {
    protected String customerName;
    protected String accountNumber;
    protected String accountType;
    protected double balance;

    public Account(String customerName, String accountNumber, String accountType, double initialBalance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void displayBalance() {
        System.out.println("Account Balance: " + balance);
    }

    public boolean withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
            return true;
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount");
            return false;
        }
    }
}

// Savings Account class
class SavAcct extends Account {
    private double interestRate;

    public SavAcct(String customerName, String accountNumber, double initialBalance, double interestRate) {
        super(customerName, accountNumber, "Savings", initialBalance);
        this.interestRate = interestRate;
    }

    public void computeAndDepositInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest of " + interest + " added. New balance: " + balance);
    }

    @Override
    public boolean withdraw(double amount) {
        return super.withdraw(amount);
    }
}

// Current Account class
class CurAcct extends Account {
    private double minimumBalance;
    private double serviceCharge;

    public CurAcct(String customerName, String accountNumber, double initialBalance, double minimumBalance, double serviceCharge) {
        super(customerName, accountNumber, "Current", initialBalance);
        this.minimumBalance = minimumBalance;
        this.serviceCharge = serviceCharge;
    }

    public void issueChequeBook() {
        System.out.println("Cheque book issued to " + customerName);
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        checkMinimumBalanceAndCharge();
    }

    @Override
    public boolean withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
            checkMinimumBalanceAndCharge();
            return true;
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount");
            return false;
        }
    }

    private void checkMinimumBalanceAndCharge() {
        if(balance < minimumBalance) {
            System.out.println("Balance below minimum! Service charge of " + serviceCharge + " imposed.");
            balance -= serviceCharge;
            if(balance < 0) balance = 0;
            System.out.println("Balance after service charge: " + balance);
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Bank System");

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter account number: ");
        String accNumber = scanner.nextLine();

        System.out.print("Enter account type (Savings/Current): ");
        String type = scanner.nextLine().trim().toLowerCase();

        Account account = null;

        switch (type) {
            case "savings":
                System.out.print("Enter initial deposit: ");
                double initSav = scanner.nextDouble();

                System.out.print("Enter interest rate (e.g. 0.05 for 5%): ");
                double interestRate = scanner.nextDouble();
                scanner.nextLine(); // consume newline

                account = new SavAcct(name, accNumber, initSav, interestRate);
                break;

            case "current":
                System.out.print("Enter initial deposit: ");
                double initCur = scanner.nextDouble();

                System.out.print("Enter minimum balance: ");
                double minBalance = scanner.nextDouble();

                System.out.print("Enter service charge: ");
                double serviceCharge = scanner.nextDouble();
                scanner.nextLine(); // consume newline

                account = new CurAcct(name, accNumber, initCur, minBalance, serviceCharge);
                ((CurAcct)account).issueChequeBook();
                break;

            default:
                System.out.println("Invalid account type");
                scanner.close();
                return;
        }

        boolean running = true;
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            if(account instanceof SavAcct) {
                System.out.println("3. Compute and Deposit Interest");
                System.out.println("4. Display Balance");
                System.out.println("5. Exit");
            } else {
                System.out.println("3. Display Balance");
                System.out.println("4. Exit");
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmt = scanner.nextDouble();
                    scanner.nextLine();
                    account.deposit(depositAmt);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmt = scanner.nextDouble();
                    scanner.nextLine();
                    account.withdraw(withdrawAmt);
                    break;

                case 3:
                    if(account instanceof SavAcct) {
                        ((SavAcct) account).computeAndDepositInterest();
                    } else {
                        account.displayBalance();
                    }
                    break;

                case 4:
                    if(account instanceof SavAcct) {
                        account.displayBalance();
                    } else {
                        running = false;
                        System.out.println("Exiting...");
                    }
                    break;

                case 5:
                    if(account instanceof SavAcct) {
                        running = false;
                        System.out.println("Exiting...");
                    } else {
                        System.out.println("Invalid option");
                    }
                    break;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        }

        scanner.close();
    }
}
