package edu.htc.tictactoe.player;
import edu.htc.tictactoe.*;
import edu.htc.tictactoe.Strategy.*;

/**
 * Created by Joel on 3/13/2016.
 */
public class ComputerPlayer extends Player {
    TicTacToeStrategy CPUstrategy;

    public ComputerPlayer(String nam, char cur, TicTacToeStrategy strategy){
        super(nam, cur);
        this.CPUstrategy = strategy;

    }

    public void setStrategy(TicTacToeStrategy strategy) {
        this.CPUstrategy = strategy;
    }
    public  int getMove()   {
        return CPUstrategy.getBestMove();
    }
    public static void main(String args[]) {

                        GameBoard gbTest = new GameBoard();
               TicTacToe ticTest = new TicTacToe();
                ComputerPlayer CPU = new ComputerPlayer("cpu", 'O', new RandomMoveStrategy(gbTest));
           // ticTest.playGame();

                        System.out.println("Strategy: ");
                System.out.println(CPU.CPUstrategy.getBestMove());
                System.out.println();

                        System.out.println("Next Move");
                System.out.println(CPU.getMove());
            }
}
