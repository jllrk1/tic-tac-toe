package edu.htc.tictactoe;

import java.util.Scanner;

import edu.htc.tictactoe.Player.*;



public class TicTacToe {

  // public GameBoard gb = new GameBoard();
  //public Player pOne = new Player();
  //public Player pTwo = new Player();
  // public int intOpnSpots = 9;
  //public boolean blnExit;
  private Player pOne;
  private Player pTwo;

  private GameBoard gb;
  Scanner scan = new Scanner(System.in);

  //char[] currentBoard = new char[9];

  public TicTacToe() {
    gb = new GameBoard();
  }

  public void playGame() {
    //gb = new GameBoard();
    System.out.println("___-**-___-**-___-**-___-**-___");
    System.out.println("Welcome to Tic-Tac-Toe, lets play a game!");
    Player pOne = new Player("Player 1", 'X');
    System.out.println("Let's start with the first player!");
    System.out.println("Name: " + pOne.getName());
    System.out.println("Cursor: " + pOne.getMarker());
    Player pTwo = new Player("Player 2", 'O');
    System.out.println("Now let's start the second player!");
    System.out.println("Name: " + pTwo.getName());
    System.out.println("Cursor: " + pTwo.getMarker());
    System.out.println("Here is the game board: ");
    //do{

    //while
  //}
    gb.display();
    System.out.println("Player 1, you will be going first ");
    int pMove = pOne.getMove();
    gb.updateSquare(pMove, pOne.getMarker());
    gb.display();
    System.out.println("This is all I have done so far, please check out the gameboard and player classes as they actually work!");

  }
  public static void main(String[] args){
    TicTacToe tic = new TicTacToe();

    tic.playGame();
  }
}






