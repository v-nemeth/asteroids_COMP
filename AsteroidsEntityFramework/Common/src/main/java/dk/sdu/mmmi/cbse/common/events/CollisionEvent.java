package dk.sdu.mmmi.cbse.common.events;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.Event;
import dk.sdu.mmmi.cbse.common.data.EventType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollisionEvent extends Event {
    private String entity1ID;
    private String entity2ID;

    public CollisionEvent(String entity1ID, String entity2ID) {
        this.eventType = EventType.COLLISION;
        this.entity1ID = entity1ID;
        this.entity2ID = entity2ID;
    }

    public String getEntityID() {
        return entity1ID;
    }

    public String getTargetID(){
        return entity2ID;
    }
}
