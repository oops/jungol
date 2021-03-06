package com.oops.jj1408;

import java.io.FileInputStream;
import java.util.*;

/**
 *
 */

public class Main {

    public static int LINE_COUNT;
    public static int[] LINE_TO;
    public static int[] SMALL_LINE_TO;
    public static int[] SMALL_LINE_TO_ORG;
    public static int[] USE_01;

    public static boolean DEBUG = true;
    public static Map<String, Integer> mem = new HashMap<String, Integer>();
    public static int CURRENT_MAX = 0;

    public static void main(String... arg) throws Exception
    {

        Scanner scanner = null;
        try
        {
            System.setIn(new FileInputStream("D:\\source\\jungol\\src\\main\\java\\com\\oops\\jj1408\\input.txt"));
            scanner = new Scanner(System.in);
            LINE_COUNT = scanner.nextInt();
            LINE_TO = new int[501];
            SMALL_LINE_TO = new int[LINE_COUNT];
            SMALL_LINE_TO_ORG = new int[LINE_COUNT];
            USE_01 = new int[LINE_COUNT];

            int from ;
            int to;
            for(int i = 1 ; i< LINE_COUNT+1; i++ ) {
                from = scanner.nextInt();
                to = scanner.nextInt();
                LINE_TO[from] = to;
            }
            makeSmallLineTo();

//            System.out.println(LINE_COUNT-dfs(SMALL_LINE_TO));
            System.out.println(SMALL_LINE_TO.length - lis(SMALL_LINE_TO));

        } catch (InputMismatchException inputMismatch)
        {
            System.out.println("wrong input format");
        }
        scanner.close();

    }


    /**
     * http://blog.naver.com/rym/220504883742
     *  - 주어진 배열 S가 주어졌을 때, S[0 .. i]까지의 부분 배열에서 S[i]로 끝나는 LIS는 무엇인가?
     * @param inputData
     * @return
     */
    public static int lis(int[] inputData ) {

        // 나로 끝나는 LIS 저장하기
        int[] endAtMeSize = new int[inputData.length];

        for (int i = 0; i < inputData.length; i++) {
            // 나로 끝나는 lis의 초기값은 항상 1   - 나만 있으면 되니까....
            endAtMeSize[i] = 1;
            for (int j = 0; j < i; j++) {
                
                //   앞에 있는 값이 나보다 작고 && 앞에 꺼로 끝나는 것보다 나로 끝나는게 더 크면
                //   앞의 것을 포함하고 나를 포함하니 1 더 큰 값이 된다.
                if(  inputData[i] > inputData[j] &&  endAtMeSize[i] <= endAtMeSize[j] ) {
                    endAtMeSize[i] = endAtMeSize[j] + 1;
                }
            }
        }

        // 어떤 위치에서 끝나는 것이 가장 좋은지 찾으면 된다.
        int max = 0;
        for (int i = 0; i < endAtMeSize.length; i++) {
            max = Math.max(max, endAtMeSize[i]);
        }
        return max;


    }


    public static int dfs(int[] inputData ) {

        if( inputData.length == 1 ) return 1;

        ///////////////////////////////////////////////////////////////////////////////
        // 나를 빼고 가장 큰 값 찾기
        int[] copy1 = new int[inputData.length-1];
        System.arraycopy(inputData, 1, copy1, 0, inputData.length-1);
        int exceptMe = dfs(copy1);


        ///////////////////////////////////////////////////////////////////////////////
        // 나를 포함하고 가장 큰 값 찾기...
        // 나보다 큰 값들의 개수 구하기
        int excludeMeArraySize = 0;
        for (int i = 1; i < inputData.length; i++) {
            if(inputData[0] < inputData[i] ) excludeMeArraySize++;
        }

        // 나보다 큰게 없으면 그냥 끝
        if( excludeMeArraySize == 0 ) return exceptMe;

        // 나보다 큰 값들로만 array만들고
        int[] copy2 = new int[excludeMeArraySize];
        int copy2Index = 0;
        for (int i = 1; i < inputData.length; i++) {
            if(inputData[0] < inputData[i] ) copy2[copy2Index++] = inputData[i];
        }

        // 내가 포함되니 1 더하고 나머지만으로 가장 큰 값 찾기.
        int includeMe = 1 +dfs(copy2);
        ///////////////////////////////////////////////////////////////////////////////
        
        return Math.max(exceptMe, includeMe);

    }


    public static void printLIne(){
        if( !DEBUG ) return;
        for (int i = 0; i < LINE_COUNT; i++) {
            System.out.println( i + " " + SMALL_LINE_TO[i]);
        }
    }

    public static void makeSmallLineTo() {

        int index = 0;
        for (int i = 1; i < 501 && index < LINE_COUNT; i++) {
            if( LINE_TO[i] == 0 ) continue;
            SMALL_LINE_TO[index] = LINE_TO[i];
            SMALL_LINE_TO_ORG[index] = LINE_TO[i];
            index++;
        }

    }

}
