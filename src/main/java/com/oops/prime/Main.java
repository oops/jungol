package com.oops.prime;

import java.util.ArrayDeque;


/**
 *
 */

public class Main {

    int start = 1033;
    int end = 8179;

    public static void main(String... arg) throws Exception
    {
        int[] prime = new int[10000];
        for (int i = 0; i < 10000; i++) {
            prime[i] = i;
        }

        for (int i = 2; i < 10000; i++) {
            if(prime[i] != 0) {
                for (int j = 2;  ; j++) {
                    if( i*j < 10000 ) {
                        prime[i*j] = 0;
                    } else {
                        break;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 1000; i < 10000; i++) {
            if( prime[i] != 0){
                System.out.println(i);
                count++;
            }
        }
        System.out.println(count);

        int[] visited = new int[10000];

        ArrayDeque<Integer> arr = new ArrayDeque<Integer>();





    }

}
