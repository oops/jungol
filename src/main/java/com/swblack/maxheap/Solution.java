package com.swblack.maxheap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static int[] solve;
    public static BigInteger MOD = BigInteger.valueOf(100000123);
    public static Map<Integer, BigInteger> map = new HashMap<Integer, BigInteger>();

    public static void main(String... arg) throws Exception{
        solveAll();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());
        for(int q = 1 ; q<=Q ; q++) {
            System.out.println("#" + q + " " + solve[Integer.parseInt(br.readLine()) + 1]);
        }
    }

    private static void solveAll() {
        solve = new int[14];
        solve[1] = 1;
        for (int i = 2; i <=12; i++) {
            solve[i] = binomialDD((int)Math.pow(2, i) -2 , (int)Math.pow(2, i-1) -1 )
                    .multiply(BigInteger.valueOf(solve[i-1]))
                    .mod(MOD)
                    .multiply(BigInteger.valueOf(solve[i-1]))
                    .mod(MOD)
                    .intValue();
        }
    }

    public static BigInteger binomial(int N, int K) {
        BigInteger ret = BigInteger.ONE;
        for (int i = 0; i < K; i++) {
            ret = ret.multiply(BigInteger.valueOf(N-i))
                    .divide(BigInteger.valueOf(i+1));
        }
        return ret;
    }

    public static BigInteger binomialDD(int N, int K ) {
        int key = N * 1000 + K;
        if( map.containsKey(key)) {
            return map.get(key);
        }
        BigInteger result =  binomial(N, K).mod(MOD);
        map.put(key, result);
        return result;
    }

}
