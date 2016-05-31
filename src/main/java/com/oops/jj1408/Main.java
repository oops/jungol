package com.oops.jj1408;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 */

public class Main {

    public static int LINE_COUNT;
    public static int[] LINE_TO;
    public static int[] SMALL_LINE_TO;

    public static boolean DEBUG = true;

    public static void main(String... arg) throws Exception
    {

        Scanner scanner = null;
        try
        {
            System.setIn(new FileInputStream("D:\\source\\jungol\\src\\main\\java\\com\\oops\\jj1408\\input.txt"));
            scanner = new Scanner(System.in);
            LINE_COUNT = scanner.nextInt();
            LINE_TO = new int[501];
            SMALL_LINE_TO = new int[LINE_COUNT];

            int from ;
            int to;
            for(int i = 1 ; i< LINE_COUNT+1; i++ ) {
                from = scanner.nextInt();
                to = scanner.nextInt();
                LINE_TO[from] = to;
            }
            makeSmallLineTo();

            int result = dfs(SMALL_LINE_TO, 0);
            System.out.println(LINE_COUNT-result);
            printLIne();


        } catch (InputMismatchException inputMismatch)
        {
            System.out.println("wrong input format");
        }
        scanner.close();

    }


    public static int dfs(int[] inputData , int index) {

        if( index == LINE_COUNT-1) return 0;

        int saved = inputData[index];


        inputData[index] = 0;
        int exceptMe = dfs(inputData, index+1);
        inputData[index] = saved;

        if( saved == 0 ) return exceptMe;

        int[] COPYED_LINE_TO = new int[LINE_COUNT];
        System.arraycopy( inputData, 0, COPYED_LINE_TO, 0, LINE_COUNT);

        for (int i = index+1; i < LINE_COUNT; i++) {
            if(inputData[index] > inputData[i]) {
                COPYED_LINE_TO[i] = 0;
            }
        }

        int includeMe = 1 + dfs(COPYED_LINE_TO, index+1);


        return Math.max(exceptMe, includeMe);

    }



    public static void printLIne(){
        if( !DEBUG ) return;
        for (int i = 0; i < LINE_COUNT; i++) {
            System.out.println( i + " " + SMALL_LINE_TO[i]);
        }
        if( isCross() ) System.out.println( " cross line exists ");
    }

    public static boolean isCross() {

        for (int i = 0; i < LINE_COUNT-1; i++) {
            if( SMALL_LINE_TO[i] > SMALL_LINE_TO[i+1] ) return true;
        }

        return false;

    }

    public static void makeSmallLineTo() {

        int index = 0;
        for (int i = 1; i < 501 && index < LINE_COUNT; i++) {
            if( LINE_TO[i] == 0 ) continue;
            SMALL_LINE_TO[index++] = LINE_TO[i];
        }
    }

}
