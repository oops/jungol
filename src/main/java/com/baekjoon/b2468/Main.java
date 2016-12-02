package com.baekjoon.b2468;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by SDS on 2016-12-02.
 */
public class Main {

    public static int N ;
    public static int[][] loc;
    public static boolean[][] visited;  // 방문안했으면 0, 방문했으면 1
    public static int[][] locCopy;  // 잠기면 -1, 0보다 크면 안잠김.

    public void main(String... args) throws Exception {
        FileInputStream in = new FileInputStream(new File("D:\\source\\jungol\\src\\main\\java\\com\\baekjoon\\b2468\\input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        loc = new int[N][N];
        visited = new boolean[N][N];


    }


    public static int[] di = {1, -1, 0, 0 };
    public static int[] dj = {0, 0, 1, -1 };

//    public static void dfs(int i, int j) {
//        visited[i][j] = 1;
//        for (int k = 0; k < 4; k++) {
//            int ni = i + di[k];
//            int nj = j + dj[k];
//            if( visited[ni][nj] < 1)
//        }
//
//
//    }


}
