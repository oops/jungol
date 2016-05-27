import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sds on 2016-05-19.
 */
public class Sausage {
    public static int N = 0;
    public static long array[] ;
    public static int done[];

    public static void main(String[] args) {

        int count = 0;

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        array = new long[N];
        done = new int[N];

        for(int i=0; i<N; i++) {
            long x = scanner.nextInt();
            long y = scanner.nextInt();
            array[i] = x * 1000000 + y;
        }

        Arrays.sort(array);

        int doneCount = 0;
        long height = 0;
        while(doneCount < N) {
            height = 0;
            for(int i=0; i<array.length; i++) {
                if(done[i] == 0 && array[i] % 1000000 >= height) {
                    height = array[i] % 1000000;
                    done[i] = 1;
                    doneCount++;
                }
            }
            count++;
        }

        System.out.println(count);
    }
}
