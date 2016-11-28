package com.oops.j1082;

import java.io.FileInputStream;
import java.util.ArrayDeque;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by oops on 2016. 4. 26..
 */


public class Main {

    public static int ROW;
    public static int COLUMN;
    public static int START = -1;
    public static String startString = "S";
    public static int DEST = -2;
    public static String destString = "D";
    public static int ROCK = -3;
    public static String rockString = "*";
    public static int[][] myMap ;


    public static void main(String... arg) throws Exception
    {

        Scanner scanner = null;
        try
        {
            System.setIn(new FileInputStream("D:\\source\\jungol\\src\\main\\java\\com\\oops\\j1082\\input.txt"));
            scanner = new Scanner(System.in);
            ROW = scanner.nextInt();
            COLUMN = scanner.nextInt();
            myMap = new int[ROW][COLUMN];
            ArrayDeque<String> check = new ArrayDeque<String>();
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COLUMN; j++) {
                    String s = scanner.next();
                    if(startString.equals(s)) myMap[i][j] = START;
                    else if( destString.equals(s)) myMap[i][j] = DEST;
                    else if( rockString.equals(s)) myMap[i][j] = ROCK;
                    else myMap[i][j] = Integer.valueOf(s);
                }
            }


        } catch (InputMismatchException inputMismatch)
        {
            System.out.println("wrong input format");
        }
        scanner.close();

    }


}
