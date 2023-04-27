package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollisionControllerTest {
    private Entity entity;
    private PositionPart entityPositionPart;
    private Entity entity2;
    private PositionPart entity2PositionPart;
    private CollisionController instance;

    public CollisionControllerTest() {
    }

    @BeforeEach
    public void setUp() {
        instance = new CollisionController();
        entity = new Entity();
        entity2 = new Entity();

        entityPositionPart = new PositionPart(0,0,0);
        entity2PositionPart = new PositionPart(0,0,0);

        entity.add(entityPositionPart);
        entity2.add(entity2PositionPart);

        entity.setRadius(10);
        entity2.setRadius(10);
    }

/*    @Test
    public void Collision() {
        entityPositionPart.setPosition(0,0);
        entity2PositionPart.setPosition(0,0);

        Boolean expResult = true;
        Boolean result = instance.collides(entity, entity2);
        assertEquals(expResult, result);
    }*/

    @Test
    public void NoCollision() {
        entityPositionPart.setPosition(0,0);
        entity2PositionPart.setPosition(20,20);

        Boolean expResult = false;
        Boolean result = instance.collides(entity, entity2);
        assertEquals(expResult, result);
    }
}
