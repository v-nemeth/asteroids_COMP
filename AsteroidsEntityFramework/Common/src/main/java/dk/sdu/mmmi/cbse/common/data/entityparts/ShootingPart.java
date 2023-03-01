package dk.sdu.mmmi.cbse.common.data.entityparts;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;

public class ShootingPart implements EntityPart{

    private boolean shoot;
    private int timeSinceLastShot = 100;

    private int reload = 50;

    public void setShoot(boolean shoot) {
        if(timeSinceLastShot > reload){
            this.shoot = shoot;
        }
        else this.shoot = false;
    }
    public boolean getShoot(){
        return shoot;
    }

    @Override
    public void process(GameData gameData, Entity entity) {
        if(shoot && timeSinceLastShot > reload){
            timeSinceLastShot = 0;
        }
        timeSinceLastShot++;
    }
}
