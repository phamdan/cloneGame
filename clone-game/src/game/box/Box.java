package game.box;

import game.GameObject;
import game.GameObjectPhysics;
import game.physics.BoxCollider;
import game.renderer.BoxColliderRenderer;

import javax.swing.*;
import java.awt.*;

public class Box extends GameObjectPhysics {
    public Box() {
        this.boxCollider = new BoxCollider(this.position, this.anchor
                , 14, 14);
        this.renderer = new BoxColliderRenderer(Color.BLACK, false);
        this.position.set(130, 110);
    }

    @Override
    public void run() {
        super.run();
        HitPoint point = GameObject.findByPosition(HitPoint.class, this.position);
        if(point != null) {
            JOptionPane.showMessageDialog(null
                    , "You won!");
        }
    }
}
