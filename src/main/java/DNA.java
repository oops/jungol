import java.util.Scanner;

/**
 * Created by sds on 2016-05-16.
 */
public class DNA {

    public static String input = "";
    public static int inputLength = 0;
    public static int[][] mem = new int[501][501];
    public static boolean[][] hit = new boolean[501][501];

    public static void main(String[] args) {

        int count = 0;

        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();

        StringBuilder builder;
        boolean foundNew = true;
        while(foundNew) {
            builder = new StringBuilder();
            foundNew = false;
            for(int i=0; i<input.length(); i++) {
                if(i < input.length() - 1 &&
                        (  (input.charAt(i) == 'a' && input.charAt(i+1) == 't')
                                || (input.charAt(i) == 'g' && input.charAt(i+1) == 'c'))) {

                    i ++;
                    count += 2;
                    foundNew = true;
                }
                else {
                    builder.append(input.charAt(i));
                }
            }
            input = builder.toString();
        }

        inputLength = input.length();
        int remainingCount = getMax(0, inputLength-1);
        System.out.println(count + remainingCount);
    }

    public static int getMax(int start, int end) {
        if(end - start < 2) return 0;

        if(hit[start][end]) {
            return mem[start][end];
        }

        int firstA = indexOf(start, end, 'a');
        int firstG = indexOf(start, end, 'g');

        if(firstA < 0 && firstG < 0) {
            return 0;
        }

        int max = 0;
        if(firstA >= 0) {
            for(int i=firstA+1; i<=end; i++) {
                if(input.charAt(i) == 't') {
                    int count = 2 + getMax(firstA+1, i-1) + getMax(i+1, end);
                    if(max < count)
                        max = count;
                }
            }
            int count = getMax(firstA+1, end);
            if(max < count)
                max = count;
        }

        if(firstG >= 0) {
            for(int i=firstG+1; i<=end; i++) {
                if(input.charAt(i) == 'c') {
                    int count = 2 + getMax(firstG+1, i-1) + getMax(i+1, end);
                    if(max < count)
                        max = count;
                }
            }
            int count = getMax(firstG+1, end);
            if(max < count)
                max = count;
        }

        mem[start][end] = max;
        hit[start][end] = true;
        return max;
    }

    public static int indexOf(int start, int end, char c) {
        for(int i=start; i<=end; i++) {
            if(input.charAt(i) == c) return i;
        }
        return -1;
    }
}
