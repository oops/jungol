package com.oops.j1108;

import java.io.FileInputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by oops on 2016. 4. 26..
 */


public class Main {

    public static int INPUT_COUNT;
    public static int[][] INPUT_VALUE;
    public static int[][] MIN_ROUTE_RESULT;
    public static int CALCULATION_COMPLETION_COUNT = 0;
    public static int MAX_ROUTE_LEN_AT_THIS_TIME = 0;

    public static int MAX_INT = 0;
    public static boolean DEBUG = false;

    public static void main(String... arg) throws Exception
    {

        Scanner scanner = null;
        try
        {
            if(DEBUG)System.out.println("Enter the number of nodes in the graph");
            System.setIn(new FileInputStream("/users/oops/IdeaProjects/jungol/src/main/java/com/oops/j1108/input.txt"));
            scanner = new Scanner(System.in);
            INPUT_COUNT = scanner.nextInt();
            INPUT_VALUE = new int[INPUT_COUNT][2];
            for(int i = 0 ; i< INPUT_COUNT; i++ ) {
                INPUT_VALUE[i][0] = scanner.nextInt();
                INPUT_VALUE[i][1] = scanner.nextInt();
                MAX_INT = Math.max(MAX_INT, INPUT_VALUE[i][0]);
                MAX_INT = Math.max(MAX_INT, INPUT_VALUE[i][1]);
            }

            MIN_ROUTE_RESULT = new int[MAX_INT][MAX_INT];

            for (int i = 0; i < MAX_INT; i++) {
                for (int j = 0; j < MAX_INT; j++) {
                    if( i == j ) {
                        MIN_ROUTE_RESULT[i][j] = 0;
                        CALCULATION_COMPLETION_COUNT++;
                    }
                    else MIN_ROUTE_RESULT[i][j] = -1;
                }
            }

            if(DEBUG)System.out.println(INPUT_COUNT);
            for (int i = 0; i < INPUT_COUNT; i++) {
                if(DEBUG)System.out.println( INPUT_VALUE[i][0] + "  " + INPUT_VALUE[i][1]);
                MIN_ROUTE_RESULT[INPUT_VALUE[i][0]-1][INPUT_VALUE[i][1]-1] = 1;
                CALCULATION_COMPLETION_COUNT++;
            }

            printMap();
            while(CALCULATION_COMPLETION_COUNT < MAX_INT*MAX_INT) checkOneMoreDepth();

            int result = 0;
            for (int i = 0; i < MAX_INT; i++) {
                for (int j = 0; j < MAX_INT; j++) {
                    result += MIN_ROUTE_RESULT[i][j];
                }
            }
            double ri = (double)result / ( MAX_INT * (MAX_INT-1));
            System.out.printf("%.3f", Math.round(ri * 1000d) / 1000d);

        } catch (InputMismatchException inputMismatch)
        {
            System.out.println("wrong input format");
        }
        scanner.close();

    }


    public static int checkOneMoreDepth() {
        MAX_ROUTE_LEN_AT_THIS_TIME++;
        for (int i = 0; i < MAX_INT; i++) {
            for (int j = 0; j < MAX_INT; j++) {
                if( MIN_ROUTE_RESULT[i][j] < 0 ) {
                    int tmpLen = Integer.MAX_VALUE;
                    for (int k = 0; k < MAX_INT; k++) {
                        if( MIN_ROUTE_RESULT[i][k] > 0 && MIN_ROUTE_RESULT[k][j] > 0 && MIN_ROUTE_RESULT[i][k] <= MAX_ROUTE_LEN_AT_THIS_TIME && MIN_ROUTE_RESULT[k][j] <= MAX_ROUTE_LEN_AT_THIS_TIME) {
                            tmpLen = Math.min(MIN_ROUTE_RESULT[i][k] + MIN_ROUTE_RESULT[k][j], tmpLen);
                        }
                    }
                    if( tmpLen < Integer.MAX_VALUE) {
                        MIN_ROUTE_RESULT[i][j] = tmpLen;
                        CALCULATION_COMPLETION_COUNT++;
                    }
                }

            }
        }
        printMap();
        return CALCULATION_COMPLETION_COUNT;

    }

    public static void printMap() {
        if(!DEBUG) return;
        System.out.println("START============  ");
        for (int i = 0; i < MAX_INT; i++) {
            for (int j = 0; j < MAX_INT; j++) {
                System.out.print(MIN_ROUTE_RESULT[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println("END============  ");
    }

}
