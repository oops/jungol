package com.test;

/**
 * Created by oops on 2016. 12. 28..
 */
public class Solution2 {
    public int solution(String S) {
        // write your code in Java SE 8
        int openCount= 0;
        int closeCount = 0;
        int openIndex = 0;
        int closeIndex = S.length()-1;

        while( openIndex <= closeIndex ) {

            if( openCount <= closeCount ) {
                if( S.charAt(openIndex) == '(' ) openCount++;
                openIndex++;
            } else {
                if( S.charAt(closeIndex) == ')' ) closeCount++;
                closeIndex--;
            }
        }

        if( openCount > closeCount ) openIndex--;

        return  openIndex;

    }

    public static void main(String...arg) {
        Solution2 s = new Solution2();
        String Q = "(())))(";
        int result = s.solution(Q);
        System.out.println(result);
    }
}
