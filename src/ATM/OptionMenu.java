package ATM;

import ATM.Account;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
//import java.util.Map;
import java.util.Map;
import java.util.Scanner;

public class OptionMenu extends Account {

    int selection;
    Scanner menuInput = new Scanner (System.in);
    DecimalFormat moneyformat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin () throws IOException{

        int x = 1;

        do {
            try{
                data.put(123456789, 1234);
                data.put(123456780, 1230);

                System.out.println("Welcome to the ATM");

                System.out.println("Enter Your Customer Number: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Enter Your Pin Number: ");
                setPinNumber(menuInput.nextInt());
            }catch (Exception e){
                System.out.println("\n" + "Invalid character(s). Only numbers." + "\n");
                x = 2;
            }
            for (Map.Entry<Integer, Integer> entry : data.entrySet()){
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()){
                    getAccountType();
                }
            }
            System.out.println("\n" + "Wrong Customer Number or Pin Number." + "\n");
        }while(x == 1);
    }

    public void getAccountType(){

        System.out.println("Select the ATM.ATM2.Account you want to access: ");
        System.out.println("Type 1 - Checking ATM.ATM2.Account");
        System.out.println("Type 2 - Saving ATM.ATM2.Account");
        System.out.println("Type 3 - Exit");
        System.out.println("Choice: ");

        selection = menuInput.nextInt();
        switch (selection){
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank you for using this ATM.ATM, bye");
                System.out.println("Receipt?");
                Scanner sc = new Scanner(System.in);
                System.out.print("Yes or NO: ");
                char response = sc.next().charAt(0);
                if (response == 'y' || response == 'Y'){
                    getPrintReceipt(getCustomerNumber());
                }
                else {
                    System.out.println("Sorry error occurred");
                }
                break;
            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getAccountType();
        }
    }

    public void getChecking(){
        System.out.println("Checking ATM.ATM2.Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");

        selection = menuInput.nextInt();

        switch (selection){
            case 1:
                System.out.println("Checking ATM.ATM2.Account Balance: " + moneyformat.format(getCheckingBalance())  + "\n");
                getAccountType();
                break;

            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank you fro using this ATM.ATM, bye.");
                break;

            default:
                System.out.println("\n" + "Invalid choice." + "\n");
                getChecking();
        }
    }

    public void getSaving(){
        System.out.println("Saving ATM.ATM2.Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Type 5 - Receipt");
        System.out.print("Choice: ");

        selection = menuInput.nextInt();

        switch (selection){
            case 1:
                System.out.println("Saving ATM.ATM2.Account Balance: " + moneyformat.format(getSavingBalance()) + "\n");
                getAccountType();
                break;

            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getSavingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank you for using this ATM.ATM, bye.");
                break;

            case 5:
                getPrintReceipt(getCustomerNumber());

            default:
                System.out.println("\n" + "Invalid choice." + "\n");
                getSaving();
        }
    }
}
