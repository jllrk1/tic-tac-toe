package edu.htc.tictactoe;

import java.util.Scanner;



public class TicTacToe {

  private Player pOne;
  private Player pTwo;
  private boolean pOneActive;
  private boolean pTwoActive;
  private boolean gTie;
 // private boolean endGame;
  private String Again;

  private GameBoard gb;
  private Scanner scan = new Scanner(System.in);



  public TicTacToe() {
    this.gb = new GameBoard();
  }


  public void playGame() {

    System.out.println("___-**-___-**-___-**-___-**-___");
    System.out.println("Welcome to Tic-Tac-Toe, lets play a game!");
    pOne = new Player("Player 1", 'X');
    System.out.println("Let's start with the first player!");
    System.out.println("Name: " + pOne.getName());
    System.out.println("Cursor: " + pOne.getMarker());
    pTwo = new Player("Player 2", 'O');
    System.out.println("Now the second player!");
    System.out.println("Name: " + pTwo.getName());
    System.out.println("Cursor: " + pTwo.getMarker());
    do {


      System.out.println("Player 1, you will be going first ");
      System.out.println("Here is the game board: ");
      gb.display();
      System.out.println("___-**-___-**-___-**-___-**-___");
      gTie = false;
      do {
        pOneActive = true;
        pTwoActive = false;
        //gTie = false;
        while (pOneActive && !pTwoActive) //This is player 1's move
        {
          System.out.println("___-**-___-**-___-**-___-**-___");
          System.out.println(pOne.getName() + " it is your turn");
          int pMove = pOne.getMove();
          if (!gb.isSquareOpen(pMove)) {
            System.out.println("Oops, that spot is already taken, here are the available spots: ");
            int Osqr[] = gb.getOpenSquares();
            // int Open = Osqr.length;
            for (int i = 0; i < Osqr.length; i++) {
              System.out.println(Osqr[i]);
            }
            pMove = pOne.getMove();
          }
          System.out.println("You have chosen " + pMove);
          gb.updateSquare(pMove, pOne.getMarker());
          gb.display();
          if (gb.isGameWon()) {
            pOneActive = true;
            pTwoActive = false;
            //  gTie = false;
            break;
          } else if (!gb.isGameWon()) {
            int CheckDraw[] = gb.getOpenSquares();
            int Open = CheckDraw.length;
            if (Open < 1) {
              System.out.println("Looks like the game is a tie! ");
              gTie = true;
              pTwoActive = false;
              pOneActive = false;
              break;
            } else {
              pTwoActive = true;
              pOneActive = false;
            }

            System.out.println("___-**-___-**-___-**-___-**-___");
          }
          System.out.println("___-**-___-**-___-**-___-**-___");
        }
        while (pTwoActive && !pOneActive) //This is player 2's move
        {
          System.out.println("___-**-___-**-___-**-___-**-___");
          System.out.println(pTwo.getName() + " it is your turn");
          int pMove = pTwo.getMove();
          if (!gb.isSquareOpen(pMove)) {
            System.out.println("Oops, that spot is already taken, here are the available spots: ");
            int Osqr[] = gb.getOpenSquares();
            for (int i = 0; i < Osqr.length; i++) {
              System.out.println(Osqr[i]);
            }
            pMove = pTwo.getMove();
          }
          System.out.println("You have chosen " + pMove);
          gb.updateSquare(pMove, pTwo.getMarker());
          gb.display();
          if (gb.isGameWon()) {
            pOneActive = false;
            pTwoActive = true;
            break;
          } else if (!gb.isGameWon()) {
            int CheckDraw[] = gb.getOpenSquares();
            int Open = CheckDraw.length;
            if (Open < 1) {
              System.out.println("Looks like the game is a tie! ");
              gTie = true;
              pTwoActive = false;
              pOneActive = false;
              break;
            } else {
              pTwoActive = false;
              pOneActive = true;
            }
            System.out.println("___-**-___-**-___-**-___-**-___");
          }
          
          System.out.println("___-**-___-**-___-**-___-**-___");

        }

        if (gTie) {
          break;
        }
      } while (gb.isGameWon() == false);
      if (pOneActive && !pTwoActive) {

        System.out.println("Game over " + pOne.getName() + " is the winner");
        pOne.addWin();
        //pOne.getWinCount();
        System.out.println(pOne.getName() + " has " + pOne.getWinCount() + "win(s)");
      } else if (!pOneActive && pTwoActive) {
        System.out.println("Game over " + pTwo.getName() + " is the winner");
        pTwo.addWin();
        System.out.println(pTwo.getName() + " has " + pTwo.getWinCount() + " win(s)");
      } else if (!pOneActive && !pTwoActive) {
        System.out.println("The game is a draw");
      }
      System.out.println("Another Game? Please choose Yes, or No ");
      Again = scan.next();
      gb.reset();
    }
      while (Again.equalsIgnoreCase("yes"));

    System.out.println("Game over, the final win counts are" + pOne.getName() + " has " + pOne.getWinCount() + " win(s) " + pTwo.getName() + " has" + pTwo.getWinCount() + " play again soon!");

  }


  public static void main(String[] args) {
    TicTacToe tic = new TicTacToe();
    tic.playGame();
    //do{
    //   tic.playGame();
    // }while (!isgameWon());{

    //  }

  }
}









