package edu.htc.tictactoe.Strategy;

import java.util.Random;
import edu.htc.tictactoe.GameBoard;
import edu.htc.tictactoe.player.ComputerPlayer;
import edu.htc.tictactoe.player.Player;

import java.util.ArrayList;
/**
 * Created by Joel on 3/13/2016.
 */
public abstract class TicTacToeStrategy {
    GameBoard gb;
   public TicTacToeStrategy(GameBoard gb)
   {
       this.gb = gb;
   }
    private int[][] winCombinations = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {3, 5, 7}, {1, 5, 9}, {1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
   public static void main(String[] args) {

       testGetRandomMove();
       testBestOpenMove();
       testBlockWinStrategy ();
   }

   public static void testGetRandomMove (){
       System.out.println();
       System.out.println("___-**-___-**-___-**-___-**-___");
       System.out.println("Testing getRandomMove method");
       GameBoard gbTest = new GameBoard(new char[]{'1', 'X', 'O', 'X', '5', '6', '0', '8', 'X'});

       gbTest.display();
       TicTacToeStrategy ranStrat = new TicTacToeStrategy(gbTest) {

           public int getBestMove(){
               return 0;
           }

       };

       Player TestCPU = new ComputerPlayer("Test CPU", 'O', ranStrat);
       System.out.println("Player " + TestCPU.getName());
       System.out.println("Result is ");
       boolean error = false;
       int numberOfRuns = 50;
       do {


           for (int i = 0; i < numberOfRuns; i++) {

               int result = ranStrat.getRandomMove();
               if (result < 1 || result > 9) {
                   error = true;
                   System.out.println("Error! This result of " + result + " is out of range, it must be 1-9");
               } else if (gbTest.isSquareOpen(result) == false) {
                   error = true;
                   System.out.println("Error! That spot " + result + " is not open!");
               }
           }
       }while (error);
       System.out.println("No bad output was found in " + numberOfRuns + " tries.");
       System.out.println("___-**-___-**-___-**-___-**-___");
       System.out.println();
   }
    public static void testBestOpenMove (){
        System.out.println();
        System.out.println("___-**-___-**-___-**-___-**-___");
        System.out.println("Testing BestOpenMove method");
        GameBoard gbTest = new GameBoard(new char[]{'1', '2', 'X', 'X', '0', '6', '0', '8', 'X'});

        gbTest.display();
        TicTacToeStrategy BestOpenStrat = new TicTacToeStrategy(gbTest) {

            public int getBestMove(){
                return 0;
            }

        };

        Player TestCPU = new ComputerPlayer("Test CPU", 'O', BestOpenStrat);
        System.out.println("Player " + TestCPU.getName());
        System.out.println("Result is ");
        boolean error = false;
        int numberOfRuns = 50;
        do {


            for (int i = 0; i < numberOfRuns; i++) {

                int result = BestOpenStrat.getBestOpenMove();
                if (result < 1 || result > 9) {
                    error = true;
                    System.out.println("Error! This result of " + result + " is out of range, it must be 1-9");
                } else if (gbTest.isSquareOpen(result) == false) {
                    error = true;
                    System.out.println("Error! That spot " + result + " is not open!");
                }
            }
        }while (error);
        System.out.println("No bad output was found in " + numberOfRuns + " tries.");
        System.out.println("___-**-___-**-___-**-___-**-___");
        System.out.println();
    }

    public static void testBlockWinStrategy (){
        System.out.println();
        System.out.println("___-**-___-**-___-**-___-**-___");
        System.out.println("Testing BestOpenMove method");
        GameBoard gbTest = new GameBoard(new char[]{'1', '2', 'X', 'X', '0', '6', '0', '8', 'X'});

        gbTest.display();
        TicTacToeStrategy BlockWinStrat = new TicTacToeStrategy(gbTest) {

            public int getBestMove(){
                return 0;
            }

        };

        Player TestCPU = new ComputerPlayer("Test CPU", 'O', BlockWinStrat);
        System.out.println("Player " + TestCPU.getName());
        System.out.println("Result is ");
        boolean error = false;
        int numberOfRuns = 50;
        do {


            for (int i = 0; i < numberOfRuns; i++) {

                int result = BlockWinStrat.getBlockWin();
                if (result < 1 || result > 9) {
                    error = true;
                    System.out.println("Error! This result of " + result + " is out of range, it must be 1-9");
                } else if (gbTest.isSquareOpen(result) == false) {
                    error = true;
                    System.out.println("Error! That spot " + result + " is not open!");
                }
            }
        }while (error);
        System.out.println("No bad output was found in " + numberOfRuns + " tries.");
        System.out.println("___-**-___-**-___-**-___-**-___");
        System.out.println();
    }



    public abstract int getBestMove();

   // public int blockSpot = 1;
    protected int getBlockWin() {
        char CPU = 'O';

       //char [] chBoard = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int bestMove = 0;

        for (int i = 0; i < winCombinations.length; i ++) {
            int[] win = (winCombinations[i]);


          //  for (int[] win : winCombinations) {
                char spt1 = gb.getSquareValue(win[0]);
                char spt2 = gb.getSquareValue(win[1]);
                char spt3 = gb.getSquareValue(win[2]);
                if (spt1 == spt2 || spt1 == spt3 || spt2 == spt3) {
                    if (spt1 == CPU || spt2 == CPU || spt3 == CPU) {

                        if (spt1 == spt2 && gb.isSquareOpen(spt3)) {
                            bestMove = spt3;
                        } else if (spt2 == spt3 && gb.isSquareOpen(spt1)) {
                            bestMove = spt1;
                        } else if (spt3 == spt1 && gb.isSquareOpen(spt2)) {
                            bestMove = (spt2);
                        } else {
                            bestMove = getBestOpenMove();
                        }
                    }
                }
            }

        return bestMove;
    }

    protected int getRandomMove(){
        Random rand = new Random();
        int[] ranOpenSpot = gb.getOpenSquares();
        int ranMove = rand.nextInt(ranOpenSpot.length);
        return ranOpenSpot[ranMove];
    }

    protected int getBestOpenMove() {
        Random rand = new Random();
        int oSqr;
        int[] possibleMoves = gb.getOpenSquares();
        int[] corners = {1, 3, 7, 9};
        int bestMove;
        ArrayList<Integer> openSquares = new ArrayList<Integer>(9);

        for (oSqr = 1; oSqr < possibleMoves.length; oSqr++){
            openSquares.add(oSqr);

        }
        if (openSquares.contains(5)){
            bestMove = 5;
        }
        else if (openSquares.contains(corners)) {
            int ranCorner = rand.nextInt(corners.length);
            bestMove = corners[ranCorner];
        }
        else {
            int[] ranOpenSpot = gb.getOpenSquares();
            int ranMove = rand.nextInt(ranOpenSpot.length);
            bestMove = ranOpenSpot[ranMove];
        }
        return bestMove;
    }

}
