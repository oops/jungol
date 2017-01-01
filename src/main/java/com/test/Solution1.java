package com.test;

import java.util.StringTokenizer;

/**
 * Created by oops on 2016. 12. 28..
 */
public class Solution1 {
    public int solution(String S) {
        // write your code in Java SE 8
        int max = 0;
        int count = 0;
        for (String sent : S.split("\\.|\\?|\\!")) {
            count = new StringTokenizer(sent).countTokens();
            if( count > max ) max = count;
        }
        return max;
    }

    public static void main(String...arg) {
        Solution1 s = new Solution1();
        String S = "Forget  CVs..Save time . x x";
        String S2 = "We test coders. Give us a try?";
        System.out.println(s.solution(S));
        System.out.println(s.solution(S2));
    }
}
