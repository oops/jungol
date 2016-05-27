import java.util.Scanner;

/**
 * Created by sds on 2016-05-13.
 */
public class PageTransition {

    public static int MAX_N = 500;
    public static int N = 0;
    public static int NODE_COUNT = 0;
    public static int[][] array;
    public static int totalSum = 0;

    public static int[][] existsRow;
    public static int[][] existsCol;
    public static int[] existsRowSize;
    public static int[] existsColSize;

    public static void main(String[] args) {
        totalSum = 0;

        Scanner scanner = new Scanner(System.in);
        int inputCount = scanner.nextInt();
        array = new int[MAX_N+1][MAX_N+1];
        existsRow = new int[MAX_N + 1][MAX_N];
        existsCol = new int[MAX_N + 1][MAX_N];
        existsRowSize = new int[MAX_N];
        existsColSize = new int[MAX_N];

        for(int i=0; i<inputCount; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();

            if(N < from) N = from;
            if(N < to) N = to;

            array[from][to] = 1;
            existsRow[from][existsRowSize[from]] = to;
            existsCol[to][existsColSize[to]] = from;
            existsRowSize[from] = existsRowSize[from] + 1;
            existsColSize[to] = existsColSize[to] + 1;

            if(NODE_COUNT < from) NODE_COUNT = from;
            if(NODE_COUNT < to) NODE_COUNT = to;

            totalSum ++;
        }

        for(int i=0; i<existsRowSize[1]; i++) {
            if(array[1][existsRow[1][i]] == 1) {
                visit(1, existsRow[1][i], 1);
            }
        }

        update(1);

        double avg = (double)totalSum / (N*(N-1));
        System.out.printf("%.3f", avg);
    }

    public static void visit(int initialNode, int node, int depth) {
        if(initialNode != node && (depth == 1 || array[initialNode][node] == 0)) {
            array[initialNode][node] = depth;

            if(depth > 1) {
                totalSum += depth;
            }

            for(int i=0; i<existsRowSize[node]; i++) {
                int next = existsRow[node][i];
                if(array[node][next] == 1) {
                    visit(initialNode, next, depth + 1);
                }
            }
        }
    }

    public static void update(int to) {

        int oldValue, newValue;

        for(int i=0; i<existsColSize[to]; i++) {
            int updateRow = existsCol[to][i];
            boolean bUpdated = false;

            for(int j=1; j<=NODE_COUNT; j++) {
                if(updateRow == j) {
                    continue;
                }

                oldValue = array[updateRow][j];
                newValue = array[to][j] + 1;

                if(oldValue > 0 && oldValue <= newValue) {
                    continue;
                }
                else {
                    array[updateRow][j] = newValue;
                    totalSum += newValue - oldValue;

                    bUpdated = true;
                }
            }

            if(bUpdated) {
                update(updateRow);
            }
        }
    }


}
