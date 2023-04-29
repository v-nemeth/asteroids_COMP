package dk.sdu.mmmi.cbse.asteroid.collisionhandler;

import dk.sdu.mmmi.cbse.common.data.*;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.entities.Asteroid;
import dk.sdu.mmmi.cbse.common.events.CollisionEvent;
import dk.sdu.mmmi.cbse.common.services.IEventListener;

import java.util.Random;

public class AsteroidCollisionEventListener implements IEventListener {

    @Override
    public void onEvent(Event event, GameData gameData, World world) {
        if(event.getEventType() == EventType.COLLISION){
            Asteroid asteroid = getAsteroid((CollisionEvent) event, world);

            if(asteroid != null){processCollision(asteroid, world);}
        }
    }
    private Asteroid getAsteroid(CollisionEvent event, World world){
        if(world.getEntity(event.getEntityID()) instanceof Asteroid){
            return (Asteroid) world.getEntity(event.getEntityID());
        }
        return null;
    }

    private void processCollision(Asteroid asteroid, World world){
        LifePart lifePart = asteroid.getPart(LifePart.class);
        lifePart.setLife(lifePart.getLife() - 1);
        PositionPart positionPart = asteroid.getPart(PositionPart.class);

        if(lifePart.isDead()){
            world.removeEntity(asteroid);
        } else {
            createNewAsteroids(world, positionPart.getX(), positionPart.getY(), lifePart.getLife(), (int) Math.floor(((Asteroid)asteroid).getSize() * 3/5));
            world.removeEntity(asteroid);
        }
    }

    private void createNewAsteroids(World world, float x, float y, int life, int size){
        world.addEntity(createSmallerAsteroid(size, x, y, life));
        world.addEntity(createSmallerAsteroid(size, x, y, life));
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
}
