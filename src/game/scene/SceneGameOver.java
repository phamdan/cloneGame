package game.scene;

import game.GameObject;
import game.GameWindow;

public class SceneGameOver extends Scene {
    @Override
    void init() {
        GameObject.recycle(BackgroundGameOver.class);
    }

    @Override
    void clear() {
        // clear
        GameObject.clearAll();
        GameWindow.isAnyKeyPress = false;
    }
}
