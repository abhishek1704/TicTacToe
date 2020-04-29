package com.abhishekVelankar;

import com.abhishekVelankar.Game;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            Game tictoktoe = new Game();

            System.out.println("\n\n\n\t:: WELCOME to TIC TAC TOE ::");
            System.out.println("\nPress 1 to start.....");

            int temp = scanner.nextInt();

            if(temp == 1) {
                System.out.println("");
                tictoktoe.startGame();
            } else {
                System.out.println("\nYou have pressed a wrong key !");
            }

            System.out.println("\n\nDo you want to play again ? ( Yes : 1, No : 0 )");
            int yesOrno = scanner.nextInt();

            if(yesOrno==0) {
                break;
            }
        }

    }
}
