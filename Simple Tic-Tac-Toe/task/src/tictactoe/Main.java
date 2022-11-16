package tictactoe;

import java.util.Scanner;

public class Main {

    public static void checkGameState(char[] board) {
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
            } else if (c == '_') {
                empty++;
            }
        }

        if (Math.abs(x - o) > 1) {
            System.out.println("Impossible");
            return;
        }

        if (board[0] == board[1] && board[1] == board[2] && board[0] == 'X' || board[3] == board[4] && board[4] == board[5] && board[3] == 'X' || board[6] == board[7] && board[7] == board[8] && board[6] == 'X' || board[0] == board[3] && board[3] == board[6] && board[0] == 'X' || board[1] == board[4] && board[4] == board[7] && board[1] == 'X' || board[2] == board[5] && board[5] == board[8] && board[2] == 'X' || board[0] == board[4] && board[4] == board[8] && board[0] == 'X' || board[2] == board[4] && board[4] == board[6] && board[2] == 'X') {
            xWin = true;
        }

        if (board[0] == board[1] && board[1] == board[2] && board[0] == 'O' || board[3] == board[4] && board[4] == board[5] && board[3] == 'O' || board[6] == board[7] && board[7] == board[8] && board[6] == 'O' || board[0] == board[3] && board[3] == board[6] && board[0] == 'O' || board[1] == board[4] && board[4] == board[7] && board[1] == 'O' || board[2] == board[5] && board[5] == board[8] && board[2] == 'O' || board[0] == board[4] && board[4] == board[8] && board[0] == 'O' || board[2] == board[4] && board[4] == board[6] && board[2] == 'O') {
            oWin = true;
        }

        if (oWin && xWin) {
            System.out.println("Impossible");
        } else if (oWin) {
            System.out.println("O wins");
        } else if (xWin) {
            System.out.println("X wins");
        } else if (empty > 0) {
            System.out.println("Game not finished");
        } else {
            System.out.println("Draw");
        }
    }

    public static void main(String[] args) {
        char[] board = new char[9];
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        for (int i = 0; i < 9; i++) {
            board[i] = input.charAt(i);
        }

        System.out.println("---------");
        System.out.println("| " + board[0] + " " + board[1] + " " + board[2] + " |");
        System.out.println("| " + board[3] + " " + board[4] + " " + board[5] + " |");
        System.out.println("| " + board[6] + " " + board[7] + " " + board[8] + " |");
        System.out.println("---------");

        checkGameState(board);

    }
}
