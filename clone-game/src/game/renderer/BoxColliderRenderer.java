package game.renderer;

import game.GameObject;
import game.physics.BoxCollider;
import game.physics.Physics;

import java.awt.*;

public class BoxColliderRenderer extends Renderer {
    Color color;
    boolean isFill; // false = ve vien || true = to kin

    public BoxColliderRenderer() {
        this(Color.GREEN, false);
    }

    public BoxColliderRenderer(Color color, boolean isFill) {
        this.color = color;
        this.isFill = isFill;
    }

    @Override
    public void render(Graphics g, GameObject master) {
        if(master instanceof Physics) {
            g.setColor(this.color); // color
            Physics masterPhysics = (Physics)master;
            BoxCollider masterCollider = masterPhysics.getBoxCollider();
            if(this.isFill) {
                g.fillRect((int) masterCollider.left()
                        , (int) masterCollider.top()
                        , masterCollider.width
                        , masterCollider.height);
            } else {
                g.drawRect((int) masterCollider.left()
                        , (int) masterCollider.top()
                        , masterCollider.width
                        , masterCollider.height);
            }
        }
    }
}
