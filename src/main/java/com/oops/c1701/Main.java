package com.oops.c1701;

import java.io.FileInputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by oops on 2016. 4. 26..
 */

/*

DNA 서열은 4개의 문자 {a,c,g,t} 로 이루어진 문자열이다. DNA 서열에는 생명의 신비를 풀 수 있는 많은 정보가 들어 있다. 특히 KOI 유전자의 길이는 생물의 수명과 깊은 상관 관계가 있다는 것이 알려져 있다. 이러한 KOI 유전자는 다음의 조건을 만족한다.
(1) at 와 gc 는 가장 짧은 길이의 KOI 유전자이다.
(2) 어떤 X가 KOI 유전자라면, aXt와 gXc도 KOI 유전자이다. 예를 들어, agct 와 gaattc는 KOI 유전자이나, tgca 와 cgattc는 KOI 유전자가 아니다.
(3) 어떤 X와 Y가 KOI 유전자라면, 이 둘을 연결한 XY도 KOI 유전자이다. 예를 들면, aattgc 또는 atat는 KOI 유전자이나 atcg 또는 tata는 KOI 유전자가 아니다.
KOI 유전자는 DNA 서열 중에서 부분 서열로 구성되어 있다. 부분 서열이란 주어진 서열에서 임의의 위치에 있는 0개 이상의 문자들을 삭제해서 얻어지는 서열이다. 예를 들면, DNA 서열 acattgatcg에서 두 번째 문자 c와 마지막 문자 g를 삭제하여 생긴 부분 서열aattgatc는 길이가 8인 KOI 유전자이다. 그러나 마지막 문자 g를 삭제하여 만들어진 부분 서열 acattgatc는 KOI 유전자가 아니다.
문제는 주어진 DNA 서열의 부분 서열들 중에서 길이가 최대가 되는 KOI 유전자를 찾아 그 길이를 출력하는 것이다.
 */
public class Main {

    public static String input = null;

    public static void main(String... arg) throws Exception
    {

        Scanner scanner = null;
        try
        {
            System.out.println("Enter the number of nodes in the graph");
            System.setIn(new FileInputStream("/users/oops/IdeaProjects/test1/src/main/java/com/oops/c1701/input.txt"));
            scanner = new Scanner(System.in);
            input = scanner.next();

            System.out.println(input);

        } catch (InputMismatchException inputMismatch)
        {
            System.out.println("wrong input format");
        }
        scanner.close();

        int solve = solve(0, 0, false, 0, '0', '0');
    }


    public static int solve(int startIndex, int contStartIndex, boolean contYn, int curIndex, char startChar, char contStartChar) {
        if( startIndex >= input.length()) return 0;
        System.out.println(input.charAt(curIndex));

        char curChar = input.charAt(curIndex);

        if( curChar == 'a' || curChar == 'g' ) {
            solve(curIndex, -1, false, curIndex+1, curChar, '0');
        } else {
            if( startChar == 'a' && curChar == 't' ) {
                return 2;
            }
        }





        return solve(startIndex, contStartIndex, contYn, curIndex+1, startChar, contStartChar);



    }

}
