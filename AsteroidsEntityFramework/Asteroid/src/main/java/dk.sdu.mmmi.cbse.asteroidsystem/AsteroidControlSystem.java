package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.Event;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.entities.Asteroid;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IEventListener;

import java.util.Random;

public class AsteroidControlSystem implements IEntityProcessingService, IEventListener {

    @Override
    public void process(GameData gameData, World world) {

        for (Entity asteroid : world.getEntities(Asteroid.class)) {

            PositionPart positionPart = asteroid.getPart(PositionPart.class);
            MovingPart movingPart = asteroid.getPart(MovingPart.class);
            LifePart lifePart = asteroid.getPart(LifePart.class);

            movingPart.setUp(true);
            movingPart.process(gameData, asteroid);
            positionPart.process(gameData, asteroid);
            updateShape(asteroid);

            if(lifePart.isIsHit()){
                if(lifePart.isDead()){
                    world.removeEntity(asteroid);
                } else {
                    int size = (int) Math.floor(((Asteroid)asteroid).getSize() * 3/5);
                    float x = positionPart.getX();
                    float y = positionPart.getY();
                    int life = lifePart.getLife()-1;
                    world.addEntity(createSmallerAsteroid(size, x, y, life));
                    world.addEntity(createSmallerAsteroid(size, x, y, life));
                    world.removeEntity(asteroid);
                }
            }
            lifePart.process(gameData,asteroid);

        }
    }

    private Entity createSmallerAsteroid(int size, float x, float y, int life) {
        float deacceleration = 10;
        float acceleration = 25;
        float maxSpeed = 50;
        float rotationSpeed = 5;

        Entity asteroid = new Asteroid(size);
        asteroid.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        Random rand = new Random();
        asteroid.add(new PositionPart(x, y, rand.nextFloat(2*3.1415f)));
        asteroid.add(new LifePart(life));

        return asteroid;
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

    @Override
    public void onEvent(Event event, GameData gameData, World world) {
        System.out.println(event);
    }
}
