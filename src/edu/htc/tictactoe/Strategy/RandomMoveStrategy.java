package edu.htc.tictactoe.Strategy;

import edu.htc.tictactoe.GameBoard;
import edu.htc.tictactoe.player.ComputerPlayer;
import edu.htc.tictactoe.player.Player;

/**
 * Created by Joel on 3/13/2016.
 */
public class RandomMoveStrategy extends TicTacToeStrategy {


    public RandomMoveStrategy (GameBoard gb)
    {
        super(gb);
    }
    @Override
    public int getBestMove(){
        return getRandomMove();
    }




}
