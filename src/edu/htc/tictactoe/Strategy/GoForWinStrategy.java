package edu.htc.tictactoe.Strategy;

import edu.htc.tictactoe.GameBoard;

/**
 * Created by Joel on 3/13/2016.
 */
public class GoForWinStrategy extends TicTacToeStrategy {
    public static void main(String[] args) {

    }


    public GoForWinStrategy(GameBoard gb)
    {
        super(gb);
    }
    @Override
    public int getBestMove(){
        return goForWin();
    }

}
