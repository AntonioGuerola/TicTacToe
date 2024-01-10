package View;

import java.util.Scanner;

import Model.Game;

public class MainView {
    private static Scanner scanner;
    private static Game game;

    public void View(Game game) {
        scanner = new Scanner(System.in);
        this.game = game;
    }

    public static void startGame() {
        boolean gameInProgress = true;

        while (gameInProgress) {
            displayBoard();
            System.out.println("Player " + game.getCurrentPlayer() + "'s turn");
            System.out.print("Enter row and column (e.g., 1 2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (game.makeMove(row, col)) {
                if (game.isGameOver()) {
                    displayBoard();
                    System.out.println("Player " + game.getCurrentPlayer() + " wins!");
                    gameInProgress = false;
                } else {
                    game.switchPlayer();
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        scanner.close();
    }

    private static void displayBoard() {
        // Lógica para mostrar el tablero en consola
        System.out.println("-------------");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + game.board[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("-------------");
        }
    }

}
