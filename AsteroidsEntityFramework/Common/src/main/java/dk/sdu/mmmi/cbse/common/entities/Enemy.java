package dk.sdu.mmmi.cbse.common.entities;

import dk.sdu.mmmi.cbse.common.data.Entity;

import java.util.Random;

public class Enemy extends Entity {
    private boolean direction;
    private boolean turn;
    private boolean accelerate;

    public Enemy(float[] color){
        super.setColor(color);
    }

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
