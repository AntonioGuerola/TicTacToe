package Model;

import java.util.Arrays;
import java.util.Objects;

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
        // Lógica para inicializar el tablero
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = '-';
                }
            }
        }


    public boolean makeMove(int row, int col) {
        // Lógica para hacer un movimiento
            if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != '-') {
                return false; // Movimiento inválido si la celda está fuera del tablero o no está vacía
            }

            board[row][col] = currentPlayer;
            return true;
        }

    public boolean isGameOver() {
        // Lógica para verificar si el juego ha terminado
        return hasPlayerWon('X') || hasPlayerWon('O') || isBoardFull();
    }

    private boolean hasPlayerWon(char player) {
        // Verificar filas, columnas y diagonales para el jugador actual
        for (int i = 0; i < 3; i++) {
            // Verificar filas y columnas
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        // Verificar diagonales
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    private boolean isBoardFull() {
        // Verificar si todas las celdas están ocupadas
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false; // Aún hay celdas vacías, el juego no ha terminado
                }
            }
        }
        return true; // El tablero está lleno
    }


    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}