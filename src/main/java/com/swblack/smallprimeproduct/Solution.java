package com.swblack.smallprimeproduct;


import java.io.FileInputStream;
import java.util.*;

public class Solution {

    public static void main(String... arg) throws Exception{

        Scanner scanner = null;
        FileInputStream in = new FileInputStream("D:\\source\\jungol\\src\\main\\java\\com\\swblack\\smallprimeproduct\\input.txt");
        scanner = new Scanner(in);
        int QUESTION_COUNT = scanner.nextInt();

        SortedSet<Long> s2 =  new TreeSet<>();
        SortedSet<Long> s3 =  new TreeSet<>();
        SortedSet<Long> s5 =  new TreeSet<>();
        SortedSet<Long> s7 =  new TreeSet<>();

        s2.add(2L);
        s3.add(3L);
        s5.add(5L);
        s7.add(7L);
        long[] spp = new long[5843];
        int[] qn = new int[QUESTION_COUNT+1];
        int MAX = 0;
        for (int i = 1; i <= QUESTION_COUNT; i++) {
            int index = scanner.nextInt();
            qn[i] = index;
            MAX = ( MAX > index ) ? MAX : index ;
        }


        spp[1] = 1;
        int index = 2;

        for (int i = 2; i <= MAX; i++) {
            long min = Math.min(s7.first(), Math.min(s5.first(), Math.min( s2.first(), s3.first())));
            spp[index++] = min;
            if( min == s2.first()) {
                s2.remove(min);
                s2.add(min*2);
                s3.add(min*3);
                s5.add(min*5);
                s7.add(min*7);
            } else if( min == s3.first()) {
                s3.remove(min);
                s3.add(min*3);
                s5.add(min*5);
                s7.add(min*7);
            } else if( min == s5.first()) {
                s5.remove(min);
                s5.add(min*5);
                s7.add(min*7);
            } else if( min == s7.first()) {
                s7.remove(min);
                s7.add(min*7);
            }
        }

        for (int i = 1; i <= QUESTION_COUNT ; i++) {
            System.out.printf("#%d %d\n", i, spp[qn[i]]);
        }
    }
}
