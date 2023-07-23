package org.example;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class SafeInput {

    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        }while(retString.length() == 0);

        return retString;

    }

    public static int getInt(Scanner pipe, String prompt)
    {
        int retInt = 0;
        do
        {
            System.out.print("\n" +prompt + ": ");
            retInt = pipe.nextInt();
        }while(retInt == 0);

        return retInt;

    }

    public static double getDouble(Scanner pipe, String prompt)
    {
        double retDouble = 0;
        do
        {
            System.out.print("\n" +prompt + ": ");
            retDouble = pipe.nextDouble();
        }while(retDouble == 0);

        return retDouble;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retRangedInt = 0;
        do
        {
            System.out.print("\n" +prompt );
            retRangedInt = pipe.nextInt();
        }while(retRangedInt < low || retRangedInt > high);

        return retRangedInt;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        Double retRangedDouble = 0d;
        do
        {
            System.out.print("\n" +prompt + ": [" + low + " - " + high + " ]" );
            retRangedDouble = pipe.nextDouble();
        }while(retRangedDouble < low || retRangedDouble > high);

        return retRangedDouble;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String inputY = "";
        do {
            System.out.print(prompt + ": ");
            inputY = pipe.nextLine().trim().toLowerCase();
        } while (!inputY.equals("y") && !inputY.equals("n"));

        return inputY.equals("y");
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String retRegEx = "";

        do {
            System.out.print(prompt + ": ");
            retRegEx = pipe.nextLine().trim();
        } while (!retRegEx.matches(regEx));

        return retRegEx;
    }

    public static void prettyHeader(String msg){
        int lineLen = 66;
        printLine("*", lineLen);
        System.out.println("\n");

        System.out.print("***");
        int spaceLen = lineLen - 5 - msg.length();
        printLine(" ", spaceLen/2);
        System.out.print(msg);
        printLine(" ", spaceLen/2);
        System.out.print(" ***");
        System.out.println("\n");

        printLine("*", lineLen);
    }

    public static void printLine(String str, int len) {
        for (int i=1; i<len; i++) {
            System.out.print(str);
        }
    }
}