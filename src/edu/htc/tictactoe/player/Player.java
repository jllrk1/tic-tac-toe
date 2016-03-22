package edu.htc.tictactoe.player;

import edu.htc.tictactoe.TicTacToe;
import java.util.Scanner;


public abstract class Player {
    private int winCount = 0;
    private String pName;
    private char pMarker;




    public Player(String nam, char cur){
        this.pName = nam;
        this.pMarker = cur;

    }

    public int getWinCount() {
        return winCount;
    }

    public void addWin() {
        this.winCount += 1;
    }


    public String getName() {
        return pName;
    }

    public void setName(String nam){pName = nam;}

    public char getMarker() {
        return pMarker;
    }

    public void setpMarker(char cur){pMarker = cur;}

    public abstract int getMove();
}
