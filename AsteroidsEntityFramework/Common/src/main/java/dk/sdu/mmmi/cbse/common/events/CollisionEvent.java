package dk.sdu.mmmi.cbse.common.events;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.Event;
import dk.sdu.mmmi.cbse.common.data.EventType;

public class CollisionEvent extends Event {
    private Entity entity1;
    private Entity entity2;

    public CollisionEvent(Entity entity1, Entity entity2) {
        this.eventType = EventType.COLLISION;
        this.entity1 = entity1;
        this.entity2 = entity2;
    }

    @Override
    public String toString() {
        return "CollisionEvent{" + "entity1=" + entity1 + ", entity2=" + entity2 + '}';
    }
}
