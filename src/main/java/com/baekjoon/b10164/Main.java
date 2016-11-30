package com.baekjoon.b10164;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by SDS on 2016-11-30.
 */
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

        if( P == 0 ) result = solve2(X,Y, 0, 0 );
        else result = solve2(xx, yy, 0, 0) * solve2( X-xx+1 , Y-yy+1 , 0, 0);


        System.out.println(result);
    }
//
//    private static int solve(int X, int Y) {
//
//
//
//        int result = 0;
//        if( X ==1 || Y == 1 ) result = 1;
//
//
//        for (int i = 1; i < X; i++) {
//
//            sum += solve( X -  , )
//        }
//
//    }
    private static int solve2(int X, int Y, int xx, int yy) {

        int result = 0;
        if( X ==1 || Y == 1 ) result = 1;
        if( X == 2 ) result = Y;
        if( Y == 2 ) result = X;

        if( result > 0 ) return result;


        if( xx == 0 || yy == 0 ) {
            for (int i = 1; i < X && Y-i > 0 ; i++) {
                result += solve2( X , Y  , i , Y-i+1) ;
            }
        } else {
            result = solve2(xx, yy, 0, 0) * solve2( X-xx+1 , Y-yy+1, 0, 0 );

        }

        return result;

    }


}
