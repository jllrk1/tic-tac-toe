package edu.htc.tictactoe.Strategy;

import edu.htc.tictactoe.GameBoard;

/**
 * Created by Joel on 3/13/2016.
 */
public class BlockWinStrategy extends TicTacToeStrategy {

    public BlockWinStrategy (GameBoard gb) {
        super(gb);
    }

    @Override
    public int getBestMove() {
        return getBlockWin();
    }

}

