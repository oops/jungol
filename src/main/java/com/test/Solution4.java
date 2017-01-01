package com.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by oops on 2016. 12. 28..
 */
public class Solution4 {
       public int solution(int[] A) {

           Map<Integer, Integer> maxMap = new HashMap<Integer, Integer>();
           Map<Integer, Integer> minMap = new HashMap<Integer, Integer>();

           for(int i = 0 ; i<A.length ; i++ ) {
               if( !minMap.containsKey(A[i])) minMap.put(A[i], i);
               maxMap.put(A[i], i);
           }

           int maxOfMin = Integer.MIN_VALUE;
           int minOfMax = Integer.MAX_VALUE;

           Iterator<Integer> iter = minMap.keySet().iterator();
           while(iter.hasNext()) {

               int location = iter.next();

               int minMapValue = minMap.get(location);
               if( maxOfMin < minMapValue) maxOfMin = minMapValue;

               int maxMapValue = maxMap.get(location);
               if( minOfMax > maxMapValue) minOfMax = maxMapValue;

               System.out.printf("location %d, min %d, max %d , maxOfMin %d, minOfMax %d \n" , location, minMapValue, maxMapValue, maxOfMin, minOfMax );
           }

           if( minOfMax <= maxOfMin ) return maxOfMin - minOfMax + 1;
            return solution(Arrays.copyOf(A, maxOfMin+1));

        }


    public static void main(String...arg) {
        Solution4 s = new Solution4();
        int[] ii = {0,0,0};
        int result = s.solution(ii);
        System.out.println(result);
    }

}
