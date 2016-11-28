package com.swblack.bignumber;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by SDS on 2016-11-25.
 */
public class Bignumber {
    public static void main(String... arg) throws Exception{
        //FileInputStream fis = new FileInputStream("D:\\source\\jungol\\src\\main\\java\\com\\swblack\\bignumber\\input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st ;

        int QUESTION_COUNT = Integer.parseInt(br.readLine());
        int N ;
        int K ;


        for (int i = 1; i <=QUESTION_COUNT; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            int[] num  = new int[N];
            int[] sortednum  = new int[N];
            int[] removeNum = new int[10];

            String largeNumber = br.readLine();

            for (int j = 0; j < largeNumber.length(); j++) {
                num[j] = Integer.parseInt(largeNumber.substring(j, j+1));
                sortednum[j] = num[j];
            }
            Arrays.sort(sortednum);

            for (int j = 0; j < K; j++) {
                removeNum[sortednum[j]] += 1;
            }

            StringBuffer sb = new StringBuffer();
            int numc = 0;
            int tempnum ;
            for (int j = 0; j < largeNumber.length() ; j++) {
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
