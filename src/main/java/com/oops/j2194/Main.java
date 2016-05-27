package com.oops.j2194;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

    public static int week ;
    public static int keep ;

//    public static int minPrice = Integer.MAX_VALUE;
    public static boolean DEBUG = false;

    public static void main(String... arg)
    {

        Scanner scanner = null;
        try
        {
            System.setIn(new FileInputStream("/users/oops/IdeaProjects/jungol/src/main/java/com/oops/j2194/input.txt"));
            scanner = new Scanner(System.in);
            week = scanner.nextInt();
            keep = scanner.nextInt();
            int minPrice = Integer.MAX_VALUE- 100;
            int currentPrice = Integer.MAX_VALUE;
            int needAmount = 0;

            long result = 0L;

            for (int i = 0; i < week; i++) {
                currentPrice = scanner.nextInt();
                needAmount = scanner.nextInt();
                minPrice = ( currentPrice  < minPrice + keep ) ?  currentPrice : minPrice + keep;
                result += minPrice * needAmount;

            }

            System.out.println(result);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner.close();

    }


}
