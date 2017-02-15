package edu.htc.tictactoe;

import java.util.ArrayList;

/**
 * Created by Joel on 2/24/2016.
 */
public class GameBoard {

        private ArrayList<Integer> openSquares;
        private char chBoard[];
        private int[][] winCombinations = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {3, 5, 7}, {1, 5, 9}, {1, 4, 7}, {2, 5, 8}, {3, 6, 9}};


        public GameBoard() {
            int oSqr;
            chBoard = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};

            openSquares = new ArrayList<Integer>(9);
            for (oSqr = 1; oSqr < 10; oSqr++) {
                openSquares.add(oSqr);
            }
        }
    public GameBoard(char[] board) {
        this.chBoard = board;
        openSquares = new ArrayList();
        for (int i = 1; i < board.length; i++){
            char c = board[i];
            if (c != 'X' && c != 'O') {
                openSquares.add(i + 1);
            }
        }

    }

        public static void main(String[] args) {
            System.out.println();
            System.out.println("___-**-___-**-___-**-___-**-___");
            System.out.println("Welcome to the test for the GameBoard class, please do enjoy!");
            System.out.println("___-**-___-**-___-**-___-**-___");
            testGameBoardDisplay();
            testIsSquareOpen();
            testBoardInteractions();
            System.out.println("___-**-___-**-___-**-___-**-___");
            System.out.println("End of testing the game board!");

        }

        public static void testIsSquareOpen() {
            System.out.println();
            System.out.println("___-**-___-**-___-**-___-**-___");
            System.out.println("Testing is square open method");
            GameBoard gbTest = new GameBoard();
            gbTest.display();

            System.out.println("Testing with an empty board, AKA, ALL squares should be open.");
            boolean error = false;
            for (int i = 0; i <= 9; i++) {
                if (gbTest.isSquareOpen(i) == false) {
                    error = true;
                    System.out.println("Error. Square " + i + "is NOT open but should be!");
                }
            }
            if (error == false) {
                System.out.println("All squares are open!");
            }
            System.out.println();
            System.out.println("Testing after updates");
            System.out.println("Update Square 1 with X.");
            gbTest.updateSquare(1, 'X');
            if (gbTest.isSquareOpen(1)) {
                System.out.println("error. Square 1 is still open");
            } else {
                System.out.println("correct. Square 1 is no longer open");
            }
            for (int i = 2; i <= 9; i++) {
                if (!gbTest.isSquareOpen(i)) {
                    System.out.println("error. square " + i + " is Not open but should be!");
                }
            }

            System.out.println("end testing of OpenSquare");
        }





        public static void testGameBoardDisplay() {

            System.out.println();
            System.out.println("___-**-___-**-___-**-___-**-___");
            System.out.println("Testing board display");
            GameBoard gbTest = new GameBoard();

            System.out.println("testing empty board display");
            gbTest.display();

            System.out.println("Testing display of board after adding.");
            gbTest.updateSquare(6, 'X');
            gbTest.updateSquare(3, 'O');
            gbTest.updateSquare(8, 'X');
            gbTest.updateSquare(4, 'O');
            gbTest.display();
            System.out.println("end testing of display board");


        }
        public static void testBoardInteractions(){
            System.out.println();
            System.out.println("___-**-___-**-___-**-___-**-___");
            System.out.println("Testing board interactions such as getting square value, adding win, and getting open squares ");
            char[] brdWinTest = new char[]{'X', 'X', 'X', '4', 'O', '6', '7', 'O', '9'};
            GameBoard gbTest = new GameBoard(brdWinTest);
            gbTest.display();
            if (gbTest.isGameWon()){
                System.out.println("Game won" );
            }
            else {
                System.out.println("Game not won, keep on playing!");
            }
            char[] brdLoseTest = new char[]{'X', '2', 'X', 'O', 'O', '6', '7', 'O', '9'};
            GameBoard gbTest2 = new GameBoard(brdLoseTest);
            gbTest2.display();
            if (gbTest2.isGameWon()){
                System.out.println("Game won" );
            }
            else {
                System.out.println("Game not won, keep on playing!");
            }
            System.out.println();
            System.out.println("___-**-___-**-___-**-___-**-___");
            System.out.println("Now we shall test the getting open squares method, as well as the get Square value");

                    int[] TestSqrs1 = gbTest2.getOpenSquares();
                    for (int i = 0; i<TestSqrs1.length; i++){
                            System.out.println(TestSqrs1[i]);
                        }
                    System.out.println("What is the value of square 4: " + gbTest.getSquareValue(4));
                    System.out.println("What is the value of square 6: " + gbTest.getSquareValue(6));
            System.out.println("End of Testing board interactions");
            System.out.println("___-**-___-**-___-**-___-**-___");

        }

        public void display() {

            System.out.println("___________");
            System.out.println(chBoard[0] + " | " + chBoard[1] + " | " + chBoard[2] + " |");
            System.out.println("--|---|--");
            System.out.println(chBoard[3] + " | " + chBoard[4] + " | " + chBoard[5] + " |");
            System.out.println("--|---|--");
            System.out.println(chBoard[6] + " | " + chBoard[7] + " | " + chBoard[8] + " |");
            System.out.println("--|---|--");
            System.out.println("___________");
        }

         public boolean isSquareOpen(int brdSpot) {


           return openSquares.contains(brdSpot);
         }

        public void updateSquare(int bSpot, char pCurs) {
            chBoard[bSpot-1] = pCurs;
            openSquares.remove(new Integer(bSpot));
        }






        public boolean isGameWon() {


            for (int[] win : winCombinations) {
                char spt1 = chBoard[win[0]-1];
                char spt2 = chBoard[win[1]-1];
                char spt3 = chBoard[win[2]-1];
                if (spt1 == spt2 && spt1 == spt3) {
                    return true;
                }
            }
            return false;

        }

    public int[] getOpenSquares(){
        int[] openSpotsArray = new int[openSquares.size()];
        for (int i=0; i < openSpotsArray.length; i++)
        {
            openSpotsArray[i] = openSquares.get(i);
        }
        return openSpotsArray;
    }
    public char getSquareValue(int x) {
        return chBoard[x-1];
    }


    public void reset() {
        int oSqr;
        chBoard = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};

        openSquares = new ArrayList<Integer>(9);
        for (oSqr = 1; oSqr < 10; oSqr++) {
            openSquares.add(oSqr);
        }

    }



    }

