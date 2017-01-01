package com.oops.j1408;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

    public static int lineCount ;


    public static int[] lineArr;

    public static boolean DEBUG = false;

    public static void main(String... arg)
    {

        Scanner scanner = null;
        try
        {
            System.setIn(new FileInputStream("/users/oops/IdeaProjects/jungol/src/main/java/com/oops/j1408/input.txt"));
            scanner = new Scanner(System.in);
            lineCount = scanner.nextInt();

            lineArr = new int[501];
            int from ;
            int to ;
            
            
            for (int i = 0; i < lineCount; i++) {
                from = scanner.nextInt();
                to = scanner.nextInt();
                lineArr[from] = to;

            }


            for (int i = 1; i < 500; i++) {
                if( lineArr[i] != 0 )
                System.out.println(i +"th line connectecd to "+lineArr[i]);
            }

//            System.out.println(result);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner.close();

    }
// 특정 번호를 선택하고 정렬이 맞는지 여부를 판단한다 길이가 가장 긴 것을 찾고 전체길이 - 그 길이


}
