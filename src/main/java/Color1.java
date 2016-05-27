import java.io.FileInputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by oops on 2016. 4. 26..
 */
public class Color1 {
    public static void main(String... arg) throws Exception
    {
        int color_count;
        int find_count;
        int pos_count = 0;
        Scanner scanner = null;
        try
        {
            System.out.println("Enter the number of nodes in the graph");
            System.setIn(new FileInputStream("/users/oops/IdeaProjects/test1/src/main/resources/color_input.txt"));
            scanner = new Scanner(System.in);
            color_count = scanner.nextInt();
            find_count = scanner.nextInt();

        } catch (InputMismatchException inputMismatch)
        {
            System.out.println("wrong input format");
        }
        scanner.close();
    }
}
