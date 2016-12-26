package com.baekjoon.b2468;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by SDS on 2016-12-02.
 */
public class Main {

    public static int N ;
    public static int[][] loc;
    public static boolean[][] visited;  // 방문안했으면 0, 방문했으면 1
    public static int[][] locCopy;  // 잠기면 -1, 0보다 크면 안잠김.
    public static int SAFEMAX = 0;

    public static void main(String... args) throws Exception {
        FileInputStream in = new FileInputStream(new File("D:\\source\\jungol\\src\\main\\java\\com\\baekjoon\\b2468\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        loc = new int[N][N];
        locCopy = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                loc[i][j] = Integer.parseInt(st.nextToken());
                if( loc[i][j] < min) min = loc[i][j];
                if( loc[i][j] > max) max = loc[i][j];
            }
        }

        if( min == max) {
            SAFEMAX = 1;
            System.out.println(SAFEMAX);
            return;
        }

        for (int k = min; k < max; k++) {
            init(k);
            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if( loc[i][j] > 0 && !visited[i][j]) {
                        sum++;
                        dfs(i,j);
                    }
                }
            }
            if( sum > SAFEMAX) SAFEMAX = sum;
        }

        System.out.println(SAFEMAX);



    }


    public static int[] di = {1, -1, 0, 0 };
    public static int[] dj = {0, 0, 1, -1 };

    public static void dfs(int i, int j) {
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int ni = i + di[k];
            int nj = j + dj[k];
            if(  ni >= 0 && ni < N && nj >= 0 && nj < N ) {
                if (!visited[ni][nj] && locCopy[ni][nj] > 0) {
                    dfs(ni, nj);
                }
            }
        }
    }

    public static void init(int k) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                locCopy[i][j] = (loc[i][j] <= k) ? -1 : loc[i][j];
                visited[i][j] = false;
            }
        }
    }


}
