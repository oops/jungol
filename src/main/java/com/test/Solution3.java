package com.test;

/**
 * Created by oops on 2016. 12. 28..
 */
public class Solution3 {
       public double solution(double[] A) {
        // write your code in Java SE 8
        double currentMax = 1;
        double currentMin = 1;
        double MAX = 0;
        double maxOne = Double.MIN_VALUE;
        double LIMIT = 1000000000;

        for(double d : A ) {
            maxOne = Math.max(maxOne, d );

            if( d > 0 ) {
                currentMax = Math.max(currentMax*d, 1 ) ;
                currentMin = Math.min(currentMin*d, 1 ) ;
            } else if ( d < 0 ) {
                double t = currentMax;
                currentMax = Math.max(currentMin*d, 1 ) ;
                currentMin = Math.min(t*d, 1 ) ;
            } else {
                currentMax = 1;
                currentMin = 1;
            }
            if( currentMax != 1 && currentMax > MAX ) MAX = currentMax;
        }

        if( maxOne < 1 ) MAX = maxOne;
        if( MAX > LIMIT ) MAX = LIMIT;

        return MAX;

    }


    public static void main(String...arg) {
        Solution3 s = new Solution3();
        double[] ii = {1.0, 0.1, -1.0, -7.0, 3.0, -5.0, -2.5, 0.0, 1.0};
        double result = s.solution(ii);
        System.out.println(result);
    }
}
