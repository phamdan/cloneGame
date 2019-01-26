package game.box;

import game.GameObjectPhysics;
import game.physics.BoxCollider;
import game.renderer.BoxColliderRenderer;

import java.awt.*;

public class HitPoint extends GameObjectPhysics {
    public HitPoint() {
        this.boxCollider = new BoxCollider(this.position, this.anchor
                , 16, 16);
        this.renderer = new BoxColliderRenderer(Color.RED, false);
        this.position.set(530, 510);
    }
}
