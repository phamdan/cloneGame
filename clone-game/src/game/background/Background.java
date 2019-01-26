package game.background;

import game.GameObject;
import game.Settings;

import java.awt.*;

public class Background extends GameObject {
    public Background() {
        this.anchor.set(0, 0);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        for (int i = 0; i < Settings.ROW_COUNT; i++) {
            g.drawLine(0, i * Settings.WAY_SIZE
                    , Settings.SCREEN_WIDTH, i * Settings.WAY_SIZE);
        }
        for (int i = 0; i < Settings.COL_COUNT; i++) {
            g.drawLine(i * Settings.WAY_SIZE, 0
                    , i * Settings.WAY_SIZE, Settings.SCREEN_HEIGHT);
        }
    }
}
