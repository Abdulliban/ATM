package atm;
/**
 * This class is used to represent a users acoount information and
 * proceed to make changes to the information as well
 *
 * @author Abdul Liban Programming God
 */
public class Account
{
   /**
    * 4 instance variables used for the account class
    *
    * @param id id for account
    * @param customerName name of customer
    * @param balance balance amount
    * @param annualInterestRate final rate of interest
    */

   private int id;
   private String customerName;
   private double balance;
   private final double annualInterestRate = 5;


   /**
    * Account constructor that sets the id and customer name to the parameter's that
    * is passed through
    *
    * @param id id for account
    * @param customerName name of customer
    *
    */
   public Account (int id, String customerName)
   {
      this.id = id;
      this.customerName = customerName;
   }

   /**
    * This method is used to deposit a give amount from the user
    * and add it to the balance
    *
    * @throws IllegalArgumentException throws an exception if the value passed is less than 0
    * @param depositAmount This is the parameter for deposit Amount
    */
   public void deposit (double depositAmount)
   {
      if (depositAmount < 0) {
         throw new IllegalArgumentException("Bad value entered must be > 0");
      }
      this.balance += depositAmount;
   }

   /**
    * This method is used to withdraw a given amount from the balace
    * and update the account.
    * throws IllegalArgumentExceptionan exception if the value passed is less than 0
    * or is more than the balance
    *
    * @param withdrawAmount This is the parameter for withdraw Amount
    */
   public void withdraw (double withdrawAmount)
   {
      if (withdrawAmount <= 0 || withdrawAmount > this.balance) {

         throw new IllegalArgumentException("Enter a value greater than 0 or Enter amount <= your balance");
      }
      this.balance -= withdrawAmount;

   }

   /**
    * MonthlyInterest method that calculates the interest the account balance
    *
    * @return earned returns the calculated amount
    */
   public double monthlyInterest ()
   {

      double earned = balance * (annualInterestRate / 12 / 100);
      return earned;
   }

   public int getId ()
   {
      return id;
   }

   public String getCustomerName ()
   {
      return customerName;
   }

   public void setCustomerName (String customerName)
   {
      this.customerName = customerName;
   }

   public double getBalance ()
   {
      return balance;
   }

   /**
    * String method the returns a formatted string
    *
    * @return A formatted String that displays the account info to the user when
    * called.
    *
    */
   public String toString ()
   {
      String format = "\n|** Account Info **| \n \nCustomer: %s \nAccount Balance: %s \nMonthly Interest earned: $%1.2f";
      return String.format(format, getCustomerName(), getBalance(), monthlyInterest());
   }


}
