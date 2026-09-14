package com.myproject.tictactoe;

import java.util.Scanner;

public class POC0 {

    static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    static char currentPlayer = 'X';

    static void main() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== TIC TAC TOE =====");

        while (true) {

            printBoard();

            System.out.println("Player " + currentPlayer + "'s turn");

            System.out.print("Enter row (1-3): ");
            int row = scanner.nextInt() - 1;

            System.out.print("Enter column (1-3): ");
            int col = scanner.nextInt() - 1;

            // Validate position
            if (!isValidPosition(row, col)) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            // Make move
            board[row][col] = currentPlayer;

            // Check winner
            if (hasWon()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            // Check draw
            if (isDraw()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }

            // Switch player
            switchPlayer();
        }

        scanner.close();
    }

    private static void printBoard() {

        System.out.println();
        System.out.println("     1   2   3");
        System.out.println("   -------------");

        for (int i = 0; i < 3; i++) {

            System.out.print((i + 1) + "  ");

            for (int j = 0; j < 3; j++) {

                System.out.print(" " + board[i][j] + " ");

                if (j < 2) {
                    System.out.print("|");
                }
            }

            System.out.println();

            if (i < 2) {
                System.out.println("   -------------");
            }
        }

        System.out.println();
    }

    private static boolean isValidPosition(int row, int col) {

        // Check boundaries
        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            return false;
        }

        // Check whether position is already occupied
        return board[row][col] == ' ';
    }

    private static boolean hasWon() {

        // Rows
        for (int row = 0; row < 3; row++) {

            if (board[row][0] == currentPlayer &&
                    board[row][1] == currentPlayer &&
                    board[row][2] == currentPlayer) {

                return true;
            }
        }

        // Columns
        for (int col = 0; col < 3; col++) {

            if (board[0][col] == currentPlayer &&
                    board[1][col] == currentPlayer &&
                    board[2][col] == currentPlayer) {

                return true;
            }
        }

        // Main diagonal
        if (board[0][0] == currentPlayer &&
                board[1][1] == currentPlayer &&
                board[2][2] == currentPlayer) {

            return true;
        }

        // Other diagonal
        return board[0][2] == currentPlayer &&
                board[1][1] == currentPlayer &&
                board[2][0] == currentPlayer;
    }

    private static boolean isDraw() {

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }

    private static void switchPlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }
}
