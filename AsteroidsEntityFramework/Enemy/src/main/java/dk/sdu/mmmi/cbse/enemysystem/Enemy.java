package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;

import java.util.Random;

/**
 *
 * @author corfixen
 */
public class Enemy extends Entity {
    private boolean direction;
    private boolean turn;
    private boolean accelerate;

    public int updateEnemy() {
        Random rand = new Random();
        int i = rand.nextInt(3);
        switch (i) {
            case 0:
                direction = false;
                turn = true;
                accelerate = false;
                break;
            case 1:
                direction = true;
                turn = true;
                accelerate = false;
                break;
            case 2:
                accelerate = true;
                turn = false;
                break;
        }
        return i;
    }

    public boolean getDirection(){
        return direction;
    }
    public boolean getTurn(){
        return turn;
    }
    public boolean getAccelerate(){
        return accelerate;
    }
}
