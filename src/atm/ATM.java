package atm;
import java.util.Scanner;
/**
 * ATM is a program that simulates an ATM machine to access account info and either
 * add or make changes to it.
 *
 * @author Abdul Liban Programing God
 */
public class ATM
{
   public static void main (String[] args)
   {

      // Instansiation of the ATM class so we can call the menu method later
      ATM atm1 = new ATM();

      // Instansiation of Account (twice) so we can make two account  objects
      Account a1 = new Account(101, "Abdul");
      a1.deposit(50);

      Account a2 = new Account(102, "Paul");
      a2.deposit(1000);

      // Instansiation of the Scanner class for user input
      Scanner input = new Scanner(System.in);

      System.out.println("Enter an account ID: ");

      //declaring numId as my user input int field
      int numId;

      //while loop checking weather the value being entered is not a String
      while (!input.hasNextInt()) {
         System.out.println("Please enter a number  that Represents your account ID.");
         input.nextLine();
      }
      numId = input.nextInt();

      // while loop checking weather the value inputed is either of the set accounts
      while (numId != a1.getId() && numId != a2.getId()) {

         System.out.println("You have entered the wrong ID, please try again:  ");
         numId = input.nextInt();
      }

      //checking the input value to access correct account info
      if (numId == a1.getId()) {
         atm1.menu(a1);
      }
      else if (numId == a2.getId()) {
         atm1.menu(a2);
      }

   }

   /**
    * Menu Method that accepts a reference variable and prompts the user for input
    * in which they can choose between Account info, Withdraw, Deposit and Exit.
    *
    * @param acct reference variable that is passed in the argument
    */
   public void menu (Account acct)
   {
      Scanner input = new Scanner(System.in);


      // setting choice to 0 so my while loop can start
      int choice = 0;

      // menu prompt declared in an ouput string
      String output = "Main Menu\n 1: Account info\n 2: Withdraw\n 3: Deposit\n 4: Exit\n Please choose what you'd like to do: ";

      //while loop prompt the user the menu and keeping it in a loop
      while (choice < 5) {

         System.out.println(output);
         choice = input.nextInt();

         //switch statement allowing the user to choose between options
         switch (choice) {
            //account info
            case 1:
               System.out.println(acct.toString());
               break;

            //withdraw option
            case 2:
               System.out.println("please enter amount for withdrawal: ");

               boolean checker = false;

               do {
                  //while loop checking weather the value being entered is not a String
                  while (!input.hasNextDouble()) {
                     System.out.println("invalid please use a number value");
                     input.nextLine();
                  }


                  try {
                     double withdrawal = input.nextDouble();
                     acct.withdraw(withdrawal);
                     checker = true;
                     break;
                  }
                  catch (IllegalArgumentException err) {
                     System.out.println(err.getMessage());
                     checker = true;
                     input.nextLine();
                  }
               }
               while (checker);
               break;

            //deposit option
            case 3:
               System.out.println("please enter amount for deposit: ");

               checker = false;
               do {
                  //while loop checking weather the value being entered is not a String
                  while (!input.hasNextDouble()) {
                     System.out.println("invalid please use a number value");
                     input.nextLine();
                  }

                  try {
                     double depositAmt = input.nextDouble();
                     acct.deposit(depositAmt);
                     break;
                  }
                  catch (IllegalArgumentException err) {
                     System.out.println(err.getMessage());
                     checker = true;
                     input.nextLine();
                  }
               }
               while (checker);
               break;

            case 4:
               // loops back to the main method
               main(null);
               break;

            default:
               // if you enter a value other than 1-4, it prompts you back to enter the correct number
               System.out.println("\n #### please re-enter a number between 1-4 ####");
               menu(acct);
         }
      }
   }



}
