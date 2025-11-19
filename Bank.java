import java.util.Scanner;
class account 
{
    String customername;
    String accountnumber;
    double balance;
    account(String customername,String accountnumber,double balance)
    {
        this.accountnumber=accountnumber;
        this.customername=customername;
        this.balance=balance;
    }
    void deposit(double amount)
    {
        balance +=amount;
        System.out.println("deposit of Rs."+amount+"successful");
    }
    void displaybalance()
    {
        System.out.println("\naccount number:"+accountnumber+"\nbalance:"+balance);
    }
}
class savingsaccount extends account
{
    savingsaccount(String customername,String accountnumber,double balance)
    {
        super(customername, accountnumber, balance);
    }
   void addinterest(double years)
{
    double interestrate = 5;
    if (years <= 0)
    {
        System.out.println("No time passed, no interest added.");
        return;
    }
    double r = interestrate / 100;
    double interest = balance * r * years;
    balance += interest;
    System.out.println("Interest of Rs. " + interest + " added for " + years + " years.");
}

}
class currentaccount extends account
{
    double minimumbalance=1000;
    currentaccount(String customername,String accountnumber,double balance)
    {
        super(customername,accountnumber,balance);
    }
    void withdraw(double amount)
    {
        if(balance-amount>=minimumbalance)
        {
            balance -=amount;
            System.out.println("withdrawal of"+amount+"successful");
        }
        else
        {
            System.out.println("insufficient funds, charges imposed");
            imposepenalty();
        }
    }
    void imposepenalty()
    {
        double penalty=200;
        balance -=penalty;
        System.out.println("penalty of rs.:"+penalty+"imposed");
    }
}
 class bank
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter 1 for current account and 2 for savings account");
        int choice1=sc.nextInt();
        account acc;
        if(choice1==1)
        {
            acc=new currentaccount("Mahesh","1234",10000);
        }
        else
        {
            acc=new savingsaccount("yesh","5678",5000);
        }
        while(true)
        {
        System.out.println("\nmenu");
        System.out.println("1.deposit");
        System.out.println("2.withdraw(only current account)");
        System.out.println("3.display balance");
        System.out.println("4.compute interest(only savings account");
        System.out.println("5.exit");
        int choice2=sc.nextInt();
        switch(choice2)
        {
            case 1:
            System.out.println("enter amount to  deposit");
            double amount=sc.nextDouble();
            acc.deposit(amount);
            break;
            case 2:
            if(acc instanceof savingsaccount)
            {
                System.out.println("withdrawal not allowed for savings account");
            }
            else
            {
                System.out.println("enter amount to withdraw");
                amount=sc.nextDouble();
                ((currentaccount) acc).withdraw(amount);
            }
            break;
            case 3:
            acc.displaybalance();
            break;
            case 4:
            if(acc instanceof savingsaccount)
            {
                ((savingsaccount) acc).addinterest(2);                                                                                                                                                             
            }
            else 
            {
                System.out.println("interest computation not applicable for current account");
            }
            break;
            case 5:
            System.exit(0);
            default:
            System.out.println("invalid choice");
        }
    }
}
}