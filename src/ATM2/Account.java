package ATM2;

import java.io.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Account {

    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(input);
    DecimalFormat mf = new DecimalFormat();

    boolean Account = false;
    String userID = "";
    String password = "";
    String confirmPass = "";
    String confirmID = "";
    int withDraw = 0;
    int deposit = 0;
    int totalMoney = 0;


    public void Option(char userInput) throws IOException {
        while (userInput != 'q' && userInput != 'Q')
        {
            System.out.println("Hello user welcome to MJ's ATM");
            System.out.println("L -> Login\n" +
                    "C -> Create new ATM2.Account\n" +
                    "Q -> Quit");
            System.out.println("> ");
            userInput = reader.readLine().charAt(0);

            if ((userInput == 'L' || userInput == 'l') && Account == false){
                System.out.println("Please create an account first\n");
            }
            else if ((userInput == 'L' || userInput == 'l') && Account == true)
            {
                System.out.println("Please enter your user id: ");
                confirmID = reader.readLine();
                System.out.println("Please enter your password: ");
                confirmPass = reader.readLine();

                if (confirmPass.isBlank() || confirmPass.isEmpty())
                {
                    System.out.println("empty input");
                    break;
                }

                if (confirmPass.contentEquals(password) && confirmID.contentEquals(userID) && Account == true){
                    System.out.println("Access Granted");
                    char userInput2 = 0;

                    while (userInput2 != 'L'){
                        System.out.println(" ");
                        System.out.println("Hello " + userID + ", welcome back");
                        System.out.println("Your balance is: $" + totalMoney);
                        System.out.println("W -> Withdraw money\n" +
                                "D -> Deposit money\n" +
                                "B -> Balance\n" +
                                "R -> Request Receipt\n"+
                                "L -> Log put");
                        System.out.print("-> ");
                        userInput2 = reader.readLine().charAt(0);

                        Withdraw(userInput2);
                        Deposit(userInput2);
                        Balance(userInput2);
                        PrintReceipt(userInput2);
                        LogOut(userInput2);
                    }
                }
                else if (confirmPass.contentEquals(password) == false && confirmID.contentEquals(userID) == true)
                {
                    System.out.println("**************** LOGIN FAILED! ***********");
                    System.out.println("\npassword clue: " + password);

                }
                else if (confirmPass.contentEquals(password) ==true && confirmID.contentEquals(userID) ==false){
                    System.out.println("*************** LOGIN FAILED *************");
                    System.out.println("\nUser ID clue" + userID);
                }
                else if (confirmPass.contentEquals(password) == false && confirmID.contentEquals(userID) == false)
                {
                    System.out.println("**************** LOGIN FAILED! ***********");
                    System.out.println("Oh no you forgot your password and user id! Don't worry this is a demo\n");
                    System.out.println("Password: " + password);
                    System.out.println("User ID: " + userID);
                    System.out.println("\n");

                }
            }
            else if (userInput == 'C' || userInput =='c')
            {
                CreateAccount(userInput);
            }
            else
            {
                System.out.println("Invalid input");
            }
        }
        for (int i = 0; i < 5; i++) System.out.println();
        System.out.println("Thanks for stopping by and have a nice day");
//        System.out.println("Date: ");
//        LocalTime(arg);
    }



    public void Withdraw(char userInput2) throws IOException {

        if (userInput2 == 'W' || userInput2 == 'w') {
            System.out.println();
            System.out.println("Please input Amount you want to withdraw (input Numerical Integers, ex: 1 to 100");
            System.out.print(">$");
            withDraw = Integer.parseInt(reader.readLine());
            if (totalMoney >= withDraw) {
                totalMoney -= withDraw;
            } else if (totalMoney < withDraw) {
                System.out.println("[Not enough Balance left]");
            }
        } else {
            System.out.println(totalMoney);
        }
    }


    public void Deposit(char userInput2) throws IOException {
        if (userInput2 == 'D' || userInput2 == 'd') {
            System.out.println();
            System.out.println("Please input the Amount you want to deposit (Input Numerical Integers, ex: 1 to 100)?");
            System.out.print(">$");
            deposit = Integer.parseInt(reader.readLine());
            totalMoney += deposit;
        }
    }

    public void LogOut(char userInput2) {

        if (userInput2 == 'l' || userInput2 == 'L') {
            System.out.println();
            System.out.println("You just logged out...\n");
            confirmID = "";
            confirmPass = "";
        }
    }

    public void Balance(char userInput2) {
        if (userInput2 == 'b' || userInput2 == 'B') {
            System.out.println();
            System.out.println("Your Balance is: " + totalMoney);
        }
    }

    public void PrintReceipt(char userInput2) {

        if (userInput2 == 'r' || userInput2 == 'R') {
            try {
                PrintWriter pr = new PrintWriter(new FileWriter("Receipt.txt"));
                pr.write("Receipt is for " + userID);
                pr.write("\nTotal amount: $" + totalMoney);
                if (withDraw > 0) {
                    pr.write("\nWithdraw: $ -" + withDraw);
                } else {
                    pr.write("\nWithdraw $ -");
                }
                pr.write("\nDeposit: $" + deposit);
                pr.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void CreateAccount(char userInput) throws IOException {
        if (userInput == 'C' || userInput == 'c') {

            System.out.println("Creating an ATM2.Account Page");
            System.out.println("Please input your UserID and Password. (UserID & Password can be both AlphaNumeric, ex: Password123)");
            System.out.print("UserID: ");
            userID = reader.readLine();
            System.out.print("password: ");
            password = reader.readLine();

            if (password.isBlank() || password.isEmpty()) {
                System.out.println("It can't be empty");
            }

            System.out.print("Confirm password: ");
            confirmPass = reader.readLine();
            System.out.println(confirmPass.equals(password));

            if (password.contentEquals(confirmPass) == true) {
                System.out.println(" ");
                System.out.println("ATM2.Account Info");
                System.out.println("UserID: " + userID);
                System.out.println("Password: " + password);
                System.out.println("");
                System.out.println("Thank You! Your account has been created!");
                Account = true;
            } else if (password.contentEquals(confirmPass) == false) {
                System.out.println(" ");
                System.out.println("Password are not equal, try again.\n");
                Account = false;
                password = "";
                userID = "";
                userInput = ' ';
            }
        }
    }
}
