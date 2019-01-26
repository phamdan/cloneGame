package game.scene;

import game.GameObject;
import game.background.Background;
import game.box.Box;
import game.box.HitPoint;
import game.player.Player;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

public class SceneStage1 extends Scene {
    @Override
    void init() {
        GameObject.recycle(Background.class);
        GameObject.recycle(Player.class);
        GameObject.recycle(Box.class);
        GameObject.recycle(HitPoint.class);
    }

    @Override
    void clear() {
        GameObject.clearAll();
    }
}
