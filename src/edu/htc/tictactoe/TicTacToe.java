package edu.htc.tictactoe;

import java.util.Scanner;

//import edu.htc.tictactoe.Player.*;



public class TicTacToe {
  // public GameBoard gb = new GameBoard();
  //public Player pOne = new Player();
  //public Player pTwo = new Player();
  // public int intOpnSpots = 9;
  //public boolean blnExit;
  Player pOne;
  Player pTwo;

  GameBoard game;
  Scanner scan = new Scanner(System.in);

  char[] currentBoard = new char[9];

  public TicTacToe() {
    game = new GameBoard();
  }
//  public TicTacToe(Player pOne, Player pTwo)
  //{
  //  this.pOne = pOne;
  //   this.pTwo = pTwo;
  // }

  public void playGame() {
    int x = 0;
    int p1Move = 0;
    boolean Openspace = false, rndComplete = false;
    int gameCounter = 0;
    int nDraws = 0;
    boolean blnGameWon;
    int nMove;

    //GameBoard gb = new GameBoard();
    System.out.println("Welcome to Tic-Tac-Toe, lets play a game!");
    System.out.print("Player 1: ");
    String pName1 = scan.next();
    char gMark1 = 'X';
    pOne = new Player(pName1, gMark1);

    System.out.println("Player 2: ");
    String pName2 = scan.next();
    char gMark2 = '0';
    pTwo = new Player(pName2, gMark2);

    // if (pOne == null) {
    //   pOne =

    //    game = new GameBoard();
    //   }

  }
}






