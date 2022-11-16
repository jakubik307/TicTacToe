package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        System.out.println("---------");
        System.out.println("| " + input.charAt(0) + " " + input.charAt(1) + " " + input.charAt(2) + " |");
        System.out.println("| " + input.charAt(3) + " " + input.charAt(4) + " " + input.charAt(5) + " |");
        System.out.println("| " + input.charAt(6) + " " + input.charAt(7) + " " + input.charAt(8) + " |");
        System.out.println("---------");
    }
}
