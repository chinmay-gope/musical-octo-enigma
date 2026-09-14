package com.myproject.tictactoe;

import java.util.Scanner;

public class POC2 {

    /*
     * The real board is conceptually infinite.
     *
     * We use a large finite array as a window into that
     * infinite board for this POC.
     *
     * Increase BOARD_SIZE if you want a larger playing area.
     */
    private static final int BOARD_SIZE = 25;

    /*
     * Number of consecutive marks required to win.
     *
     * Try:
     * 3 -> 3 in a row
     * 4 -> 4 in a row
     * 5 -> 5 in a row
     */
    private static final int WIN_LENGTH = 5;

    private static final char EMPTY = '.';

    private static final char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
    /*
     * Directions:
     *
     * horizontal  -> (0, 1)
     * vertical    -> (1, 0)
     * diagonal    -> (1, 1)
     * anti-diag   -> (1, -1)
     */
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {1, 1}, {1, -1}};
    private static char currentPlayer = 'X';
    private static int moves = 0;

    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        initializeBoard();

        printWelcome();

        while (true) {

            printBoard();

            System.out.println("Player " + currentPlayer + "'s turn");

            System.out.print("Enter row: ");
            int row = scanner.nextInt();

            System.out.print("Enter column: ");
            int col = scanner.nextInt();

            /*
             * Invalid move:
             *
             * Do NOT switch player.
             */
            if (!isValidMove(row, col)) {

                System.out.println("Invalid move! Try again.");

                continue;
            }

            /*
             * Make the move.
             */
            board[row][col] = currentPlayer;
            moves++;

            /*
             * Check whether this move created
             * WIN_LENGTH consecutive marks.
             */
            if (hasWon(row, col)) {

                printBoard();

                System.out.println("Player " + currentPlayer + " wins!");

                break;
            }

            /*
             * Fixed array is full.
             *
             * A truly infinite board could never become full.
             */
            if (moves == BOARD_SIZE * BOARD_SIZE) {

                printBoard();

                System.out.println("Board window is full!");

                break;
            }

            /*
             * Valid move only -> switch turn.
             */
            switchPlayer();
        }

        scanner.close();
    }

    // --------------------------------------------------
    // Initialization
    // --------------------------------------------------

    private static void initializeBoard() {

        for (int row = 0; row < BOARD_SIZE; row++) {

            for (int col = 0; col < BOARD_SIZE; col++) {

                board[row][col] = EMPTY;
            }
        }
    }

    // --------------------------------------------------
    // Game
    // --------------------------------------------------

    private static boolean isValidMove(int row, int col) {

        /*
         * Check whether coordinate is inside
         * our finite representation.
         */
        if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE) {

            return false;
        }

        /*
         * Cell must be empty.
         */
        return board[row][col] == EMPTY;
    }

    private static void switchPlayer() {

        currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
    }

    // --------------------------------------------------
    // Win Detection
    // --------------------------------------------------

    private static boolean hasWon(int row, int col) {

        /*
         * A winning line MUST pass through the
         * cell that was just played.
         *
         * Check all four possible directions.
         */
        for (int[] direction : DIRECTIONS) {

            int dr = direction[0];
            int dc = direction[1];

            int count = 1 + countDirection(row, col, dr, dc) + countDirection(row, col, -dr, -dc);

            if (count >= WIN_LENGTH) {
                return true;
            }
        }

        return false;
    }

    private static int countDirection(int row, int col, int dr, int dc) {

        int count = 0;

        int r = row + dr;
        int c = col + dc;

        /*
         * Keep walking in this direction until:
         *
         * 1. We leave the board
         * 2. We find another player's mark
         * 3. We find an empty cell
         */
        while (isInsideBoard(r, c) && board[r][c] == currentPlayer) {

            count++;

            r += dr;
            c += dc;
        }

        return count;
    }

    private static boolean isInsideBoard(int row, int col) {

        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE;
    }

    // --------------------------------------------------
    // Display
    // --------------------------------------------------

    private static void printBoard() {

        System.out.println();

        /*
         * Print column numbers.
         */
        System.out.print("     ");

        for (int col = 0; col < BOARD_SIZE; col++) {

            System.out.printf("%2d ", col);
        }

        System.out.println();

        for (int row = 0; row < BOARD_SIZE; row++) {

            System.out.printf("%3d  ", row);

            for (int col = 0; col < BOARD_SIZE; col++) {

                System.out.print(board[row][col] + "  ");
            }

            System.out.println();
        }

        System.out.println();
    }

    private static void printWelcome() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("       INFINITE TIC TAC TOE");
        System.out.println("======================================");

        System.out.println("Board size : " + BOARD_SIZE + " x " + BOARD_SIZE);

        System.out.println("Win length : " + WIN_LENGTH);

        System.out.println("Players    : X vs O");

        System.out.println();
        System.out.println("Get " + WIN_LENGTH + " consecutive marks");
        System.out.println("horizontally, vertically, or diagonally.");

        System.out.println();
    }
}
