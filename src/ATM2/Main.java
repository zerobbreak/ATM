package ATM2;

import ATM2.Account;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Account a = new Account();
        System.out.println("Hello user please press enter to continue: ");
        Scanner sc = new Scanner(System.in);
        char line = sc.next().charAt(0);
        try {
            a.Option(line);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
