package com.myproject.tictactoe;

import java.util.Scanner;

public class POC1 {

    private static final int SIZE = 3;
    private static final char EMPTY = ' ';

    private static final char[][] board = {
            {EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY}
    };

    private static char currentPlayer = 'X';
    private static int moves = 0;

    static void main() {

        Scanner scanner = new Scanner(System.in);

        printWelcome();

        while (true) {

            printBoard();

            int row = readCoordinate(scanner, "row");
            int col = readCoordinate(scanner, "column");

            // Invalid move; same player gets another turn
            if (!isValidMove(row, col)) {
                System.out.println("❌ Invalid move! Try again.");
                continue;
            }

            // Make the move
            board[row][col] = currentPlayer;
            moves++;

            // Check winner using the latest move
            if (hasWon(row, col)) {
                printBoard();
                System.out.println("🎉 Player " + currentPlayer + " wins!");
                break;
            }

            // Check draw
            if (moves == SIZE * SIZE) {
                printBoard();
                System.out.println("🤝 It's a draw!");
                break;
            }

            // Valid move; switch turn
            switchPlayer();
        }

        scanner.close();
    }

    // --------------------------------------------------
    // Game Setup
    // --------------------------------------------------

    private static void printWelcome() {

        System.out.println();
        System.out.println("╔══════════════════════╗");
        System.out.println("║     TIC TAC TOE      ║");
        System.out.println("╚══════════════════════╝");
        System.out.println("Player X goes first.");
    }

    // --------------------------------------------------
    // Board
    // --------------------------------------------------

    private static void printBoard() {

        System.out.println();
        System.out.println("       1   2   3");
        System.out.println("     ─────────────");

        for (int row = 0; row < SIZE; row++) {

            System.out.print("  " + (row + 1) + "  ");

            for (int col = 0; col < SIZE; col++) {

                System.out.print(" " + board[row][col] + " ");

                if (col < SIZE - 1) {
                    System.out.print("│");
                }
            }

            System.out.println();

            if (row < SIZE - 1) {
                System.out.println("     ───┼───┼───");
            }
        }

        System.out.println();
    }

    // --------------------------------------------------
    // Input
    // --------------------------------------------------

    private static int readCoordinate(Scanner scanner, String name) {

        while (true) {

            System.out.print(
                    "Player " + currentPlayer +
                            " - Enter " + name + " (1-3): "
            );

            if (scanner.hasNextInt()) {

                int value = scanner.nextInt();

                if (value >= 1 && value <= SIZE) {
                    return value - 1;
                }
            } else {
                scanner.next(); // Remove invalid input
            }

            System.out.println("❌ Please enter a number between 1 and 3.");
        }
    }

    private static boolean isValidMove(int row, int col) {

        return board[row][col] == EMPTY;
    }

    // --------------------------------------------------
    // Win Detection
    // --------------------------------------------------

    private static boolean hasWon(int row, int col) {

        return hasWinningRow(row)
                || hasWinningColumn(col)
                || hasWinningDiagonal(row, col);
    }

    private static boolean hasWinningRow(int row) {

        return board[row][0] == currentPlayer
                && board[row][1] == currentPlayer
                && board[row][2] == currentPlayer;
    }

    private static boolean hasWinningColumn(int col) {

        return board[0][col] == currentPlayer
                && board[1][col] == currentPlayer
                && board[2][col] == currentPlayer;
    }

    private static boolean hasWinningDiagonal(int row, int col) {

        // Main diagonal
        if (row == col) {

            if (board[0][0] == currentPlayer
                    && board[1][1] == currentPlayer
                    && board[2][2] == currentPlayer) {

                return true;
            }
        }

        // Anti-diagonal
        if (row + col == SIZE - 1) {

            return board[0][2] == currentPlayer
                    && board[1][1] == currentPlayer
                    && board[2][0] == currentPlayer;
        }

        return false;
    }

    // --------------------------------------------------
    // Player
    // --------------------------------------------------

    private static void switchPlayer() {

        currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
    }
}
