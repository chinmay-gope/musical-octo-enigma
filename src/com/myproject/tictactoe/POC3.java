package com.myproject.tictactoe;

import com.myproject.tictactoe.exception.InvalidState;

import java.util.Scanner;

public class POC3 {
    static {
        System.out.println("=================================");
        System.out.println("     INFINITE TIC TAC TOE");
        System.out.println("=================================");
        System.out.println();
        System.out.println("Rules:");
        System.out.println("- 3x3 board");
        System.out.println("- Each player can have only 3 pieces");
        System.out.println("- Your 4th piece removes your oldest piece");
        System.out.println("- Get 3 in a row to win");
        System.out.println();
    }

    static void main() {
        Game game = new Game();

        Scanner scanner = new Scanner(System.in);

        while (!game.isGameOver()) {

            game.board().print();

            System.out.println(
                    "Player " + game.currentPlayer() + "'s turn"
            );

            System.out.print("Enter row and column (1-3): ");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            Position position =
                    new Position(row - 1, col - 1);

            try {

                game.play(position);

            } catch (InvalidState e) {

                System.out.println(
                        "Invalid move: " + e.getMessage()
                );
            }
        }

        game.board().print();

        System.out.println(
                "🎉 Player " + game.winner() + " wins!"
        );

        scanner.close();
    }
}
