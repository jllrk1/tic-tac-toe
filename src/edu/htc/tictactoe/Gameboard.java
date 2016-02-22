package edu.htc.tictactoe;

import java.util.ArrayList;


        public class GameBoard {
            private ArrayList<Integer> openSquares;
            private char chBoard[];
            private int[][] winCombinations = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9},{3, 5, 7},{1, 5, 9},{1, 4, 7}, {2, 5, 8}, {3, 6, 9} };


            public GameBoard() {
                int oSqr;
                chBoard = new char[] {'1','2','3','4','5','6','7','8','9'};

                openSquares = new ArrayList<Integer>(9);
                for (oSqr = 1; oSqr < 10; oSqr++) {
                    openSquares.add(oSqr);
                }
            }
            public void display() {

                System.out.println("___________");
                System.out.println(chBoard[1] + " | "+ chBoard[2] + " | " + chBoard[3]+ " |");
                System.out.println("---|---|---");
                System.out.println(chBoard[4] + " | "+ chBoard[5] + " | " + chBoard[6]+ " |");
                System.out.println("---|---|---");
                System.out.println(chBoard[7] + " | "+ chBoard[8] + " | " + chBoard[9]+ " |");
                System.out.println("---|---|---");
                System.out.println("___________");
            }

            public static void main(String[] args) {
                GameBoard gb = new GameBoard();


            }



         public char isGameWon() {

                char Winner = '';


             // Check if X wins
             if (chBoard[1] == 'X' && chBoard[2] == 'X' && chBoard[3] == 'X') Winner = 'X';
             if (chBoard[4] == 'X' && chBoard[5] == 'X' && chBoard[6] == 'X') Winner = 'X';
             if (chBoard[7] == 'X' && chBoard[8] == 'X' && chBoard[9] == 'X') Winner = 'X';
             if (chBoard[1] == 'X' && chBoard[4] == 'X' && chBoard[7] == 'X') Winner = 'X';
             if (chBoard[2] == 'X' && chBoard[5] == 'X' && chBoard[8] == 'X') Winner = 'X';
             if (chBoard[3] == 'X' && chBoard[6] == 'X' && chBoard[9] == 'X') Winner = 'X';
             if (chBoard[1] == 'X' && chBoard[5] == 'X' && chBoard[9] == 'X') Winner = 'X';
             if (chBoard[3] == 'X' && chBoard[5] == 'X' && chBoard[7] == 'X') Winner = 'X';
             if (Winner == 'X' )
             {System.out.println("Player1 wins the game." );
                 return Winner;
             }

             // Check if O wins
             if (chBoard[1] == 'O' && chBoard[2] == 'O' && chBoard[3] == 'O') Winner = 'O';
             if (chBoard[4] == 'O' && chBoard[5] == 'O' && chBoard[6] == 'O') Winner = 'O';
             if (chBoard[7] == 'O' && chBoard[8] == 'O' && chBoard[9] == 'O') Winner = 'O';
             if (chBoard[1] == 'O' && chBoard[4] == 'O' && chBoard[7] == 'O') Winner = 'O';
             if (chBoard[2] == 'O' && chBoard[5] == 'O' && chBoard[8] == 'O') Winner = 'O';
             if (chBoard[3] == 'O' && chBoard[6] == 'O' && chBoard[9] == 'O') Winner = 'O';
             if (chBoard[1] == 'O' && chBoard[5] == 'O' && chBoard[9] == 'O') Winner = 'O';
             if (chBoard[3] == 'O' && chBoard[5] == 'O' && chBoard[7] == 'O') Winner = 'O';
             if (Winner == 'O' )
             {
                 System.out.println( "Player2 wins the game." );
                 return Winner; }

             // check for Tie
             for(int i=1;i<10;i++)
             {
                 if(chBoard[i]=='X' || chBoard[i]=='O')
                 {
                     if(i==9)
                     {
                         char Draw = 'D';
                         System.out.println(" Stalemate folks! ");
                         return Draw;
                     }
                     continue;
                 }
                 else
                     break;

             }

             return Winner;
         }



    }