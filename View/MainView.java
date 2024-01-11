package View;

import java.util.Scanner;

import Model.Game;
import UI.UI;

public class MainView {
    private static Scanner scanner;
    private static Game game = new Game();

    public MainView(Game game) {
        this.scanner = new Scanner(System.in);
        this.game = game;
    }

    public static void welcome(){
        System.out.println("Welcome to this fantastic Tic Tac Toe game:");
        UI.pressEnter();
    }
    public static void startGame(Game game) {
        boolean gameInProgress = true;

        while (gameInProgress) {
            displayBoard();
            System.out.println("Player " + game.getCurrentPlayer() + "'s turn");
            int row = UI.readInt("Enter row");
            int col = UI.readInt("Enter col");

            if (game.makeMove(row, col)) {
                if (!game.isGameOver()) {
                    game.switchPlayer();
                } else {
                    displayBoard();
                    System.out.println("Player " + game.getCurrentPlayer() + " wins!");
                    gameInProgress = false;
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        scanner.close();
    }

    private static void displayBoard() {
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
