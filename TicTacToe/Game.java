package com.abhishekVelankar;

import java.util.Scanner;

public class Game {

    private char[][] board = new char[3][3];
    private char winner;

    public Game() {
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void displayEmptyBoard() {
        displayCurrentBoard();
    }

    public void startGame() {

        int row,column;
        boolean flag=false;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Player 1 : X" + "\n" + "Player 2 : O");
        System.out.println("Start the Game ::");

        for (int i=0;i<9;i++) {
            if(i>4) {
                flag = checkResult();

                if(flag) {
                    System.out.print("\nResult : ");

                    if (winner == 'X') {
                        System.out.println("Player 1 WINS !!\n");
                    } else {
                        System.out.println("Player 2 WINS !!\n");
                    }
                    displayCurrentBoard();
                    break;
                }
            }

            System.out.println(" ");
            displayCurrentBoard();

            System.out.println("\n\nPlayer " + (i%2+1) + " : " );
//            char temp = scanner.next().charAt(0);

            System.out.println("Enter the location on the board ( 1 - 9 ) :");
            int loc = scanner.nextInt();

            if(loc<=3) {
                row = 1;
            } else if(loc>3 && loc<=6) {
                row = 2;
            } else {
                row = 3;
            }

            column = loc%3;

            if(column==0) {
                column = 3;
            }
            if (board[row-1][column-1]=='X' || board[row-1][column-1]=='O') {
                i--;
                System.out.println("\nLocation is already filled !");
                System.out.println("Enter again !");

            } else {
                if (i%2==0) {
                    board[row - 1][column - 1] = 'X';
                } else {
                    board[row - 1][column - 1] = 'O';
                }
            }

        }
        if (!flag) {
            System.out.println("\n\nTHE GAME HAS TIED !!\n");
            displayCurrentBoard();
        }
    }

    public void displayCurrentBoard() {

        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                System.out.print(board[i][j] + "\t");
                if (j<2) {
                    System.out.print(" | \t");
                }
            }
            if (i<2) {
                System.out.println("\n____________________");
            }
        }
    }

    private boolean checkResult() {

        for (int i=0;i<3;i++) {
           if (board[i][0]==board[i][1] && board[i][1] == board[i][2] && board[i][1]!=' ') {
               winner = board[i][0];
               return true;
           }
        }
        for (int i=0;i<3;i++) {
            if (board[0][i]==board[1][i] && board[1][i] == board[2][i] && board[i][1]!=' ') {
                winner = board[0][i];
                return true;
            }
        }
        int i=0;
        if (board[i][i]==board[i+1][i+1] && board[i+1][i+1]==board[i+2][i+2] && board[i][1]!=' ') {
            winner = board[0][i];
            return true;
        }

        if (board[i][2]==board[i+1][1] && board[i+1][1]==board[i+2][0] && board[i][2]!=' ') {
            winner = board[i][2];
            return true;
        }
        return false;
    }
}
