package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Random;

public class AsteroidControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {

        for (Entity asteroid : world.getEntities(Asteroid.class)) {

            PositionPart positionPart = asteroid.getPart(PositionPart.class);
            MovingPart movingPart = asteroid.getPart(MovingPart.class);

            movingPart.setUp(true);


            movingPart.process(gameData, asteroid);
            positionPart.process(gameData, asteroid);

            updateShape(asteroid);
        }
    }

    private void updateShape(Entity entity) {
        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();


        shapex[0] = (float) (x + Math.cos(radians) * ((Asteroid)entity).get_random_values()[0]);
        shapey[0] = (float) (y + Math.sin(radians) * ((Asteroid)entity).get_random_values()[0]);

        shapex[1] = (float) (x + Math.cos(radians - 8 * 3.1815f / 16) * ((Asteroid)entity).get_random_values()[1]);
        shapey[1] = (float) (y + Math.sin(radians - 8 * 3.1185f / 16) * ((Asteroid)entity).get_random_values()[1]);

        shapex[2] = (float) (x + Math.cos(radians + 3.1815f) * ((Asteroid)entity).get_random_values()[2]);
        shapey[2] = (float) (y + Math.sin(radians + 3.1815f) * ((Asteroid)entity).get_random_values()[2]);

        shapex[3] = (float) (x + Math.cos(radians + 8 * 3.1815f / 16) * ((Asteroid)entity).get_random_values()[3]);
        shapey[3] = (float) (y + Math.sin(radians + 8 * 3.1815f / 16) * ((Asteroid)entity).get_random_values()[3]);

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }
}
