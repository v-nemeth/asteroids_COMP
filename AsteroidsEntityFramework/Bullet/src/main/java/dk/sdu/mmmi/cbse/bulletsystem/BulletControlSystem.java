package dk.sdu.mmmi.cbse.bulletsystem;

import dk.sdu.mmmi.cbse.bullet.Bullet;
//import dk.sdu.mmmi.cbse.player.Player;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.ShootingPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;


/**
 *
 * @author jcs
 */
public class BulletControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {

        for(Entity player : world.getEntities()) {
            ShootingPart shootingPart = player.getPart(ShootingPart.class);
            PositionPart playerPositionPart = player.getPart(PositionPart.class);
            if (shootingPart == null) continue;
            if(shootingPart.getShoot()){
                world.addEntity(
                        createBullet(
                                playerPositionPart.getX(),
                                playerPositionPart.getY(),
                                playerPositionPart.getRadians()));
            }
        }


        for (Entity bullet : world.getEntities(Bullet.class)) {
            if(((Bullet)bullet).isDead()){
                world.removeEntity(bullet);
                continue;
            }
            PositionPart positionPart = bullet.getPart(PositionPart.class);
            MovingPart movingPart = bullet.getPart(MovingPart.class);

            movingPart.setUp(true);
            
            movingPart.process(gameData, bullet);
            positionPart.process(gameData, bullet);

            updateShape(bullet);
        }
    }

    private void updateShape(Entity entity) {
        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapex[0] = (float) (x + Math.cos(radians) * 5);
        shapey[0] = (float) (y + Math.sin(radians) * 5);

        shapex[1] = (float) (x + Math.cos(radians - 5 * 3.1415f / 5) * 5);
        shapey[1] = (float) (y + Math.sin(radians - 5 * 3.1145f / 5) * 5);

        shapex[2] = (float) (x + Math.cos(radians + 3.1415f) * 5);
        shapey[2] = (float) (y + Math.sin(radians + 3.1415f) * 5);

        shapex[3] = (float) (x + Math.cos(radians + 5 * 3.1415f / 5) * 5);
        shapey[3] = (float) (y + Math.sin(radians + 5 * 3.1415f / 5) * 5);

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }

    private Entity createBullet(float x, float y, float radians) {
        float deacceleration = 20;
        float acceleration = 1000000;
        float maxSpeed = 300;
        float rotationSpeed = 5;

        Entity bullet = new Bullet();
        bullet.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        bullet.add(new PositionPart(x, y, radians));

        return bullet;
    }

}
