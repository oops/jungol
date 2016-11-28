package com.oops.jj1257;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 *
 */

public class Main {

    public static int LINE_COUNT;
    public static int[] LINE_TO;
    public static int[] SMALL_LINE_TO;
    public static int[] SMALL_LINE_TO_ORG;
    public static int[] USE_01;
    public static int[] endAtMeSize;

    public static boolean DEBUG = true;
    public static Map<String, Integer> mem = new HashMap<String, Integer>();
    public static int CURRENT_MAX = 0;

    public static void main(String... arg) throws Exception
    {

        Scanner scanner = null;
        try
        {
            System.setIn(new FileInputStream("D:\\source\\jungol\\src\\main\\java\\com\\oops\\jj1257\\input.txt"));
            scanner = new Scanner(System.in);
            LINE_COUNT = scanner.nextInt();
            LINE_TO = new int[501];
            SMALL_LINE_TO = new int[LINE_COUNT];
            SMALL_LINE_TO_ORG = new int[LINE_COUNT];
            USE_01 = new int[LINE_COUNT];

            int from ;
            int to;
            for(int i = 1 ; i< LINE_COUNT+1; i++ ) {
                from = scanner.nextInt();
                to = scanner.nextInt();
                LINE_TO[from] = to;
            }
            makeSmallLineTo();

            System.out.println(SMALL_LINE_TO.length - lis(SMALL_LINE_TO));
            printLIne();
            printEndAtMeWithoutZero();

        } catch (InputMismatchException inputMismatch)
        {
            System.out.println("wrong input format");
        }
        scanner.close();

    }


    /**
     * http://blog.naver.com/rym/220504883742
     * @param inputData
     * @return
     */
    public static int lis(int[] inputData ) {

        // ?? ??? LIS ????
        endAtMeSize = new int[inputData.length];

        for (int i = 0; i < inputData.length; i++) {
            // ?? ??? lis? ???? ?? 1   - ?? ??? ???....
            endAtMeSize[i] = 1;
            for (int j = 0; j < i; j++) {
                
                //   ?? ?? ?? ??? ?? && ?? ?? ??? ??? ?? ???? ? ??
                //   ?? ?? ???? ?? ???? 1 ? ? ?? ??.
                if(  inputData[i] > inputData[j] &&  endAtMeSize[i] <= endAtMeSize[j] ) {
                    endAtMeSize[i] = endAtMeSize[j] + 1;
                }
            }
        }

        // ?? ???? ??? ?? ?? ??? ??? ??.
        int max = 0;
        for (int i = 0; i < endAtMeSize.length; i++) {
            max = Math.max(max, endAtMeSize[i]);
        }

        System.out.println("====================");
        for (int i = 0; i < endAtMeSize.length; i++) {

            System.out.println(endAtMeSize[i]);
        }
        for (int i = endAtMeSize.length-1; i >=0 ; i--) {

            if( endAtMeSize[i] == max ) {
                max--;
            } else {
                endAtMeSize[i] = 0;
            }
        }

        return max;


    }

    public static void printLIne(){
        System.out.println("=====================");
        if( !DEBUG ) return;
        for (int i = 0; i < LINE_COUNT; i++) {
            System.out.println( i + " " + SMALL_LINE_TO[i]);
        }
    }

    public static void printEndAtMeWithoutZero(){
        if( !DEBUG ) return;
        System.out.println("=====================");
        for (int i = 0; i < endAtMeSize.length; i++) {
            if( endAtMeSize[i] > 0 ) System.out.println(SMALL_LINE_TO[i]);
        }
    }


    public static void makeSmallLineTo() {

        int index = 0;
        for (int i = 1; i < 501 && index < LINE_COUNT; i++) {
            if( LINE_TO[i] == 0 ) continue;
            SMALL_LINE_TO[index] = LINE_TO[i];
            SMALL_LINE_TO_ORG[index] = LINE_TO[i];
            index++;
        }

    }

}
