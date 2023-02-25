package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.Asteroid;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.ArrayList;
import java.util.Random;

public class AsteroidPlugin implements IGamePluginService {
    @Override
    public void start(GameData gameData, World world) {
        ArrayList asteroids = new ArrayList<Entity>();
        for (int i = 0; i < 3; i++) {
            Entity asteroid = createAsteroid(gameData);
            world.addEntity(asteroid);
        }

    }

    private Entity createAsteroid(GameData gameData) {

        float deacceleration = 10;
        float acceleration = 25;
        float maxSpeed = 50;
        float rotationSpeed = 5;

        float x = gameData.getDisplayWidth();
        float y = gameData.getDisplayHeight();

        Random side = new Random();
        Random value = new Random();
        switch(side.nextInt(4)){
            case 0:
                x = value.nextFloat(gameData.getDisplayWidth());
                y = 0;
                break;
            case 1:
                x = value.nextFloat(gameData.getDisplayWidth());
                y = gameData.getDisplayHeight();
                break;
            case 2:
                y = value.nextFloat(gameData.getDisplayHeight());
                x = 0;
                break;
            case 3:
                y = value.nextFloat(gameData.getDisplayHeight());
                x = gameData.getDisplayWidth();
                break;
        }


        Random rand = new Random();
        float radians = rand.nextFloat(2*3.1415f);

        Entity asteroid = new Asteroid();
        asteroid.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        asteroid.add(new PositionPart(x, y, radians));
        asteroid.add(new LifePart(2));

        return asteroid;
    }

    @Override
    public void stop(GameData gameData, World world) {

    }
}
