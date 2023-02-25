package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.Asteroid;
import dk.sdu.mmmi.cbse.Player;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class CollisionController implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
        //CHECK ASTEROID COLLISION
        for(Entity asteroid : world.getEntities(Asteroid.class)){
            for(Entity player : world.getEntities(Player.class)){
                if(collides(asteroid,player)){
                    world.removeEntity(player);
                }
            }
        }
    }

    public Boolean collides(Entity entity, Entity entity2){
        PositionPart entMov = entity.getPart(PositionPart.class);
        PositionPart entMov2 = entity2.getPart(PositionPart.class);
        float dx = (float) entMov.getX() - (float) entMov2.getX();
        float dy = (float) entMov.getY() - (float) entMov2.getY();
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        if (distance < (entity.getRadius() + entity2.getRadius())) {
            return true;
        }
        return false;
    }
}
