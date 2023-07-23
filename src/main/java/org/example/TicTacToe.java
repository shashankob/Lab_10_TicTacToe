package org.example;

import org.example.SafeInput;

import java.util.Scanner;

public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String gameBoard[][] = new String[ROW][COL];
    private static String currentPlayer = "X";
    private static Scanner scanner = new Scanner(System.in);

    private static void clearBoard() {
        for (int iGame = 0; iGame < ROW; iGame++) {
            for (int jGame = 0; jGame < COL; jGame++) {
                gameBoard[iGame][jGame] = " ";
            }
        }
    }

    private static void display() {
        for (int iGame = 0; iGame < ROW; iGame++) {
            for (int jGame = 0; jGame < COL; jGame++) {
                System.out.print(gameBoard[iGame][jGame] + " | ");
            }
            System.out.println();
            System.out.println("---------");
        }
    }

    private static boolean isValidMove(int row, int col) {
        if (row < 0 || row >= ROW || col < 0 || col >= COL) {
            return false;
        }
        return gameBoard[row][col].equals(" ");
    }

    private static boolean checkWin(String player) {
        for (int iGame = 0; iGame < ROW; iGame++) {
            if (gameBoard[iGame][0].equals(player) && gameBoard[iGame][1].equals(player) && gameBoard[iGame][2].equals(player) ||
                    gameBoard[0][iGame].equals(player) && gameBoard[1][iGame].equals(player) && gameBoard[2][iGame].equals(player)) {
                return true;
            }
        }
        return (gameBoard[0][0].equals(player) && gameBoard[1][1].equals(player) && gameBoard[2][2].equals(player)) ||
                (gameBoard[0][2].equals(player) && gameBoard[1][1].equals(player) && gameBoard[2][0].equals(player));
    }

    private static boolean isTie() {
        for (int iGame = 0; iGame < ROW; iGame++) {
            for (int jGame = 0; jGame < COL; jGame++) {
                if (gameBoard[iGame][jGame].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean playAgain = true;
        Scanner in = new Scanner(System.in);

        while (playAgain) {
            clearBoard();
            currentPlayer = "X";

            while (true) {
                display();
                System.out.println("Player " + currentPlayer + ", enter row (1-3) and column (1-3): ");
                int rowMove = SafeInput.getRangedInt(in, "", 1, 3) - 1;
                int colMove = SafeInput.getRangedInt(in, "", 1, 3) - 1;

                if (isValidMove(rowMove, colMove)) {
                    gameBoard[rowMove][colMove] = currentPlayer;

                    if (checkWin(currentPlayer)) {
                        display();
                        System.out.println("Player " + currentPlayer + " wins!");
                        break;
                    }

                    if (isTie()) {
                        display();
                        System.out.println("It's a tie!");
                        break;
                    }

                    currentPlayer = currentPlayer.equals("X") ? "O" : "X";
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }

            System.out.println("Do you want to play again? (y/n): ");
            String choice = scanner.next();
            playAgain = choice.equalsIgnoreCase("y");
        }

        scanner.close();
    }
}
