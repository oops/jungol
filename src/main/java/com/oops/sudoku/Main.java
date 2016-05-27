package com.oops.sudoku;

import java.io.FileInputStream;
import java.util.*;

/**
 * Created by oops on 2016. 4. 26..
 */


public class Main {

    public static int INPUT_COUNT;
    public static int sudokuSize = 9;
    public static int[][] SUDOKU = new int[sudokuSize][sudokuSize];
    public static int remainCount = sudokuSize * sudokuSize;

    public static int[] remainCountInRow = {9,9,9,9,9,9,9,9,9};
    public static int[] remainCountInColumn = {9,9,9,9,9,9,9,9,9};
    public static int[] remainCountInMatrix = {9,9,9,9,9,9,9,9,9};

    public static ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

    public static boolean DEBUG = false;
    public static boolean INPUT = true;

    public static void main(String... arg) throws Exception
    {

        Scanner scanner = null;
        try
        {
            if(DEBUG)System.out.println("Enter the number of nodes in the graph");
            if(INPUT) System.setIn(new FileInputStream("/users/oops/IdeaProjects/test1/src/main/java/com/oops/sudoku/input.txt"));
            scanner = new Scanner(System.in);
            for(int i = 0 ; i< sudokuSize; i++ ) {
                for (int j = 0; j < sudokuSize; j++) {
                    SUDOKU[i][j] = scanner.nextInt();
                    if( SUDOKU[i][j] != 0 ) {
                        remainCount--;
                        remainCountInRow[i] -= 1;
                        remainCountInColumn[j] -= 1;
                    } else {
                        deque.add( ( i+1 ) * 10 + j + 1 );
                    }
                }
            }

            if( DEBUG) System.out.println( " deque size " + deque.size());

            if(DEBUG) printSudoku();

            while( remainCount > 0 ) {
                int solvedCount = checkRow() + checkColumn();
                if( solvedCount > 0 ) continue;
                else break;
            }

            while(remainCount > 0 ) {
                checkAllMatrixOnce();
                while( remainCount > 0 ) {
                    int solvedCount = checkRow() + checkColumn();
                    if( solvedCount > 0 ) continue;
                    else break;
                }
            }

            printSudoku();


        } catch (InputMismatchException inputMismatch)
        {
            System.out.println("wrong input format");
        }
        scanner.close();

    }

    public static int checkRow(){
        int result = 0;
        for (int rowI = 0; rowI < sudokuSize; rowI++) {
            if(remainCountInRow[rowI] == 1 ) {
                Set<Integer> mySet = new HashSet<Integer>();
                for (int j = 1; j <= sudokuSize; j++) {
                    mySet.add(j);
                }

                int zeroColumn = -1;
                for (int j = 0; j < sudokuSize; j++) {
                    if( SUDOKU[rowI][j] != 0 ) mySet.remove(SUDOKU[rowI][j]);
                    else zeroColumn = j;
                }
                SUDOKU[rowI][zeroColumn] = mySet.iterator().next();
                remainCountInRow[rowI] -= 1;
                remainCountInColumn[zeroColumn] -= 1;
                remainCount--;
                result = 1;
                if( deque.contains( (rowI+1)*10+zeroColumn+1 ))  deque.removeFirstOccurrence((rowI+1)*10+zeroColumn+1 );
                if( DEBUG) System.out.println( "row  " + rowI + "    column " + zeroColumn + "   changed to " + SUDOKU[rowI][zeroColumn]);
                if( DEBUG) printSudoku();
            }
        }
        return result;
    }


    public static int checkColumn(){
        int result = 0;
        for (int columnI = 0; columnI < sudokuSize; columnI++) {
            if(remainCountInColumn[columnI] == 1 ) {
                if(DEBUG)printSudoku();
                Set<Integer> mySet = new HashSet<Integer>();
                for (int j = 1; j <= sudokuSize; j++) {
                    mySet.add(j);
                }

                if( columnI == 1 ) {
                    String stopHere = "abc";
                }

                int zeroRow = -1;
                for (int j = 0; j < sudokuSize; j++) {
                    if( SUDOKU[j][columnI] != 0 ) mySet.remove(SUDOKU[j][columnI]);
                    else zeroRow = j;
                }

                if( mySet.size() != 1) {
                    System.out.println("Something wrong");
                    printSudoku();
                }

                SUDOKU[zeroRow][columnI] = mySet.iterator().next();
                remainCountInRow[zeroRow] -= 1;
                remainCountInColumn[columnI] -= 1;
                remainCount--;
                result = 1;
                if( deque.contains( (zeroRow+1)*10+columnI+1 ))  deque.removeFirstOccurrence((zeroRow+1)*10+columnI+1 );
                if( DEBUG ) System.out.println( "row  " + zeroRow + "    column " + columnI + "   changed to " + SUDOKU[zeroRow][columnI]);
                if( DEBUG)printSudoku();
            }
        }
        return result;
    }


    public static void checkAllMatrixOnce() {
        if(DEBUG) System.out.println("run solveOnce with remainCount " + remainCount);

        int dequeSize = deque.size();
        if(DEBUG)System.out.println( deque.size());
        while( dequeSize-- > 0 ) {
            if(DEBUG) System.out.println( "Start While ");
            int dequeValue = deque.peek();
            int i = ( dequeValue / 10 ) -1;
            int j = ( dequeValue % 10 ) -1;
            if(SUDOKU[i][j] == 0 && insertOnlyOneSolution(i, j) ==1 ) {
                remainCount--;
                remainCountInRow[i] -= 1;
                remainCountInColumn[j] -= 1;
            }
            else deque.add(dequeValue);
            if(DEBUG)System.out.println("copyed size = " + dequeSize + "  real size " + deque.size());
        }



//        for(int i = 0 ; i< sudokuSize; i++ ) {
//            for (int j = 0; j < sudokuSize; j++) {
//                if(SUDOKU[i][j] == 0 && insertOnlyOneSolution(i, j) ==1 ) {
//                    remainCount--;
//                    remainCountInRow[i]--;
//                    remainCountInColumn[i]--;
//                }
//            }
//        }
        if(DEBUG) printSudoku();
        if(DEBUG) System.out.println("end solveOnce with remainCount " + remainCount);

    }

    public static int insertOnlyOneSolution(int row , int column ) {
        Set<Integer> mySet = new HashSet<Integer>();
        for (int i = 1; i <= sudokuSize; i++) {
            mySet.add(i);
        }
        if( mySet.size() == 1 ) {
            SUDOKU[row][column] = mySet.iterator().next();
            return 1;
        }

        for (int i = 0; i < sudokuSize; i++) {
            if( i != row && SUDOKU[i][column] != 0 ) mySet.remove(SUDOKU[i][column]);
        }
        if( mySet.size() == 1 ) {
            SUDOKU[row][column] = mySet.iterator().next();
            return 1;
        }

        for (int i = 0; i < sudokuSize; i++) {
            if( i != column && SUDOKU[row][i] != 0 ) mySet.remove(SUDOKU[row][i]);
        }
        if( mySet.size() == 1 ) {
            SUDOKU[row][column] = mySet.iterator().next();
            return 1;
        }

        int rowStart = (row / 3 ) * 3;
        int columnStart = ( column / 3 ) * 3 ;

        for(int i = rowStart ; i<rowStart + 3 ; i++ ) {
            for(int j = columnStart ; j<columnStart + 3 ; j++ ) {
                if( i != row && i != column && SUDOKU[i][j] != 0 ) mySet.remove(SUDOKU[i][j]);
            }
        }

        if( mySet.size() == 1 ) {
            SUDOKU[row][column] = mySet.iterator().next();
            return 1;
        }

        return 0;

    }

    public static void printSudoku() {
        if(DEBUG) System.out.println("START=========================");
        for(int i = 0 ; i< sudokuSize; i++ ) {
            for (int j = 0; j < sudokuSize; j++) {
                System.out.print(SUDOKU[i][j]+" ");
            }
            System.out.println("");
        }
        if(DEBUG) System.out.println("END===========================");

    }

}
