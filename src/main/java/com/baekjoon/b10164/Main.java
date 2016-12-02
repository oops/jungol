package com.baekjoon.b10164;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String... args) throws Exception {

        FileInputStream in = new FileInputStream("D:\\source\\jungol\\src\\main\\java\\com\\baekjoon\\b10164\\input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int result ;

        int xx = P % X ;
        int yy = P / X + 1;
        if( xx == 0 ) {
            xx = X;
            yy--;
        }

        if( P == 0 || X * Y == P || P == 1) result = solve2(X,Y, 0, 0 );
        else result = solve2(xx, yy, 0, 0) * solve2( X-xx+1 , Y-yy+1 , 0, 0);


        System.out.println(result);
    }

    private static int solve2(int X, int Y, int xx, int yy) {

        int mem = getMemData(X, Y, xx, yy);
        if( mem >= 0 ) {
            return mem;
        }

        int result = 0;
        if( X <2  || Y < 2 ) result = 1;
        if( X == 2 ) result = Y;
        if( Y == 2 ) result = X;

        if( result > 0 ) {
            setMemData(X, Y, xx, yy, result);
            return result;
        }


        if( xx == 0 || yy == 0 ) {
            for (int i = 1; i <= X && Y-i+1 > 0 ; i++) {
                result += solve2( X , Y  , i , Y-i+1) ;
            }
        } else {
            result = solve2(xx, yy, 0, 0) * solve2( X-xx+1 , Y-yy+1, 0, 0 );

        }

        setMemData(X, Y, xx, yy, result);
        return result;

    }

    public static int D = 20;
    public static Map<Integer, Integer> MEM = new HashMap<Integer, Integer>();


    public static int getMemData(int x1, int x2, int x3, int x4){
        int key = ((x1 * D + x2) * D + x3) * D + x4;
        if( MEM.containsKey(key)) {
            return MEM.get(key);
        }
        return -1;
    }

    public static void setMemData(int x1, int x2, int x3, int x4, int value){
        int key = ((x1 * D + x2) * D + x3) * D + x4;
        MEM.put(key, value);
    }



}
