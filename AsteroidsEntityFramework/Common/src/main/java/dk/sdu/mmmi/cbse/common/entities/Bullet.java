package dk.sdu.mmmi.cbse.common.entities;

import dk.sdu.mmmi.cbse.common.data.Entity;

public class Bullet extends Entity {

    int lifetime = 125;
    public Bullet () {

    }

    public boolean isDead(){
        if(lifetime < 0) return true;
        lifetime--;
        return false;
    }

}
