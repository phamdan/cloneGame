package game.player;

import game.*;
import game.box.Box;
import game.physics.BoxCollider;
import game.renderer.BoxColliderRenderer;

import java.awt.*;

public class Player extends GameObjectPhysics {
    int direction; // 1 = top, 2 = right, 3 = bot, 4 = left, 0 = stay
    FrameCounter moveCounter;

    public Player() {
        this.boxCollider = new BoxCollider(this.position, this.anchor
                , 16, 16);
        this.renderer = new BoxColliderRenderer(Color.BLUE, true);
        this.position.set(110, 110);
        this.direction = Settings.STAY;
        this.moveCounter = new FrameCounter(10);
    }

    @Override
    public void run() {
        super.run();
        this.setDirection();
        this.move();
    }

    private void setDirection() {
        if(GameWindow.isUpPress) {
            this.direction = Settings.TOP;
        } else if(GameWindow.isRightPress) {
            this.direction = Settings.RIGHT;
        } else if(GameWindow.isDownPress) {
            this.direction = Settings.BOT;
        } else if(GameWindow.isLeftPress) {
            this.direction = Settings.LEFT;
        } else {
            this.direction = Settings.STAY;
        }
    }

    private void move() {
        if(this.moveCounter.run()) {
            Box box = this.findBoxAhead();
            float vx = 0, vy = 0;
            switch (this.direction) {
                case Settings.TOP: {
                    vy = -Settings.WAY_SIZE;
                    break;
                }
                case Settings.RIGHT: {
                    vx = Settings.WAY_SIZE;
                    break;
                }
                case Settings.BOT: {
                    vy = Settings.WAY_SIZE;
                    break;
                }
                case Settings.LEFT: {
                    vx = -Settings.WAY_SIZE;
                    break;
                }
            }
            if(this.direction != Settings.STAY) {
                this.position.addThis(vx, vy);
                if(box != null) {
                    box.position.addThis(vx, vy);
                }
                this.moveCounter.reset();
            }
        }
    }

    public Box findBoxAhead() {
        int vx = 0, vy = 0;
        switch (this.direction) {
            case Settings.TOP: {
                vy = -Settings.WAY_SIZE;
                break;
            }
            case Settings.BOT: {
                vy = Settings.WAY_SIZE;
                break;
            }
            case Settings.LEFT: {
                vx = -Settings.WAY_SIZE;
                break;
            }
            case Settings.RIGHT: {
                vx = Settings.WAY_SIZE;
                break;
            }
        }
        Vector2D aheadPosition = this.position.add(vx, vy);
        Box box = GameObject.findByPosition(Box.class, aheadPosition);
        return box;
    }
}
