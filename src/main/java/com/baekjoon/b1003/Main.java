package com.baekjoon.b1003;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;

/**
 * Created by SDS on 2016-11-30.
 */
public class Main {

    public static int[] MEM0 = new int[50];
    public static int[] MEM1 = new int[50];

    public static void main(String... args) throws Exception {

        FileInputStream in = new FileInputStream("D:\\source\\jungol\\src\\main\\java\\com\\baekjoon\\b1003\\input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int qc = Integer.parseInt(br.readLine());

        MEM0[0] = 1;
        MEM1[1] = 1;

//        for (int i = 0; i <  qc; i++) {
//            int num = Integer.parseInt(br.readLine());
//            int result = solve(num);
//            System.out.println(result);
//        }

    }

//    private static int solve(int num) {
//
//        if(MEM[num] > 0 ) return MEM[num];
//
//        int result = solve(num-1) + solve(num-2);
//
//        MEM[num] = result;
//        return result;
//
//    }

}
