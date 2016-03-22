package edu.htc.tictactoe.Strategy;
import edu.htc.tictactoe.GameBoard;
import edu.htc.tictactoe.player.ComputerPlayer;
import edu.htc.tictactoe.player.Player;

import java.util.Random;

/**
 * Created by Joel on 3/13/2016.
 */
public abstract class BestOpenMoveStrategy extends TicTacToeStrategy {

    public static void main(String[] args) {

    }


    public BestOpenMoveStrategy(GameBoard gb)
    {
        super(gb);
    }
   @Override
    public int getBestMove(){
        return getBestOpenMove();
    }
    public int getBestOpenMove()
    {
        return getBestOpenMove();
    }



}
