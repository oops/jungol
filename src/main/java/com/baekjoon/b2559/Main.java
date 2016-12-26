package com.baekjoon.b2559;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String... args) throws Exception {

        FileInputStream in = new FileInputStream("/Users/oops/IdeaProjects/jungol/src/main/java/com/baekjoon/b2559/input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCount = Integer.parseInt(st.nextToken());
        int sumCount = Integer.parseInt(st.nextToken());

        int[] tmpVal = new int[sumCount];

        st = new StringTokenizer(br.readLine());

        int sum = 0;
        int sumMax = Integer.MIN_VALUE;
        for (int i = 0; i < numCount ; i++) {
            sum -= tmpVal[i%sumCount];
            tmpVal[i%sumCount] = Integer.parseInt(st.nextToken());
            sum += tmpVal[i%sumCount] ;
            if( i < sumCount-1 ) continue;
            if( sum > sumMax ) sumMax = sum;
        }
        System.out.println(sumMax);

    }


}
