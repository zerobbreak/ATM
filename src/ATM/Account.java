package ATM;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;
    Scanner sc = new Scanner (System.in);
    DecimalFormat mf = new DecimalFormat("'$'###,##0.00");

    public int setCustomerNumber(int customerNumber){
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    public int  getCustomerNumber(){
        return customerNumber;
    }

    public int setPinNumber (int pinNumber){
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    public int getPinNumber(){
        return pinNumber;
    }

    public double getCheckingBalance(){
        return checkingBalance;
    }

    public double getSavingBalance(){
        return savingBalance;
    }

    public double calcCheckingWithdraw(double amount){
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }

    public double calcSavingWithdraw(double amount){
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }

    public double calcCheckingDeposit(double amount){
        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
    }

    public double calcSavingDeposit(double amount){
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }

    public void getCheckingWithdrawInput(){
        System.out.println("Checking ATM.ATM2.Account Balance: " + mf.format(checkingBalance));
        System.out.println("Amount you want to withdraw from Checking ATM.ATM2.Account: ");
        double amount = sc.nextDouble();

        if ((checkingBalance - amount) >= 0){
            calcCheckingWithdraw(amount);
            System.out.println("New Checking ATM.ATM2.Account balance: " + mf.format(checkingBalance));
        }
        else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }


    public void getSavingWithdrawInput(){
        System.out.println("Saving ATM.ATM2.Account Balance: " + mf.format(savingBalance));
        System.out.println("Amount you want to deposit from Checking ATM.ATM2.Account: ");
        double amount =sc.nextDouble();

        if ((checkingBalance + amount) >= 0){
            calcCheckingDeposit(amount);
            System.out.println("New Checking ATM.ATM2.Account balance: " + mf.format(checkingBalance) + "\n");
        }
        else{
            System.out.println("Balance cannot be negative." + "\n");
        }
    }

    public void getCheckingDepositInput(){
        System.out.println("Checking ATM.ATM2.Account Balance: " + mf.format(checkingBalance));
        System.out.println("Amount you want to deposit from Checking ATM.ATM2.Account: ");
        double amount = sc.nextDouble();

        if ((checkingBalance + amount) >= 0){
            calcCheckingDeposit(amount);
            System.out.println("New Checking ATM.ATM2.Account Balance: " + mf.format(checkingBalance) + "\n");
        }
        else {
            System.out.println("Balance cannot be negative");
        }
    }



    public void getSavingDepositInput(){

        System.out.println("Saving ATM.ATM2.Account Balance: " + mf.format(savingBalance));
        System.out.println("Amount you want to deposit from Checking ATM.ATM2.Account: ");

        double amount = sc.nextDouble();
        if ((savingBalance + amount) >= 0){
            calcSavingDeposit(amount);
            System.out.println("New Saving ATM.ATM2.Account Balance: " + mf.format(savingBalance) + "\n");
        }
        else{
            System.out.println("Balance cannot be negative." + "\n");
        }
    }

    public void getPrintReceipt(int customerNumber){

        try{
            PrintWriter wr = new PrintWriter(new FileWriter(customerNumber + ".txt"));
            wr.write("Receipt: *****************************");
            wr.write("\nCustomerNumber: " + customerNumber);
            wr.write("\nChecking Balance: " + mf.format(checkingBalance));
            wr.write("\nSaving ATM2.Account: " + mf.format(savingBalance));
            wr.write("\n**************************************");
            wr.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
