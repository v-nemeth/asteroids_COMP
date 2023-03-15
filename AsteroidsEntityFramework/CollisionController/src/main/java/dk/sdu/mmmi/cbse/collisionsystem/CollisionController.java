package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.asteroid.Asteroid;
import dk.sdu.mmmi.cbse.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
import dk.sdu.mmmi.cbse.player.Player;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public class CollisionController implements IPostEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
        // CHECK ENTITY COLLISION
        for (Entity entity : world.getEntities()){
            for (Entity entity2 : world.getEntities()){
                if (collides(entity, entity2)){
                    if (entity.getID().equals(entity2.getID()) || entity.getClass().equals(entity2.getClass())){
                        continue;
                    }

                    LifePart lifePart1 = entity.getPart(LifePart.class);
                    LifePart lifePart2 = entity2.getPart(LifePart.class);

                    if (!(lifePart1 == null)) lifePart1.setIsHit(true);
                    if (!(lifePart2 == null)) lifePart2.setIsHit((true));

                }
            }
        }

        //CHECK PLAYER COLLISION
/*        for(Entity asteroid : world.getEntities(Asteroid.class)){
            for(Entity player : world.getEntities(Player.class)){
                if(collides(asteroid,player)){
                    world.removeEntity(player);
                }
            }
        }
        //CHECK BULLET COLLISION
        for(Entity bullet : world.getEntities(Bullet.class)){
            for(Entity asteroid : world.getEntities(Asteroid.class)){
                LifePart asteroidLifePart = asteroid.getPart(LifePart.class);
                if(collides(asteroid,bullet)){
                    asteroidLifePart.setIsHit(true);
                    world.removeEntity(bullet);
                }
            }
        }*/

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
