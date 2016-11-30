package com.baekjoon.b10835;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] LD;
    public static int[] RD;
    public static int DC;
    public static int LDSUM = 0;
    public static int RDSUM = 0;
    public static int[][] MEM ;

    public static void main(String... arg) throws Exception{


        FileInputStream in = new FileInputStream("D:\\source\\jungol\\src\\main\\java\\com\\baekjoon\\b10835\\input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DC = Integer.parseInt(br.readLine());

        LD = new int[DC];
        RD = new int[DC];
        MEM = new int[DC+1][DC+1];

        StringTokenizer st ;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < DC; i++) {
            LD[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < DC; i++) {
            RD[i] = Integer.parseInt(st.nextToken());
            RDSUM += RD[i];
        }

        for (int i = 0; i < DC+1; i++) {
            for (int j = 0; j < DC+1; j++) {
                MEM[i][j] = -1;
            }
        }

        System.out.println(solve5(0, 0));
        //System.out.println(solve2(0, 0));
        //System.out.println(solve3(0, 0));
    }

    private static int solve5(int L, int R) {
        if( L >= DC || R >= DC ) return 0;

        if( MEM[L][R] >= 0 ) return MEM[L][R];

        int sum = Math.max(solve5(L+1,R+1), solve5(L+1,R));
        if( LD[L] > RD[R]) {
            sum = Math.max(sum, solve5(L,R+1)+RD[R]);
        }

        MEM[L][R] = sum;
        return sum;

    }

    private static int solve4(int L, int R) {
        if( L >= DC || R >= DC ) return 0;

        if( MEM[L][R] > 0 ) return MEM[L][R];

        int sum = 0;

        // 오른쪽이 작은 경우
        while( LD[L] > RD[R] ) {
            sum += RD[R++];
            if( R >= DC ) break;
        }

        sum += Math.max(solve4(L+1,R+1), solve4(L+1,R));

        MEM[L][R] = sum;
        return sum;

    }


    private static int solve(int ldIndex, int rdIndex, int rdSum) {

        if( rdIndex >= DC || ldIndex >= DC) return 0;

        int sum = 0;

        // 오른쪽이 작은 경우
        while( LD[ldIndex] > RD[rdIndex] ) {
            sum += RD[rdIndex++];
            if( rdIndex >= DC ) return sum;
        }
        RDSUM -= sum;

        // 둘다 빼는 경우
        int leftResult = solve(ldIndex+1, rdIndex+1,  RDSUM - RD[rdIndex]);
        if( leftResult >= RDSUM  || RDSUM <= 0 ) return sum += leftResult;

        // 왼쪽만 빼는 경우
//        while( LD[ldIndex] <= LD[ldIndex+1]) {
//
//        }


        int rightResult = solve(ldIndex+1, rdIndex, RDSUM);

        // 좌측만 빼는 것과 둘다 뺀 것을 비교하여 큰 값을 return
        sum += Math.max(leftResult, rightResult);
        return sum;
    }

    private static int solve2(int ldIndex, int rdIndex) {

        if( rdIndex >= DC || ldIndex >= DC) return 0;

        int sum = 0;

        // 오른쪽이 작은 경우
        while( LD[ldIndex] > RD[rdIndex] ) {
            sum += RD[rdIndex++];
            if( rdIndex >= DC ) return sum;
        }

        // 둘다 빼는 경우
        int leftResult = solve2(ldIndex+1, rdIndex+1);

        // 왼쪽만 빼는 경우
        int rightResult = solve2(ldIndex+1, rdIndex);

        // 좌측만 빼는 것과 둘다 뺀 것을 비교하여 큰 값을 return
        sum += Math.max(leftResult, rightResult);
        return sum;
    }

    private static int solve3(int ldIndex, int rdIndex) {

        if( rdIndex >= DC || ldIndex >= DC) return 0;

        int sum = 0;

        // 오른쪽이 작은 경우
        while( LD[ldIndex] > RD[rdIndex] ) {
            sum += RD[rdIndex++];
            if( rdIndex >= DC ) return sum;
        }

        // 둘다 빼는 경우
        int leftResult = solve3(ldIndex+1, rdIndex+1);

        // 왼쪽만 빼는 경우

        while( ldIndex + 1 < DC && LD[ldIndex+1] <= RD[rdIndex] ) {
           ldIndex++;
            if( rdIndex >= DC ) return sum;
        }

        int rightResult = solve3(ldIndex+1, rdIndex);

        // 좌측만 빼는 것과 둘다 뺀 것을 비교하여 큰 값을 return
        sum += Math.max(leftResult, rightResult);
        return sum;
    }
}
