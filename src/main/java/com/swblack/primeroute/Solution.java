package com.swblack.primeroute;


import java.io.FileInputStream;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Solution {


    public static int primeyn[] = new int[10000];
    public static int primearr[] = new int[10000];
    public static int pow10[] = { 1, 10, 100, 1000};

    public static void main(String... arg) throws Exception{

        findPrimeArr();
        Scanner scanner = null;
        FileInputStream in = new FileInputStream("D:\\source\\jungol\\src\\main\\java\\com\\swblack\\primeroute\\input.txt");
        scanner = new Scanner(in);

        int QUESTION_COUNT = scanner.nextInt();

        for (int i = 1; i <=QUESTION_COUNT; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int result = solve(start, end);
            System.out.printf("#%d %d\n", i, result);
        }
    }

    private static int solve(int start, int end) {
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

        deque.add(start);

        int n = 0;
        int[] digitat = new int[5];
        int newn = 0;
        int step = 0;

        while( deque.size() > 0 ) {
            n = deque.pop();

            digitat[0] =  (n % 10) ;
            digitat[1] =  (n % 100) / 10;
            digitat[2] =  (n % 1000) / 100;
            digitat[3] =  (n % 10000) / 1000;
            digitat[4] =  (n / 10000);
           // System.out.println(deque.size());
            for (int i = 0; i < 10; i++) {
                if (n % 10000 == end) return (int) (n / 10000);
                for (int j = 0; j < 4; j++) {
                    if (i == 0 && j == 3) continue;
                    if( digitat[j] == i) continue;
                    newn =  n - (digitat[j] * pow10[j]) + (i * pow10[j]);
                    //System.out.printf("%8d %8d %8d, %8d\n", n, newn, digitat[j], j);
                    if (newn % 10000 == end) return (int) (n / 10000) + 1;
                    if( primeyn[newn%10000] == 1) {
                        deque.add(newn + 10000);
                    }
                }
            }
        }
        return -1;
    }

    private static void findPrimeArr() {
        for (int i = 2; i < 10000 ; i++) {
            int index = 0;
            boolean prime = true;
            while(primearr[index] > 0 && prime) {
                if( i % primearr[index] == 0) {
                    prime = false;
                } else {
                    index++;
                }
            }
            if( prime) {
                primearr[index] = i;
                primeyn[i] = 1;
            }
        }

    }

}
