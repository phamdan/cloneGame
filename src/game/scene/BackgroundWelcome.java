package game.scene;

import game.*;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

public class BackgroundWelcome extends GameObject {
    FrameCounter waitCounter;

    public BackgroundWelcome() {
        this.renderer = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/background/background-welcome.png"));
        this.position.set(Settings.SCREEN_WIDTH / 2, Settings.SCREEN_HEIGHT / 2);
        this.waitCounter = new FrameCounter(30);
    }

    @Override
    public void run() {
        super.run();
        if(this.waitCounter.run() && GameWindow.isAnyKeyPress) {
            SceneManager.signNewScene(new SceneStage1());
        }
    }
}
