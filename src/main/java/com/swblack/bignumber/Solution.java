package com.swblack.bignumber;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by SDS on 2016-11-25.
 */
public class Solution {
    public static void main(String... arg) throws Exception{
        Scanner scanner = null;


        scanner = new Scanner(System.in);


        int QUESTION_COUNT = scanner.nextInt();
        int N ;
        int K ;


        for (int i = 1; i <=QUESTION_COUNT; i++) {
            N = scanner.nextInt();
            K = scanner.nextInt();

            int[] num  = new int[N];
            int[] sortednum  = new int[N];
            int[] removeNum = new int[10];

            String largeNumber = scanner.next();
            System.out.println(largeNumber.length());
            for (int j = 0; j < N; j++) {
                num[j] = Integer.parseInt(largeNumber.substring(j, j+1));
                sortednum[j] = num[j];
            }
            Arrays.sort(sortednum);

            for (int j = 0; j < K; j++) {
                removeNum[sortednum[j]] += 1;
            }

            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < N ; j++) {
                if( removeNum[num[j]] > 0 ) {
                    removeNum[num[j]] -= 1;
                } else {
                    sb.append(num[j]);
                }
            }

            System.out.println("#" + i + " " + sb.toString());
        }

    }

}
