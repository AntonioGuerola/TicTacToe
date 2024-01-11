package Controller;

import Model.Game;
import View.MainView;

public class MainController {
    private static Game game = new Game();
    public static void startGame() {
        MainView mainView = new MainView(game);
        MainView.startGame(game);
    }
}

