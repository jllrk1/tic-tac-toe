package edu.htc.tictactoe;

import edu.htc.tictactoe.Strategy.*;
import edu.htc.tictactoe.player.ComputerPlayer;
import edu.htc.tictactoe.player.HumanPlayer;
import edu.htc.tictactoe.player.Player;

import java.util.Scanner;



public class TicTacToe {

  private Player pOne;
  private Player pTwo;
  private Player pCPU;
  private boolean pOneActive;
  private boolean pTwoActive;
  private boolean pCPUActive;
  private boolean gTie;
  private boolean singlePlay;
  private boolean bError;
  private boolean gFrstErr;
  private boolean stratSet;
  private String Again;
  private String goFirst;
  private GameBoard gb;
  private int plyrQty;
  private int cpuLevel;
  private Scanner scan = new Scanner(System.in);


  //RandomMoveStrategy ranMoveStrat = new RandomMoveStrategy(gb);

  TicTacToeStrategy strategy = new TicTacToeStrategy(gb) {
    @Override
    public int getBestMove() {
      return 0;
    }
  };

  public TicTacToe() {
    this.gb = new GameBoard();
  }


  public void playGame() {
    bError = false;
    System.out.println("___-**-___-**-___-**-___-**-___");
    System.out.println("Welcome to Tic-Tac-Toe, lets play a game!");
    System.out.println("___-**-___-**-___-**-___-**-___");
    onePlyr(); //Ask if one player or two player.


///////////////////////////////////////////////below is for 2 player (2 humans)
    if (singlePlay == false) {
      boolean valNam = false;
      String inputName;
      System.out.println("You have chosen a 2 player game, player 1 will always go first, and by default has the X marker");
      do {

        System.out.println("Player 1, choose your name! ");
        inputName = scan.next();
        if (inputName.length() <= 2){
          System.out.println("The name you entered was to short, it needs to be at least 2 characters long");
          System.out.println("Try again! ");

        } else {
          valNam = true;
        }
      }while (!valNam);
      System.out.println("___-**-___-**-___-**-___-**-___");
      pOne = new HumanPlayer(inputName, 'X');
      System.out.println("Now for Player 2");
      valNam = false;
      System.out.println("Player 2 will always go second, and by default has the O marker");
      System.out.println("___-**-___-**-___-**-___-**-___");
      do {
        System.out.println("Player 2, choose your name! ");
        inputName = scan.next();
        if (inputName.length() <= 2){
          System.out.println("The name you entered was to short, it needs to be at least 2 characters long");
          System.out.println("Try again! ");
        } else {
          valNam = true;
        }
      }while (!valNam);
      System.out.println("___-**-___-**-___-**-___-**-___");
      pTwo = new HumanPlayer(inputName, 'O');

      System.out.println("Let's start with the first player!");
      System.out.println("Name: " + pOne.getName());
      System.out.println("Cursor: " + pOne.getMarker());
      System.out.println("___-**-___-**-___-**-___-**-___");
      System.out.println("Now the second player!");
      System.out.println("Name: " + pTwo.getName());
      System.out.println("Cursor: " + pTwo.getMarker());
      System.out.println("___-**-___-**-___-**-___-**-___");

      do {


        System.out.println("Player 1, " +  pOne.getName() + "you will be going first ");
        System.out.println("Here is the game board: ");
        gb.display();
        System.out.println("___-**-___-**-___-**-___-**-___");
        gTie = false;
        do {
          pOneActive = true;
          pTwoActive = false;
          while (pOneActive && !pTwoActive) /////////////This is player 1's move
          {
            System.out.println("___-**-___-**-___-**-___-**-___");
            System.out.println(pOne.getName() + " it is your turn");
            int pMove = pOne.getMove();
            if (!gb.isSquareOpen(pMove)) {
              System.out.println("Oops, that spot is already taken, here are the available spots: ");
              int Osqr[] = gb.getOpenSquares();
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
          while (pTwoActive && !pOneActive) ////////////////This is player 2's move
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

    } else { //////////////////////1 player game with CPU
      System.out.println("___-**-___-**-___-**-___-**-___");
      do {
        boolean valNam = false;
        System.out.println("You have chosen a 1 player game, and by default you are player 1, and have the X marker ");
        String inputName;
        do {

          System.out.println("Player 1, choose your name! ");
          inputName = scan.next();
          if (inputName.length() <= 2){
            System.out.println("The name you entered was to short, it needs to be at least 2 characters long");
            System.out.println("Try again! ");
          } else {
            valNam = true;
          }
        }while (!valNam);
            System.out.println("___-**-___-**-___-**-___-**-___");
            pOne = new HumanPlayer(inputName, 'X');
            gTie = false;
        do {
          System.out.println(pOne.getName() + " would you like to go first? ");
          goFirst = scan.next();
          if (goFirst.equalsIgnoreCase("yes")) {
            pCPUActive = false;

          } else if (goFirst.equalsIgnoreCase("no")) {
            pCPUActive = true;
          } else {
            gFrstErr = true;
            System.out.println("Error occurred, please choose either yes or no");
          }

        } while (gFrstErr);
        do {
          pOne = new HumanPlayer("Player 1", 'X');
          System.out.println("Let's start with you, the player");
          System.out.println("___-**-___-**-___-**-___-**-___");
          System.out.println("Name: " + pOne.getName());
          System.out.println("Cursor: " + pOne.getMarker());
          System.out.println("Now the Computer Player!");
          System.out.println("How good would you like the Computer Player to be? ");
          System.out.println("___-**-___-**-___-**-___-**-___");
          cpuDifficulty(); //this method will ask the player how difficult they want it to be, and it will return which strategy the CPU should use.
          setStrategy();
          stratSet = true;
          System.out.println("___-**-___-**-___-**-___-**-___");
          System.out.println("Let's start the game! ");
          System.out.println("___-**-___-**-___-**-___-**-___");
        } while (!stratSet);
          do {

          System.out.println("___-**-___-**-___-**-___-**-___");
          System.out.println("Name: " + pCPU.getName());
          System.out.println("Cursor: " + pCPU.getMarker());
          System.out.println("___-**-___-**-___-**-___-**-___");
          System.out.println("Here is the game board: ");
          gb.display();
          System.out.println("___-**-___-**-___-**-___-**-___");
          while (!pCPUActive) ////////////////////this is the player's move
          {
            System.out.println("___-**-___-**-___-**-___-**-___");
            System.out.println(pOne.getName() + " it is your turn");
            int pMove = pOne.getMove();
            if (!gb.isSquareOpen(pMove)) {
              System.out.println("Oops, that spot is already taken, here are the available spots: ");
              int Osqr[] = gb.getOpenSquares();
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
              pCPUActive = false;
              break;
            } else if (!gb.isGameWon()) {
              int CheckDraw[] = gb.getOpenSquares();
              int Open = CheckDraw.length;
              if (Open < 1) {
                System.out.println("Looks like the game is a tie! ");
                gTie = true;
                pCPUActive = false;
                pOneActive = false;
                break;
              } else {
                pCPUActive = true;
                pOneActive = false;
              }

              System.out.println("___-**-___-**-___-**-___-**-___");
            }
            System.out.println("___-**-___-**-___-**-___-**-___");
          }
          while (pCPUActive) // this is the computers move
          {
            System.out.println("___-**-___-**-___-**-___-**-___");
            System.out.println(pCPU.getName() + " it is your turn");
            int pMove = pCPU.getMove();
            if (!gb.isSquareOpen(pMove)) {
              System.out.println("Oops, that spot is already taken, here are the available spots: ");
              int Osqr[] = gb.getOpenSquares();
              // int Open = Osqr.length;
              for (int i = 0; i < Osqr.length; i++) {
                System.out.println(Osqr[i]);
              }
              pMove = pCPU.getMove();
            }
            System.out.println("You have chosen " + pMove);
            gb.updateSquare(pMove, pCPU.getMarker());
            gb.display();
            if (gb.isGameWon()) {
              pOneActive = false;
              pCPUActive = true;
              break;
            } else if (!gb.isGameWon()) {
              int CheckDraw[] = gb.getOpenSquares();
              int Open = CheckDraw.length;
              if (Open < 1) {
                System.out.println("Looks like the game is a tie! ");
                gTie = true;
                pCPUActive = false;
                pOneActive = false;
                break;
              } else {
                pCPUActive = false;
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

        if (pOneActive && !pCPUActive) {

          System.out.println("Game over " + pOne.getName() + " is the winner");
          pOne.addWin();
          System.out.println(pOne.getName() + " has " + pOne.getWinCount() + " win(s)");
        } else if (!pOneActive && pCPUActive) {
          System.out.println("Game over " + pCPU.getName() + " is the winner");
          pCPU.addWin();
          System.out.println(pCPU.getName() + " has " + pCPU.getWinCount() + " win(s)");
        } else if (!pOneActive && !pCPUActive) {
          System.out.println("The game is a draw");
        }
        System.out.println("Another Game? Please choose Yes, or No ");
        Again = scan.next();
        gb.reset();
      }

      while (Again.equalsIgnoreCase("yes"));
      System.out.println("Game over, the final win counts are" + pOne.getName() + " has " + pOne.getWinCount() + " win(s) " + pCPU.getName() + " has" + pCPU.getWinCount() + " play again soon!");
    }

  }



  public int cpuDifficulty(){
    //bError = true;
    do {

      System.out.println("There are 4 different difficulty modes");
      System.out.println("Level 1 is the easiest, up through level 4, which is the most difficult");
      //use scan to ask player which level, use that to return the difficulty level, then use that to set a strategy to the CPU.
      int uInput = scan.nextInt();
      if (uInput == 1) {
        System.out.println("You have chosen level 1");
        cpuLevel = 1;
        bError = false;
      } else if (uInput == 2) {
        System.out.println("You have chosen level 2");
        cpuLevel = 2;
        bError = false;
      } else if (uInput == 3) {
        System.out.println("You have chosen level 3");
        cpuLevel = 3;
        bError = false;
      } else if (uInput == 4) {
        System.out.println("You have chosen level 4");
        cpuLevel = 4;
        bError = false;
      } else {
        System.out.println("Random Error occurred, level not selected");
        bError = true;
      }

    } while (bError);
    return cpuLevel;
  }

  private void setStrategy() {
    if (cpuLevel == 1) {
       pCPU = new ComputerPlayer("CPU", 'O', new RandomMoveStrategy(gb));
    } else if (cpuLevel == 2) {
      pCPU = new ComputerPlayer("CPU", 'O', new BestOpenMoveStrategy(gb) {
        @Override
        public int getBestMove() {
          return super.getBestMove();
        }
      });

    } else if (cpuLevel == 3) {
      pCPU = new ComputerPlayer("CPU", 'O', new BlockWinStrategy(gb));
    } else if (cpuLevel == 4) {
      pCPU = new ComputerPlayer("CPU", 'O', new GoForWinStrategy(gb));
    }
  }

  //public void setStrategy(TicTacToeStrategy strategy) {
 //   this.strategy = strategy;
 // }
  // public ComputerPlayer(String name, char cur, GameBoard gb, int gameLevel) {
  //          super(name, 'O');
   //         if (gameLevel == 4){
    //              ticTacToeStrategy = new GoForWinStrategy(gb, cur);
    //          }
      //      else if (gameLevel == 3){
      //            ticTacToeStrategy = new BlockWinStrategy(gb, );
      //        }
        //    else if (gameLevel == 2){
        //          ticTacToeStrategy = new BestOpenMoveStrategy(board, gameMarker, playerMarker);
       //       }
        //    else {
        //          ticTacToeStrategy = new RandomMoveStrategy(board, gameMarker, playerMarker);
        //      }
//  }

  private void onePlyr() {

      System.out.println("Would you like to play against the CPU, or with 2 players? ");
      System.out.println("Please enter 1 to play the CPU, or 2 to have a two player game!");
      plyrQty = scan.nextInt();
      if (plyrQty == 1) {
        singlePlay = true;
      } else if (plyrQty == 2) {
        singlePlay = false;
      } else {
        System.out.println("Error, please enter either 1, or 2 ");
        bError = true;
      }
    while (bError);
  }


  public static void main(String[] args) {
    TicTacToe tic = new TicTacToe();
    tic.playGame();

  }
}









