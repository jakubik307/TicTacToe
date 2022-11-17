package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void getUserMove(char[] board, boolean playerXTurn) {
        Scanner scanner = new Scanner(System.in);
        boolean error;

        do {
            try {
                error = false;

                int x = scanner.nextInt();
                int y = scanner.nextInt();

                int index = ((x - 1) * 3) + y - 1;

                if (x < 1 || x > 3 || y < 1 || y > 3) {
                    System.out.println("Coordinates should be from 1 to 3");
                    error = true;
                } else if (board[index] == 'O' || board[index] == 'X') {
                    System.out.println("This cell is occupied! Choose another one!");
                    error = true;
                } else if (playerXTurn){
                    board[index] = 'X';
                } else {
                    board[index] = 'O';
                }
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                error = true;
            }
        } while (error);

        printBoard(board);
    }

    public static boolean checkGameState(char[] board) {
        int x = 0;
        int o = 0;
        int empty = 0;
        boolean xWin = false;
        boolean oWin = false;

        for (char c : board) {
            if (c == 'X') {
                x++;
            } else if (c == 'O') {
                o++;
            } else if (c == ' ') {
                empty++;
            }
        }

        if (Math.abs(x - o) > 1) {
            System.out.println("Impossible");
            return false;
        }

        if (board[0] == board[1] && board[1] == board[2] && board[0] == 'X' || board[3] == board[4] && board[4] == board[5] && board[3] == 'X' || board[6] == board[7] && board[7] == board[8] && board[6] == 'X' || board[0] == board[3] && board[3] == board[6] && board[0] == 'X' || board[1] == board[4] && board[4] == board[7] && board[1] == 'X' || board[2] == board[5] && board[5] == board[8] && board[2] == 'X' || board[0] == board[4] && board[4] == board[8] && board[0] == 'X' || board[2] == board[4] && board[4] == board[6] && board[2] == 'X') {
            xWin = true;
        }

        if (board[0] == board[1] && board[1] == board[2] && board[0] == 'O' || board[3] == board[4] && board[4] == board[5] && board[3] == 'O' || board[6] == board[7] && board[7] == board[8] && board[6] == 'O' || board[0] == board[3] && board[3] == board[6] && board[0] == 'O' || board[1] == board[4] && board[4] == board[7] && board[1] == 'O' || board[2] == board[5] && board[5] == board[8] && board[2] == 'O' || board[0] == board[4] && board[4] == board[8] && board[0] == 'O' || board[2] == board[4] && board[4] == board[6] && board[2] == 'O') {
            oWin = true;
        }

        if (oWin && xWin) {
            System.out.println("Impossible");
            return false;
        } else if (oWin) {
            System.out.println("O wins");
            return false;
        } else if (xWin) {
            System.out.println("X wins");
            return false;
        } else if (empty > 0) {
            //System.out.println("Game not finished");
            return true;
        } else {
            System.out.println("Draw");
            return false;
        }
    }

    private static void printBoard(char[] board) {
        System.out.println("---------");
        System.out.println("| " + board[0] + " " + board[1] + " " + board[2] + " |");
        System.out.println("| " + board[3] + " " + board[4] + " " + board[5] + " |");
        System.out.println("| " + board[6] + " " + board[7] + " " + board[8] + " |");
        System.out.println("---------");
    }

    public static void main(String[] args) {
        char[] board = new char[9];
        boolean playerXTurn = true;

        for (int i = 0; i < 9; i++) {
            board[i] = ' ';
        }

        printBoard(board);

        while (checkGameState(board)) {
            getUserMove(board, playerXTurn);
            playerXTurn = !playerXTurn;
        }

    }
}
