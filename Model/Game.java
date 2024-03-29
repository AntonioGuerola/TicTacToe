package Model;

import java.util.Arrays;

public class Game {
    public char[][] board;
    private char currentPlayer;

    public Game(char[][] board, char currentPlayer) {
        this.board = board;
        this.currentPlayer = currentPlayer;
    }

    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return currentPlayer == game.currentPlayer && Arrays.equals(board, game.board);
    }

    @Override
    public String toString() {
        return "Game{" +
                "board=" + Arrays.toString(board) +
                ", currentPlayer=" + currentPlayer +
                '}';
    }

    public void setCurrentPlayer(char currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Game() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }


    public boolean makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != '-') {
            return false;
        }

        board[row][col] = currentPlayer;
        return true;
    }

    public boolean isGameOver() {
        return hasPlayerWon('X') || hasPlayerWon('O') || isBoardFull();
    }

    private boolean hasPlayerWon(char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }


    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}