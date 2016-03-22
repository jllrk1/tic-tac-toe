package edu.htc.tictactoe.player;

import java.util.Scanner;

/**
 * Created by Joel on 3/13/2016.
 */
public class HumanPlayer extends Player {

    public HumanPlayer(String nam, char cur)
    {
        super (nam, cur);
    }

    public static void main(String[] args) {
        System.out.println("Player 1 is named, and set to X as it's marker");
        Player pOne = new HumanPlayer("Player 1", 'X');
        System.out.println("Player 1 name should be Player 1 ");
        System.out.println("Name: " + pOne.getName());
        System.out.println("Test to see if Player 1 cursor is ");
        System.out.println("Cursor: " + pOne.getMarker());
        System.out.println(pOne.getMove() + " Was entered by user");
        System.out.println("Test win count for player 1");
        pOne.addWin();
        System.out.println(" one win was added to player 1");
        System.out.println(pOne.getWinCount() + " is the win count for player 1");

        System.out.println("End test for player 1");
        System.out.println("Begin test for player 2");
        System.out.println("Player 2 is named, and set to O as it's marker");
        Player pTwo = new HumanPlayer("Player 2", 'O');
        System.out.println("Player 2 name should be Player 2 ");
        System.out.println("Name: " + pTwo.getName());
        System.out.println("Test to see if Player 2 cursor is ");
        System.out.println("Cursor: " + pTwo.getMarker());
        System.out.println(pTwo.getMove() + " Was entered by user");
        System.out.println("Test win count for player 2");
        pTwo.addWin();
        System.out.println(" one win was added to player 1");
        System.out.println(pTwo.getWinCount() + " is the win count for player 2");
        System.out.println("End test for player 2");
    }


    public int getMove() {
        String playerInput;
        int playerOutput;
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a value 1 - 9");
            playerInput = scan.next();
            playerOutput = Integer.parseInt(playerInput);


            if (playerOutput >= 1 && playerOutput <= 9) {

                return playerOutput;

            } else {
                System.out.println("Not a number");
            }

        }

    }
}
