package dk.sdu.mmmi.cbse.bulletsystem;

import dk.sdu.mmmi.cbse.Bullet;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.ArrayList;
import java.util.Random;

public class BulletPlugin implements IGamePluginService {
    @Override
    public void start(GameData gameData, World world) {
        ArrayList bullets = new ArrayList<Entity>();
        for (int i = 0; i < 3; i++) {
            Entity bullet = createBullet(gameData);
            world.addEntity(bullet);
        }

    }

    private Entity createBullet(GameData gameData) {

        float deacceleration = 10;
        float acceleration = 25;
        float maxSpeed = 50;
        float rotationSpeed = 5;

        float x = gameData.getDisplayWidth();
        float y = gameData.getDisplayHeight();

        Random rand = new Random();
        float radians = rand.nextFloat(2*3.1415f);

        Entity bullet = new Bullet();
        bullet.add(new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed));
        bullet.add(new PositionPart(x, y, radians));

        return bullet;
    }

    @Override
    public void stop(GameData gameData, World world) {

    }
}
