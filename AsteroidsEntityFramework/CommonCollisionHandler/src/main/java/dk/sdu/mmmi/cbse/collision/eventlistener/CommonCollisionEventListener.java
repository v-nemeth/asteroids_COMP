package dk.sdu.mmmi.cbse.collision.eventlistener;

import dk.sdu.mmmi.cbse.common.events.Event;
import dk.sdu.mmmi.cbse.common.events.EventType;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.entities.Bullet;
import dk.sdu.mmmi.cbse.common.entities.Player;
import dk.sdu.mmmi.cbse.common.events.CollisionEvent;
import dk.sdu.mmmi.cbse.common.services.IEventListener;

public class CommonCollisionEventListener implements IEventListener {
    @Override
    public void onEvent(Event event, GameData gameData, World world) {
        if(event.getEventType() == EventType.COLLISION){
            String entityID = ((CollisionEvent) event).getEntityID();

            if(world.getEntity(entityID) instanceof Bullet || world.getEntity(entityID) instanceof Player) {
                world.removeEntity(entityID);
            }
        }
    }
}
